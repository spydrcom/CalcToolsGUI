
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Symbol;

import net.myorb.calctools.libraries.Keyword;

import net.myorb.math.expressions.OperatorNomenclature;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.ExtendedKeywordCommand;
import net.myorb.math.expressions.commands.KeywordCommand;

/**
 * a common base class for description of command keywords
 * @author Michael Druckman
 */
public class Command extends Symbol
{

	public Command (Keyword library)
	{
		super (library); this.library = library;
	}
	Keyword library;

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#getAlgorithmAccess()
	 */
	public String getAlgorithmAccess ()
	{
		return library.getPrefix() + reference + library.getSuffix();
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#setImplementation(java.lang.Object)
	 */
	public void setImplementation (Object implementation)
	{
		super.setImplementation (implementation);
		this.keywordCommand = (KeywordCommand) implementation;

		if (this.description != null) return;
		this.setDescription (keywordCommand.describe ());
	}
	protected KeywordCommand keywordCommand;

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#symbolType()
	 */
	public String symbolType () { return " {KEY} "; }

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#applyConfiguration()
	 */
	public Object applyConfiguration () { return null; }

	/**
	 * construct a KeywordCommand for the identified implementation.
	 *  meta-data connected to this Command object will become associated
	 * @return a wrapper to hold original version with new annotations
	 */
	public KeywordCommand getKeywordCommand ()
	{
		return new CommandWrapper (keywordCommand, this.description);
	}

	/**
	 * @param keyword the text of the reference and case-independent symbol
	 */
	public void setKeyword (String keyword)
	{
		this.symbol = keyword.toUpperCase ();
		this.reference = keyword;
	}

	/**
	 * @param fieldName the name of the symbol from OperatorNomenclature
	 */
	public void setSymbolUsing (String fieldName)
	{
		try
		{
			Class<?> c = OperatorNomenclature.class;
			this.symbol = c.getField (fieldName).get (null).toString ();
		}
		catch (Exception e) { throw new RuntimeException ("Unable to set symbol name"); }
	}

}


/**
 * KeywordCommand implementation for wrapping another KeywordCommand
 */
class CommandWrapper implements ExtendedKeywordCommand
{

	CommandWrapper (KeywordCommand wrapped, String description)
	{
		this.wrapped = wrapped;
		this.description = description;

		if (wrapped instanceof ExtendedKeywordCommand)
		{
			keywords = ( (ExtendedKeywordCommand) wrapped ).includingSubordinateKeywords () ;
		}
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.commands.KeywordCommand#execute(net.myorb.math.expressions.commands.CommandSequence)
	 */
	public void execute (CommandSequence tokens) { wrapped.execute (tokens); }
	protected KeywordCommand wrapped;

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.commands.KeywordCommand#describe()
	 */
	public String describe () { return description; }
	protected String description;

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.commands.ExtendedKeywordCommand#includingSubordinateKeywords()
	 */
	public String[] includingSubordinateKeywords () { return keywords; }
	public static final String[] NONE = new String[]{};
	protected String[] keywords = NONE;

}

