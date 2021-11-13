
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Symbol;
import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.symbols.OperationObject;
import net.myorb.math.expressions.symbols.Parameterization;

/**
 * a sub-class of symbol for properties of symbols defined as operators
 * @author Michael Druckman
 */
public class Operator extends Symbol
{

	public Operator (Library library)
	{
		super (library);
	}

	/**
	 * @return the precedence for the operation
	 */
	public int getPrecedence ()
	{
		return precedence;
	}

	public void setPrecedence (int precedence)
	{
		this.precedence = precedence;
	}
	int precedence;

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
	public String symbolType () { return " {OP-"+precedence+"} "; }

}
