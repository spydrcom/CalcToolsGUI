
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.ArithmeticPrimitives;

import net.myorb.math.expressions.evaluationstates.Environment;

/**
 * a library object to hold symbols defined as arithmetic operators
 * @author Michael Druckman
 */
public class Arithmetic extends Library
{

	public static <T> AlgorithmCore<T> getAlgorithms (Environment<T> environment)
	{
		return new ArithmeticPrimitives<T>(environment);
	}

	private static final long serialVersionUID = -950827030139058746L;

}
