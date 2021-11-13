
package net.myorb.testing;

import net.myorb.calctools.commands.*;
import net.myorb.math.expressions.EvaluationEngine;
import net.myorb.math.expressions.evaluationstates.Environment;

public class CommandCfg
{
	public static final void main (String[] args)
	{
		EvaluationEngine<Double>
			engine = getEvaluationEngine ();
		Environment<Double> env = engine.getEnvironment ();
		Declarations<Double> dcl = new Declarations<Double> (env.getSpaceManager());
		xxx (env, dcl);
	}
	static EvaluationEngine<Double> getEvaluationEngine () { return null; }
	static void xxx (Environment<Double> env, Declarations<Double> dcl) {}
}
