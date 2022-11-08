
package net.myorb.calctools.libraries;

import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.FactorizationOverrides;

import net.myorb.math.expressions.evaluationstates.Environment;
import net.myorb.math.primenumbers.Factorization;
import net.myorb.calctools.atomic.Library;

/**
 * a library object to hold symbols defined as operators on fractions
 * @author Michael Druckman
 */
public class FactoredOps extends Library
{

	public static AlgorithmCore <Factorization> getAlgorithms (Environment <Factorization> environment)
	{
		return new FactorizationOverrides (environment);
	}

	private static final long serialVersionUID = -7175707505812359190L;

}

