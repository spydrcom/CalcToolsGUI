
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;
import net.myorb.math.complexnumbers.ComplexValue;
import net.myorb.math.expressions.algorithms.CLmathComplexImplementations;
import net.myorb.math.expressions.evaluationstates.Environment;

/**
 * a library for symbols declared in the ClMath primitive class
 * @author Michael Druckman
 */
public class ClMath extends Library
{

	public static CLmathComplexImplementations getAlgorithms (Environment<ComplexValue<Double>> environment)
	{
		return new CLmathComplexImplementations (environment);
	}

	private static final long serialVersionUID = -4607431977408905063L;

}
