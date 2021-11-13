
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Library;
import net.myorb.calctools.atomic.Symbol;

/**
 * a sub-class of symbol for properties of symbols defines as values
 * @author Michael Druckman
 */
public class Value extends Symbol
{

	public Value (Library library)
	{
		super (library);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#getAlgorithmAccess()
	 */
	public String getAlgorithmAccess ()
	{
		return "get" + reference + "Value";
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#symbolType()
	 */
	public String symbolType () { return " {VAL} "; }

}
