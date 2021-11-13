
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CosineTransform;
import net.myorb.math.expressions.commands.MandelbrotGraphics;
import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.ScriptManager;
import net.myorb.math.expressions.GraphManager;

/**
 * commands related to core features
 * @author Michael Druckman
 */
public class Features<T> extends Context<T>
{


	public Features
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * process a mandelbrot command
	 * @return a keyword command for the mandelbrot keyword
	 */
	public KeywordCommand constructMandelbrotKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Display a plot of the Mandelbrot set"; }

			public void execute (CommandSequence tokens)
			{ new MandelbrotGraphics<T>(environment).plot (tokens); }
		};
	}


	/**
	 * process a polynomial command
	 * @return a keyword command for the polynomial keyword
	 */
	public KeywordCommand constructPolynomialKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Analyze a polynomial and tabulate key points"; }

			public void execute (CommandSequence tokens)
			{ plot (GraphManager.Types.POLY_EVALUATION, tokens, getAccess ()); }
		};
	}


	/**
	 * find root of function
	 * @return a keyword command for the ROOTOF keyword
	 */
	public KeywordCommand constructRootKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Find root of function near specified approximation"; }
			public void execute (CommandSequence tokens)
			{
				StringBuffer functionName = new StringBuffer ();
				int pos = getFunctionName (0, tokens, functionName);

				environment.findFunctionRoot
				(
					functionName.toString (),
					tokens.get (pos).getTokenImage ()
				);
			}
		};
	}


	/**
	 * find max/min of function
	 * @return a keyword command for the MAXMINOF keyword
	 */
	public KeywordCommand constructMaxMinKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Find Max/Min of function near specified approximation"; }
			public void execute (CommandSequence tokens)
			{
				StringBuffer functionName = new StringBuffer ();
				int pos = getFunctionName (0, tokens, functionName);

				environment.findFunctionMaxMin
				(
					functionName.toString (), tokens.get (pos).getTokenImage ()
				);
			}
		};
	}


	/**
	 * apply Discrete Cosine Transform to function
	 * @return a keyword command for the DCT keyword
	 */
	public KeywordCommand constructDctKeywordCommand ()
  	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Apply Discrete Cosine Tranform to function"; }

			public void execute (CommandSequence tokens)
			{ new CosineTransform<T>(environment).analyze (tokens); }
		};
  	}


	/**
	 * start the RPN calculator
	 * @return a keyword command for the RPN prefix
	 */
	public KeywordCommand constructRpnCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{
				ScriptManager<T> scriptManager = engine.getScriptManager (); scriptManager.readSymbols ("NamedConstants.txt");
				scriptManager.readSymbols ("BuiltInFunctions.txt"); scriptManager.readSymbols ("TrigIdentities.txt");
				new Thread (new net.myorb.math.expressions.gui.rpn.Calculator<T> (environment)).start ();
			}
			public String describe () { return "Start the RPN calculator"; }
		};
	}
	public KeywordCommand constructRpnKeywordCommand ()
	{ return constructRpnCommand (); }


}

