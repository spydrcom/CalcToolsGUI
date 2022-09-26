
package net.myorb.calctools.libraries;

import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.LambdaPrimitives;

import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.calctools.atomic.Library;

/**
 * a library object to hold symbols defined as lambda operators
 * @author Michael Druckman
 */
public class Pointer extends Library
{

	public static <T> AlgorithmCore<T> getAlgorithms (Environment<T> environment)
	{
		return new LambdaPrimitives<T>(environment);
	}

	private static final long serialVersionUID = -1838155897680357269L;
}
