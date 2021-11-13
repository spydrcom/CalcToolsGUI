
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to saving and restoring workspace symbols
 * @author Michael Druckman
 */
public class Workspace<T> extends Context<T>
{


	public Workspace
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * save symbols to a file
	 * @return a keyword command for the save keyword
	 */
	public KeywordCommand constructSaveKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Save a workspace storage file";
			}

			public void execute (CommandSequence tokens)
			{
				engine.getSymbolMap ().save
				(
					filename (tokens), environment.getSpaceManager (),
					engine.getDataIO (), environment.getOutStream ()
				);
			}
		};
	}


	/**
	 * read symbol definitions from a file
	 * @return a keyword command for the read keyword
	 */
	public KeywordCommand constructReadKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Read a workspace storage file"; }

			public void execute (CommandSequence tokens)
			{ engine.getScriptManager ().readAndExecute (filename (tokens)); }
		};
	}


}

