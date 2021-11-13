
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to DIFF EQ operations
 * @author Michael Druckman
 */
public class DiffEQ<T> extends Context<T>
{


	public DiffEQ
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * prepare function as Diff EQ solution for test
	 * @return a keyword command for the PREPARE keyword
	 */
	public KeywordCommand constructPrepareKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Alias selected function and derivatives for Diff EQ solution test"; }

			public void execute (CommandSequence tokens)
			{ expecting (3, tokens); engine.getFunctionManager ().prepareDiffEqSolutionTest (tokens); }
		};
	}


	/**
	 * prepare polynomial as Diff EQ solution for test
	 * @return a keyword command for the PREPPOLY keyword
	 */
	public KeywordCommand constructPrepPolyKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Alias selected polynomial and derivatives for Diff EQ solution test"; }

			public void execute (CommandSequence tokens)
			{ expecting (2, tokens); engine.getFunctionManager ().preparePolynomialDiffEqSolutionTest (tokens); }
		};
	}


	/**
	 * Test Differential Equation Solution
	 * @return a keyword command for the TDES keyword
	 */
	public KeywordCommand constructTdesKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Run error test of differential equation solution"; }

			public void execute (CommandSequence tokens)
			{ environment.getDifferentialEquationsManager ().runTest (tokens, engine.getFunctionManager ()); }
		};
	}


	/**
	 * identify differential equation and describe
	 * @return a keyword command for the DIFEQ keyword
	 */
	public KeywordCommand constructDifeqKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Identify differential equation and describe"; }

			public void execute (CommandSequence tokens)
			{ expecting (2, tokens); environment.getDifferentialEquationsManager ().identifyDiffEq (tokens); }
		};
	}


}

