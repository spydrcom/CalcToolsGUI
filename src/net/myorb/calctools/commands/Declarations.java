
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to symbol declaration
 * @author Michael Druckman
 */
public class Declarations<T> extends Context<T>
{


	public Declarations
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * process a define command
	 * @return a keyword command for the define keyword
	 */
	public KeywordCommand constructDefineKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Define a user function"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * process a HG Polynomial declaration command
	 * @return a keyword command for the define keyword
	 */
	public KeywordCommand constructHGPolynomialKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Declare a user function as a Hyper-Geometric polynomial"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * process a transform command
	 * @return a keyword command for the define keyword
	 */
	public KeywordCommand constructTransformKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Define a function transform"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * enable a function as an integration transform source
	 * @return a keyword command for the define keyword
	 */
	public KeywordCommand constructTransformEnableKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Define a function as an integration transform source"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * process a lib import command
	 * @return a keyword command for the lib import prefix
	 */
	public KeywordCommand constructLibImportKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Define a user function as a library import"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * process a segmented function definition
	 * @return a keyword command for the segmented function prefix
	 */
	public KeywordCommand constructSegmentedFunctionKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Define a segmented user function as a list of polynomials"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().processFunctionDefinition (tokens); }
		};
	}


	/**
	 * process a library command
	 * @return a keyword command for the LIBRARY keyword
	 */
	public KeywordCommand constructLibraryKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Construct a library of functions"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().getLibrarian ().processLibrary (tokens); }
		};
	}


	/**
	 * process a configure command
	 * @return a keyword command for the CONFIGURE keyword
	 */
	public KeywordCommand constructConfigureKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Configure a library of functions"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().getLibrarian ().configureLibrary (tokens); }
		};
	}


	/**
	 * process an instance command
	 * @return a keyword command for the INSTANCE keyword
	 */
	public KeywordCommand constructInstanceKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Instance a symbol described by a library"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().getLibrarian ().instanceSymbol (tokens); }
		};
	}


	/**
	 * process an INIT command
	 * @return a keyword command for the INIT keyword
	 */
	public KeywordCommand constructInitKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Init a symbol imported from a JAR source"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().getLibrarian ().initObject (tokens); }
		};
	}


	/**
	 * process a family command
	 * @return a keyword command for the FAMILY keyword
	 */
	public KeywordCommand constructFamilyKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe () 
			{ return "Import polynomial power functions for named family"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().getLibrarian ().importFamily (tokens); }
		};
	}


}
