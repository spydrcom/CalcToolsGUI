
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.gui.DisplayModeForm;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.PrettyPrinter;
import net.myorb.math.expressions.SymbolMap;

/**
 * commands related to display and render of symbols
 * @author Michael Druckman
 */
public class Primitives<T> extends Context<T>
{


	public Primitives
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * process a calculate command
	 * @return a keyword command for the calculate keyword
	 */
	public KeywordCommand constructCalculateKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Calculate and show value for an expression"; }

			public void execute (CommandSequence tokens)
			{
				getPrettyFormatter ().showValue (getValue (tokens));
			}
		};
	}
	public KeywordCommand constructCalcKeywordCommand ()
	{ return constructCalculateKeywordCommand (); }


	/**
	 * format output with a specified radix
	 * @return a keyword command for the RADIX keyword
	 */
	public KeywordCommand constructRadixKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Calculate and show value for an expression in specified radix";
			}

			public void execute (CommandSequence tokens)
			{
				int radix = Integer.parseInt (getNextOperandImage (tokens));
				getPrettyFormatter ().showWithRadix (getValue (tokens), radix);
			}
		};
	}


	/**
	 * process a DESCRIBE command
	 * @return a keyword command for the DESCRIBE keyword
	 */
	public KeywordCommand constructDescribeKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Add a description of a function to symbol table"; }

			public void execute (CommandSequence tokens)
			{ describeFunction (tokens); }
		};
	}


	/**
	 * show the help table
	 * @return a keyword command for the help keyword
	 */
	public KeywordCommand constructHelpKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Show the HELP table"; }

			public void execute (CommandSequence tokens)
			{ help (); }
		};
	}


	/**
	 * show the JavaDocs in the browser
	 * @return a keyword command for the DOCS keyword
	 */
	public KeywordCommand constructDocsKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Show the JavaDocs for this release"; }

			public void execute (CommandSequence tokens)
			{ showJavaDocs (tokens); }
		};
	}


	/**
	 * verify symbol table entry
	 * @return a keyword command for the help keyword
	 */
	public KeywordCommand constructVerifyKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Verify symbol present in current symbol table"; }

			public void execute (CommandSequence tokens)
			{ engine.getSymbolMap ().verify (tokens.get (1).getTokenImage ()); }
		};
	}


	/**
	 * show a segment of the symbol table
	 * @return a keyword command for the show keyword
	 */
	public KeywordCommand constructShowKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Show symbol table contents Symbols|Functions|Parent|ALL parents";
			}

			public void execute (CommandSequence tokens)
			{
				SymbolMap s = engine.getSymbolMap ();
				String option = tokens.get (1).getTokenImage ();

				if (tokens.size() > 2)
				{
					int count = Integer.parseInt (tokens.get (2).getTokenImage ());
					for (int n = count; n > 0; n--)
					{
						if ((s = s.getParent ()) == null)
						{ throw new RuntimeException ("Too few parents"); }
					}
				}
				else if (option.toUpperCase ().startsWith ("P"))
				{ s = s.getParent (); }

				s.dump
				(
					option,
					environment.getSpaceManager (),
					environment.getConsoleWriter ()
				);
			}
		};
	}


	/**
	 * show the contents of a matrix
	 * @return a keyword command for the PRETTYPRINT keyword
	 */
	public KeywordCommand constructPrettyPrintKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Show the formatted value of a symbol"; }

			public void execute (CommandSequence tokens)
			{
				String precision = null;
				if (tokens.size() > 2) precision = tokens.get (2).getTokenImage ();
				new PrettyPrinter<T>(environment).formatSymbol (tokens.get (1).getTokenImage (), precision);
			}
		};
	}


	/**
	 * Format an array as a polynomial
	 * @return a keyword command for the POLYPRINT keyword
	 */
	public KeywordCommand constructPolyPrintKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Format an array as a polynomial";
			}

			public void execute (CommandSequence tokens)
			{
				new PrettyPrinter<T>(environment).formatPolynomial (tokens.get (1).getTokenImage ());
			}
		};
	}


	/**
	 * set value display mode and precision
	 * @return a keyword command for the SETMODE prefix
	 */
	public KeywordCommand constructSetModeKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ new DisplayModeForm (environment.getSpaceManager ().getformattingModes (), environment.getOutStream ()); }
			public String describe () { return "Set value display mode and precision"; }
		};
	}


	/**
	 * read symbol definitions from a file into parent table
	 * @return a keyword command for the read keyword
	 */
	public KeywordCommand constructRecognizeKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Read a symbol definition file"; }

			public void execute (CommandSequence tokens)
			{ engine.getScriptManager ().readSymbols (filename (tokens)); }
		};
	}


	/**
	 * read script from a file and execute in background
	 * @return a keyword command for the BACKGROUND keyword
	 */
	public KeywordCommand constructBackgroundKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Read a script file and execute as a background task";
			}

			public void execute (CommandSequence tokens)
			{
				engine.getScriptManager ().readAndExecuteBG (filename (tokens));
			}
		};
	}


	/**
	 * make a conditional assertion
	 * @return a keyword command for the ASSERT keyword
	 */
	public KeywordCommand constructAssertKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () { return "Make a conditional assertion"; }

			public void execute (CommandSequence tokens)
			{
				String name = getNameTag (tokens); engine.process (tokens);
				engine.getScriptManager ().conditionallyAssert (name, tokens);
			}
		};
	}


	/**
	 * Add a comment to the output stream
	 * @return a keyword command for the COMMENT prefix
	 */
	public KeywordCommand constructCommentCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () { return "Add a comment to the output stream"; }
			public void execute (CommandSequence tokens) {}
		};
	}
	public KeywordCommand constructCommentKeywordCommand ()
	{ return constructCommentCommand (); }


}

