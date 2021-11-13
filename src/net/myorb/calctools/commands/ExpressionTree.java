
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.JsonExpressions;
import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to Expression Tree operations
 * @author Michael Druckman
 */
public class ExpressionTree<T> extends Context<T>
{


	public ExpressionTree
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * generate Expression Tree for function
	 * @return a keyword command for the EXPRESS keyword
	 */
	public KeywordCommand constructExpressKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Enable Expression Tree generation for function"; }

			public void execute (CommandSequence tokens)
			{ allowExpressionTree (getFunctionName (tokens)); }
		};
	}


	/**
	 * save Expression Tree to JSON file
	 * @return a keyword command for the SAVEJSON keyword
	 */
	public KeywordCommand constructSaveJsonKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Save Expression Tree as JSON file"; }

			public void execute (CommandSequence tokens)
			{ new JsonExpressions<T>(environment).saveJson (getFunctionName (tokens)); }
		};
	}


	/**
	 * load Expression Tree(s) from JSON source(s)
	 * @return a keyword command for the LOADJSON keyword
	 */
	public KeywordCommand constructLoadJsonKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Load Expression Tree(s) from JSON source(s)"; }

			public void execute (CommandSequence tokens)
			{ new JsonExpressions<T>(environment).loadJson (tokens); }
		};
	}


}

