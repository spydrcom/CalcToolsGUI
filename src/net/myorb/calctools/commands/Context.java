
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.EnvironmentalUtilities;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.EvaluationEngine;
import net.myorb.math.expressions.ValueManager;

/**
 * base class for describing blocks of keywords
 * @author Michael Druckman
 */
public class Context<T>
	extends EnvironmentalUtilities<T>
	implements EnvironmentalUtilities.AccessToTopOfStack
{


	/**
	 * error check for command length
	 * @param count the expected count of parameters
	 * @param tokens the token sequence for the command
	 */
	public void expecting (int count, CommandSequence tokens)
	{
		if (tokens.size () <= count) throw new RuntimeException ("Command is short parameters, expecting " + count);
	}


	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.commands.EnvironmentalUtilities.AccessToTopOfStack#getValue(net.myorb.math.expressions.commands.CommandAdministration.CommandSequence)
	 */
	public ValueManager.GenericValue getValue (CommandSequence sequence)
	{
		engine.process (withCommandRemoved (sequence));
		return engine.popValueStack ();
	}


	/**
	 * @return access to top of stack
	 */
	public AccessToTopOfStack getAccess () { return this; }


	/**
	 * identify EvaluationEngine to be used
	 * @param engine the EvaluationEngine to use
	 */
	public void setEvaluationEngine
	(EvaluationEngine<T> engine) { this.engine = engine; }
	protected EvaluationEngine<T> engine;


	/**
	 * connect with the engine that can process tokens
	 * @param engine the engine that constructed this object
	 */
	public Context (EvaluationEngine<T> engine)
	{
		super (engine.getEnvironment ());
		setEvaluationEngine (engine);
	}

	public Context (ExpressionSpaceManager<T> manager)
	{
		this (manager.getEvaluationControl ().getEngine ());
	}


}
