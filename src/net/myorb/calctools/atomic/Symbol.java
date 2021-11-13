
package net.myorb.calctools.atomic;

import net.myorb.math.expressions.symbols.Parameterization;
import net.myorb.math.expressions.ConventionalNotations;

import java.lang.Comparable;

/**
 * a common base class for symbols to organize properties as a bean
 * @author Michael Druckman
 */
public class Symbol implements Comparable<Symbol>
{


	public Symbol (Library library)
	{
		library.add (this);
		setLibrary (library);
	}


	/**
	 * @return the library object specified for this symbol
	 */
	public Library getLibrary () { return library; }
	public void setLibrary (Library library) { this.library = library; }
	protected Library library;


	/**
	 * @return the symbol overrides this
	 */
	public Symbol getOverridden () { return overridden; }
	public void setOverridden (Symbol overridden) { this.overridden = overridden; }
	protected Symbol overridden;


	/**
	 * @return the symbol overridden by this
	 */
	public Symbol getOverrides () { return overridden; }
	public void setOverrides (Symbol overrides) { this.overrides = overrides; }
	protected Symbol overrides;


	/**
	 * @return the text of the specified symbol string
	 */
	public String getSymbol () { return symbol; }
	public void setSymbol (String symbol)
	{
		Symbol check;
		this.symbol = symbol;
		check = this.library.overrideCheck (this);
		if (check != null) check.setOverridden (this);
		this.setOverrides (check);
	}
	protected String symbol;


	/**
	 * @return the text of the specified description string
	 */
	public String getDescription () { return description; }
	public void setDescription (String description) { this.description = description; }
	protected String description = null;


	/**
	 * @return the text of the specified reference string
	 */
	public String getReference () { return reference; }
	public void setReference (String reference) { this.reference = reference; }
	protected String reference;


	/**
	 * @return the text of configured parameters
	 */
	public String getParameters () { return parameters; }
	public void setParameters (String parameters) { this.parameters = parameters; }
	protected String parameters = null;


	/**
	 * @param renderAs the text to use to render the symbol
	 */
	public void setRenderAs (String renderAs)
	{
		System.out.println (symbol + "  (" + reference + ")  to render as " + renderAs);
		ConventionalNotations.setNotationFor (symbol, renderAs);
		renderedAs = renderAs;
	}
	String renderedAs = "";


	/**
	 * @return a reference name formatted from the reference setting
	 */
	public String getAlgorithmAccess ()
	{
		return "get" + reference + "Algorithm";
	}


	/**
	 * @param implementation access to the implementation of th symbol
	 */
	public void setImplementation (Object implementation)
	{
		this.implementation = implementation;
	}
	protected Object implementation;


	/**
	 * @return object as a parameterizable entity
	 */
	public Parameterization getParameterization ()
	{
		throw new RuntimeException ("Symbol does not accept Parameterization");
	}


	/**
	 * processing for name/value pairs
	 * @param parms an array of NV pairs separated by EQ signs
	 * @return NULL - only a function to allow chaining
	 */
	public Object applyConfiguration (String [] parms)
	{
		Parameterization parameterizable = getParameterization ();
		for (String parm : parms)
		{
			String[] nv = parm.split ("=");
			parameterizable.addParameterization (nv[0], nv[1]);
		}
		return null;
	}


	/**
	 * a request to perform any required configuration as supplied by specified parameters
	 * @return NULL - only a function to allow chaining
	 */
	public Object applyConfiguration ()
	{
		try
		{
			if (parameters == null) return null;
			String [] multi = parameters.split (";");
			if (multi.length > 1) return applyConfiguration (multi);
			getParameterization ().addParameterization (parameters);
		}
		catch (Exception e)
		{
			this.implementation = null;
		}
		return null;
	}


	/**
	 * @return a reference to this object
	 */
	public Object getMe ()
	{
		return this;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		return new StringBuffer ()
			.append (this.reference)
			.append (" (").append (this.symbol).append (")")
			.append (symbolType ()).append (rendering ())
			.append (overridden==null? "": " <" + overridden.getLibrary ().getName () + "> ")
			.append (overrides==null? "": " >" + overrides.getLibrary ().getName () + "< ")
			.append (implementation==null? " * ": "")
			.append ("- ").append (description)
		.toString ();
	}


	/**
	 * @return the rendering string
	 */
	public String rendering ()
	{
		if (renderedAs.length () > 0)
			return "'" + renderedAs + "' ";
		return renderedAs;
	}


	/**
	 * @return description of symbol type
	 */
	public String symbolType () { return ""; }


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo (Symbol item)
	{
		if (item == null) return 0;
		return this.symbol.compareTo (item.symbol);
	}


}
