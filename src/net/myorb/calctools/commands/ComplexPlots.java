
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.Plotting;
import net.myorb.math.expressions.commands.Plotting.PlotCommand;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.GraphManager;

/**
 * commands related to complex number plots
 * @author Michael Druckman
 */
public class ComplexPlots<T> extends Context<T>
{


	public ComplexPlots
	(ExpressionSpaceManager<T> manager)
	{ super (manager); plotting = new Plotting<T>(environment); }
	protected Plotting<T> plotting;


	/**
	 * process a SPLOT command
	 * @return a keyword command for the SPLOT keyword
	 */
	public KeywordCommand constructSplotKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Display a graph of a complex number sequence"; }

			public void execute (CommandSequence tokens)
			{ plotWithLimit (GraphManager.Types.COMPLEX, tokens, getAccess ()); }
		};
	}


	/**
	 * process a PLOTRI command
	 * @return a keyword command for the plot3d keyword
	 */
	public KeywordCommand constructPlotriKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Plot a specified range of a complex user defined function as separate plots of Real and Imaginary components";
			}

			public void execute (CommandSequence tokens)
			{
				processLimit (tokens);
				getGraphManager ().singleComplexFunctionPlot (tokens);
				resetLimit ();
			}
		};
	}


	/**
	 * request angular complex plot
	 * @return a keyword command for the POLARANGULAR keyword
	 */
	public PlotCommand constructAngularKeywordCommand ()
	{
		return plotting.constructAngularKeywordCommand ();
	}


	/**
	 * request radial complex plot
	 * @return a keyword command for the POLARRADIAL keyword
	 */
	public PlotCommand constructRadialKeywordCommand ()
	{
		return plotting.constructRadialKeywordCommand ();
	}


}

