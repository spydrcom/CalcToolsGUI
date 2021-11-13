
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;
import net.myorb.external.anaconda.ComplexAnacondaRPC;
import net.myorb.math.expressions.evaluationstates.Environment;

/**
 * a library for symbols imported using the Anaconda primitive class
 * @author Michael Druckman
 */
public class Anaconda extends Library
{

	public static <T> ComplexAnacondaRPC getAlgorithms (Environment<T> environment)
	{
		return new ComplexAnacondaRPC ();
	}

	private static final long serialVersionUID = 3290232530159754032L;

}
