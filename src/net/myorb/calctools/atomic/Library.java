
package net.myorb.calctools.atomic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * a common base class to define libraries of symbols
 * @author Michael Druckman
 */
public class Library extends ArrayList<Symbol>
{

	public static final HashMap<String, Symbol> symbols = new HashMap<>();;

	/**
	 * @param symbol a symbol to check
	 * @return the overridden instance or NULL if unique
	 */
	public Symbol overrideCheck (Symbol symbol)
	{
		Symbol overridden = null;
		String name = symbol.getSymbol ();
		if (symbols.containsKey (name))
		{
			overridden = symbols.get (name);
			System.out.println
			(
				"Symbol Override Detected for '" + symbol.getSymbol () +
				"' from library '" + overridden.getLibrary ().getName () +
				"' by instance in '" + symbol.getLibrary ().getName () + "'"
			);
		}
		symbols.put (name, symbol);
		return overridden;
	}

	/**
	 * show connected object for application
	 * @param item an object connected to this library
	 */
	public void connect (Object item)
	{
		System.out.println (item);
	}
	public void connectedTo (Object[] items)
	{
		for (Object item : items)
		{ System.out.println (item); }
	}

	/**
	 * show library name in system.out dump
	 */
	public void trace ()
	{
		System.out.println ();
		System.out.println ("Library: " + name);
	}

	/**
	 * @return the name assigned to the library
	 */
	public String getName () { return name; }
	public void setName (String name) { this.name = name; trace (); }
	protected String name = "*NA*";

	private static final long serialVersionUID = -4310968244880016276L;

}
