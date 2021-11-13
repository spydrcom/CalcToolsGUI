
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to spline operations
 * @author Michael Druckman
 */
public class SplineOps<T> extends Context<T>
{


	public SplineOps
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * encode a segmented function
	 * @return a keyword command for the ENCODE keyword
	 */
	public KeywordCommand constructEncodeKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Encode a segmented function as a Java class"; }

			public void execute (CommandSequence tokens)
			{ encodeSpline (tokens); }
		};
	}


	/**
	 * open SPLINE tool
	 * @return a keyword command for the SPLINE keyword
	 */
	public KeywordCommand constructSplineKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Open anti-derivative spline tool for function"; }

			public void execute (CommandSequence tokens)
			{ splineToolInvocation (tokens); }
		};
	}


	/**
	 * set domain constraints on a function
	 * @return a keyword command for the SETDOMAIN keyword
	 */
	public KeywordCommand constructSetDomainKeywordCommand ()
  	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ engine.getDeclarationSupport ().setDomainConstraints (withCommandRemoved (tokens)); }

			public String describe () { return "Set domain constraints on a function"; }
		};
  	}


	/**
	 * standardize a function domain to [-1,1]
	 * @return a keyword command for the STDDOMAIN keyword
	 */
	public KeywordCommand constructStdDomainKeywordCommand ()
  	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{ engine.getDeclarationSupport ().standardizeDomainConstraints (withCommandRemoved (tokens)); }

			public String describe () { return "Standardize a function domain to [-1,1]"; }
		};
  	}


	/**
	 * optimize polynomial function use by embedding coefficients
	 * @return a keyword command for the OPTIMIZE keyword
	 */
	public KeywordCommand constructOptimizeKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{ return "Optimize polynomial function use by embedding constant coefficients"; }

			public void execute (CommandSequence tokens)
			{ engine.getFunctionManager ().optimizePolynomial (tokens); }
		};
	}


}

