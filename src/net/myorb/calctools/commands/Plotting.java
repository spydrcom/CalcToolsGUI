
package net.myorb.calctools.commands;

import net.myorb.math.expressions.charting.colormappings.ContourColorSchemeRequest;
import net.myorb.math.expressions.charting.RegressionCharts;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.ExtendedKeywordCommand;
import net.myorb.math.expressions.commands.KeywordCommand;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.GraphManager;
import net.myorb.math.expressions.TokenParser;

import net.myorb.gui.components.DisplayFrame;
import net.myorb.gui.components.SideBySide;

/**
 * commands related to plots / charts / graphs in general
 * @author Michael Druckman
 */
public class Plotting<T> extends Context<T>
{


	public Plotting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * process a GRAPH command
	 * @return a keyword command for the GRAPH keyword
	 */
	public ExtendedKeywordCommand constructGraphKeywordCommand ()
	{
		return new ExtendedKeywordCommand ()
		{
			public String describe ()
			{ return "Display a graph of an array of data points"; }

			public void execute (CommandSequence tokens)
			{ plotWithLimit (GraphManager.Types.ARRAY, tokens, getAccess ()); }

			public String[] includingSubordinateKeywords ()
			{ return new String[]{"lim"}; }
		};
	}


	/**
	 * process a CHART command
	 * @return a keyword command for the CHART keyword
	 */
	public KeywordCommand constructChartKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Display a chart for a set of symbols"; }

			public void execute (CommandSequence tokens)
			{
				CommandSequence
					oparands = withCommandRemoved (tokens);
				String kind = getCurrentOperandImage (oparands);
				getGraphManager ().chartFor (kind, oparands);
			}
		};
	}


	/**
	 * process a derive command
	 * @return a keyword command for the derive keyword
	 */
	public KeywordCommand constructDeriveKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Plot derivatives of a polynomial"; }

			public void execute (CommandSequence tokens)
			{ plot (GraphManager.Types.POLY_DERIVATION, tokens, getAccess ()); }
		};
	}


	/**
	 * process a PLOTF command
	 * @return a keyword command for the PLOTF keyword
	 */
	public KeywordCommand constructPlotfKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Plot a specified range of a user defined function";
			}

			public void execute (CommandSequence tokens)
			{
				processLimit (tokens);
				getGraphManager ().singleFunctionPlot (tokens);
				resetLimit ();
			}
		};
	}


	/**
	 * process a PLOTL command
	 * @return a keyword command for the PLOTL keyword
	 */
	public KeywordCommand constructPlotlKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Plot a specified range of lambda declared function(s)";
			}

			public void execute (CommandSequence tokens)
			{
				processLimit (tokens);
				getGraphManager ().lambdaFunctionPlots (tokens);
				resetLimit ();
			}
		};
	}


	/**
	 * process a PLOTT command
	 * @return a keyword command for the PLOTT keyword
	 */
	public KeywordCommand constructPlottKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Tabular plot with data taken from file";
			}

			public void execute (CommandSequence tokens)
			{
				CommandSequence rem = withCommandRemoved (tokens);
				String path = TokenParser.toFormatted (rem, false).replaceAll (" ", "");
				getGraphManager ().tabularPlotFromFile (path);
			}
		};
	}


	/**
	 * process a PLOTM command
	 * @return a keyword command for the plotm keyword
	 */
	public KeywordCommand constructPlotmKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Display tabular plot with data taken from a matrix";
			}

			public void execute (CommandSequence tokens)
			{
				CommandSequence 
					rem = withCommandRemoved (tokens);
				String symbol = getCurrentOperandImage (rem);
				getGraphManager ().tabularFunctionPlot (symbol, rem);
			}
		};
	}


	/**
	 * process a PLOT3D command
	 * @return a keyword command for the plot3d keyword
	 */
	public KeywordCommand constructPlot3dKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Plot a specified 2D domain of a 3D user defined function";
			}

			public void execute (CommandSequence tokens)
			{
				processLimit (tokens);
				CommandSequence rem = withCommandRemoved (tokens);
				String function = getCurrentOperandImage (rem);
				getGraphManager ().single3DFunctionPlot (function, rem);
			}
		};
	}


	/**
	 * produce an X/Y scatter plot
	 * @return a keyword command for the SCATTER keyword
	 */
	public KeywordCommand constructScatterKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Produce an X/Y scatter plot"; }

			public void execute (CommandSequence tokens)
			{
				new RegressionCharts<T> (environment).scatter
				(
					tokens.get (1).getTokenImage (), tokens.get (3).getTokenImage ()
				);
			}
		};
	}


	/**
	 * compute and display a fast Fourier transform
	 * @return a keyword command for the FFT keyword
	 */
	public KeywordCommand constructFftKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Compute and display a fast Fourier transform";
			}

			public void execute (CommandSequence tokens)
			{
				new RegressionCharts<T> (environment).transorm
				(
					tokens.get (1).getTokenImage ()
				);
			}
		};
	}


	/**
	 * produce a side-by-side plot comparison
	 * @return a keyword command for the SIDEBYSIDE keyword
	 */
	public KeywordCommand constructComparisonKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Produce a side-by-side plot comparison"; }

			public void execute (CommandSequence tokens)
			{
				SideBySide.addToPanel (TokenParser.stripQuotes (tokens.get (1).getTokenImage ()));
			}
		};
	}


	/**
	 * process a PLOTC command
	 * @return a keyword command for the plotc keyword
	 */
	public KeywordCommand constructPlotcKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Plot a specified 2D domain with contours of a 3D user defined function";
			}

			public void execute (CommandSequence tokens)
			{
				CommandSequence 
					rem = withCommandRemoved (tokens);
				String function = getCurrentOperandImage (rem);
				getGraphManager ().singleContourFunctionPlot (function, rem);
			}
		};
	}


	/**
	 * Set color scheme manager for contour plots
	 * @return a keyword command for the SETCONTOUR prefix
	 */
	public KeywordCommand constructSetContourKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{
				if (tokens.size () > 1)
				{
					String scheme = tokens.get (1).getTokenImage ();
					ContourColorSchemeRequest.identify (scheme);
				} else new ContourColorSchemeRequest ();
			}
			public String describe () { return "Set color scheme manager for contour plots"; }
		};
	}


	/**
	 * process a ENTITLED command
	 * @return a keyword command for the ENTITLED keyword
	 */
	public KeywordCommand constructEntitledKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Change the title of the last frame displayed"; }

			public void execute (CommandSequence tokens)
			{ DisplayFrame.changeTitle (TokenParser.toString (withCommandRemoved (tokens))); }
		};
	}


}

