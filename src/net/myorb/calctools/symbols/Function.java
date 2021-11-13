
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Symbol;
import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.symbols.OperationObject;
import net.myorb.math.expressions.symbols.Parameterization;

/**
 * a sub-class of symbol for properties of symbols defined as functions
 * @author Michael Druckman
 */
public class Function extends Symbol
{

	public Function (Library library)
	{
		super (library);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#getParameterization()
	 */
	public Parameterization getParameterization ()
	{
		return (OperationObject) implementation;
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#symbolType()
	 */
	public String symbolType () { return " {FUN} "; }

}