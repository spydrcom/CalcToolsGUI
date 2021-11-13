
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Library;
//import net.myorb.utilities.Configurable;

public class MPMathOp extends Operator
{

	public MPMathOp (Library library)
	{
		super (library);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#applyConfiguration()
	 */
	public Object applyConfiguration ()
	{
		getParameterization ().addParameterization (parameters);
//		((Configurable) implementation).configure (parameters);
		return null;
	}

}
