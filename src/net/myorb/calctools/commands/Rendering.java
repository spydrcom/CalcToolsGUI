
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to MML rendering
 * @author Michael Druckman
 */
public class Rendering<T> extends Context<T>
{


	public Rendering
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * display an equation using MathML
	 * @return a keyword command for the RENDER keyword
	 */
	public KeywordCommand constructRenderKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Format and display (pretty print) an equation using MathML"; }

			public void execute (CommandSequence tokens)
			{ getCurrentRenderer ().RenderFrom (tokens); }
		};
	}


	/**
	 * select a render display to be shown and used for output
	 * @return a keyword command for the SELECT keyword
	 */
	public KeywordCommand constructSelectKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Select a render display to be shown and used for output of RENDER commands"; }

			public void execute (CommandSequence tokens) { setCurrentRenderer (withCommandRemoved (tokens)); }
		};
	}


	/**
	 * display a function using MathML
	 * @return a keyword command for the RENDERF keyword
	 */
	public KeywordCommand constructRenderFunctionKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Format and display (pretty print) a function using MathML"; }

			public void execute (CommandSequence tokens)
			{ getCurrentRenderer ().RenderFunction (tokens); }
		};
	}


	/**
	 * display a Differential Equation using MathML
	 * @return a keyword command for the RENDERF keyword
	 */
	public KeywordCommand constructRenderDiffEqKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Format and display (pretty print) a Differential Equation using MathML"; }

			public void execute (CommandSequence tokens)
			{ getCurrentRenderer ().RenderDifferentialEquation (tokens); }
		};
	}


}

