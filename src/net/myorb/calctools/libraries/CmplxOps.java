
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.algorithms.AlgorithmCore;
import net.myorb.math.expressions.algorithms.ComplexPrimitives;
import net.myorb.math.expressions.algorithms.TrigPowPrimitives;

import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.math.complexnumbers.ComplexAlgorithmAccess;
import net.myorb.math.complexnumbers.ComplexValue;

/**
 * a library for symbols built-in for complex number operations
 * @author Michael Druckman
 */
public class CmplxOps extends Library
{

	public static AlgorithmCore<ComplexValue<Double>>
		getAlgorithms (Environment<ComplexValue<Double>> environment)
	{
		return new ComplexPrimitives (environment);
	}

	public static TrigPowPrimitives<ComplexValue<Double>>
		getTrigPowAlgorithms (Environment<ComplexValue<Double>> environment)
	{
		return ComplexAlgorithmAccess.getTrigPowAlgorithms ();
	}

	private static final long serialVersionUID = 4866783952600903298L;

}
