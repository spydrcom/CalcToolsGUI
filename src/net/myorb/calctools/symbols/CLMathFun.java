
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Library;

public class CLMathFun extends Function
{

	public CLMathFun (Library library)
	{
		super (library);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#applyConfiguration()
	 */
	public Object applyConfiguration ()
	{
		if (parameters == null) return null;
		getParameterization ().addParameterization (parameters);
		return null;
	}

}
