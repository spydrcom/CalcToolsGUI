
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Library;
import net.myorb.math.expressions.symbols.Parameterization;

import java.util.*;

/**
 * a sub-class of Operator for properties of Trig-Pow symbols
 * @author Michael Druckman
 */
public class TrigPow extends Operator
{


	public TrigPow (Library library)
	{
		super (library);
	}

	/**
	 * @return the trig-pow operator name
	 */
	public String getOp () {
		return op;
	}
	public void setOp (String op) {
		parameters.put ("op", op);
		this.op = op;
	}

	/**
	 * @return the power for this symbol
	 */
	public int getPow () {
		return pow;
	}
	public void setPow (int pow) {
		parameters.put ("pow", pow);
		this.pow = pow;
	}
	String op;
	int pow;

	/* (non-Javadoc)
	 * @see net.myorb.calctools.symbols.Operator#getParameterization()
	 */
	public Parameterization getParameterization ()
	{
		return (Parameterization) implementation;
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#applyConfiguration()
	 */
	public Object applyConfiguration ()
	{
		getParameterization ()
		.addParameterization (parameters);
		return null;
	}
	Map<String,Object> parameters = new HashMap<String,Object>();

}
