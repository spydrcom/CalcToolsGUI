
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to script operations
 * @author Michael Druckman
 */
public class Scripts<T> extends Context<T>
{


	public Scripts
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * read script from a file and iterate
	 * @return a keyword command for the ITERATE keyword
	 */
	public KeywordCommand constructIterateKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Read a script file and iterate";
			}

			public void execute (CommandSequence tokens)
			{
				int maxIterations = Integer.parseInt (getNextOperandImage (tokens));
				engine.getScriptManager ().readAndIterate (filename (tokens), maxIterations);
			}
		};
	}


	/**
	 * Display the contents of a script file
	 * @return a keyword command for the SCRIPTPRINT keyword
	 */
	public KeywordCommand constructScriptPrintKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Display the contents of a script file"; }

			public void execute (CommandSequence tokens)
			{ engine.getScriptManager ().print (filename (tokens)); }
		};
	}


}

