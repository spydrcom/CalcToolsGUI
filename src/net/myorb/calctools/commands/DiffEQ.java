
package net.myorb.calctools.commands;

import net.myorb.math.polynomial.PolynomialGenerator;
import net.myorb.math.polynomial.algebra.SeriesExpansion;

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
	 * generate a polynomial function
	 * @return a keyword command for the POLYGEN keyword
	 */
	public KeywordCommand constructPolyGenKeywordCommand ()
	{
		
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Generate a polynomial function from NAME PARAMETER COEFFICIENT DEGREE"; }

			public void execute (CommandSequence tokens)
			{
				StringBuffer functionName, parameterName, coefficientName;
				int pos = getFunctionName ( 0, tokens, functionName = new StringBuffer () );
				pos = getFunctionName ( pos-1, tokens, parameterName = new StringBuffer () );
				pos = getFunctionName ( pos-1, tokens, coefficientName = new StringBuffer () );

				new PolynomialGenerator <T> (environment)
				.declare
				(
					functionName.toString (), parameterName.toString (),
					coefficientName.toString (), tokens, pos
				);
			}
		};
	}


	/**
	 * Find Differential Equation Solution
	 * @return a keyword command for the SOLVE keyword
	 */
	public KeywordCommand constructSolveKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Solve differential equation from expanded polynomial"; }

			public void execute (CommandSequence tokens)
			{
				StringBuffer expandedFunctionName, sourceFunctionName, newFunctionName;
				int pos = getFunctionName ( 0, tokens, expandedFunctionName = new StringBuffer () );
				pos = getFunctionName ( pos-1, tokens, sourceFunctionName = new StringBuffer () );
				pos = getFunctionName ( pos-1, tokens, newFunctionName = new StringBuffer () );

				new SeriesExpansion <T> (environment)
				.solve
				(
					expandedFunctionName.toString (),
					sourceFunctionName.toString (),
					newFunctionName.toString (),
					tokens, pos
				);
			}
		};
	}


	/**
	 * show solutions connected to a differential equation
	 * @return a keyword command for the SHOSOL keyword
	 */
	public KeywordCommand constructSHOSOLKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () { return "Show solutions connected to a differential equation"; }
			public void execute (CommandSequence tokens) { SeriesExpansion.showSolutions (tokens, environment); }
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

