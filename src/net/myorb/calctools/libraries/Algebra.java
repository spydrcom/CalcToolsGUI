
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.AlgebraicPrimitives;

import net.myorb.math.expressions.evaluationstates.Environment;

/**
 * a library object to hold symbols defined as algebraic operators
 * @author Michael Druckman
 */
public class Algebra extends Library
{


	public static <T> AlgorithmCore<T> getAlgorithms (Environment<T> environment)
	{
		return new AlgebraicPrimitives<T>(environment);
	}


	private static final long serialVersionUID = 1345810523640911037L;

}
