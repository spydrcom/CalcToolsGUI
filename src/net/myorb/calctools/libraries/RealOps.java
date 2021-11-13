
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;
import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.PowerPrimitives;
import net.myorb.math.expressions.evaluationstates.Environment;

public class RealOps extends Library
{


	public static AlgorithmCore<Double> getAlgorithms (Environment<Double> environment)
	{
		return new PowerPrimitives<Double> (environment);
	}


	private static final long serialVersionUID = 8937657215133762157L;

}

