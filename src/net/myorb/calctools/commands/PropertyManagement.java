
package net.myorb.calctools.commands;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.data.abstractions.SimplePropertiesManager;
import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;

/**
 * commands related to Property Management
 * @author Michael Druckman
 */
public class PropertyManagement<T> extends Context<T>
{


	public PropertyManagement
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * Set the value of a property
	 * @return a keyword command for the PSET command
	 */
	public KeywordCommand constructPsetCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ SimplePropertiesManager.pset (withCommandRemoved (tokens)); }
			public String describe () { return "Set the value of a property"; }
		};
	}


	/**
	 * Delete the value of a property
	 * @return a keyword command for the PDEL command
	 */
	public KeywordCommand constructPdelCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ SimplePropertiesManager.pdel (withCommandRemoved (tokens)); }
			public String describe () { return "Delete the value of a property"; }
		};
	}


	/**
	 * Clear all properties of a directory entry
	 * @return a keyword command for the PCLR command
	 */
	public KeywordCommand constructPclrCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ SimplePropertiesManager.pclr (withCommandRemoved (tokens)); }
			public String describe () { return "Clear all properties of a directory entry"; }
		};
	}


	/**
	 * Load properties of a directory entry from jSON source
	 * @return a keyword command for the PLOAD command
	 */
	public KeywordCommand constructPloadCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{
				String entry = getNextOperandToken (tokens).getTokenImage ();
				SimplePropertiesManager.pload (entry, fileFor (filename (tokens)));
			}
			public String describe () { return "Load properties of a directory entry from jSON source"; }
		};
	}


	/**
	 * Save properties of a directory entry to jSON file
	 * @return a keyword command for the PSAVE command
	 */
	public KeywordCommand constructPsaveCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{
				String entry = getNextOperandToken (tokens).getTokenImage ();
				SimplePropertiesManager.psave (entry, fileFor (filename (tokens)));
			}
			public String describe () { return "Save properties of a directory entry to jSON file"; }
		};
	}


}

