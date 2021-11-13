
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.PrimeNumbers;
import net.myorb.math.expressions.commands.PrimeNumbers.PrimeCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to prime number operations
 * @author Michael Druckman
 */
public class Primes<T> extends Context<T>
{


	public Primes
	(ExpressionSpaceManager<T> manager)
	{ super (manager); primes = new PrimeNumbers<T>(environment); }
	protected PrimeNumbers<T> primes;


	public PrimeCommand constructRunsieveKeywordCommand ()
	{
		return primes.constructRunsieveKeywordCommand ();
	}


	public PrimeCommand constructPrimetableKeywordCommand ()
	{
		return primes.constructPrimetableKeywordCommand ();
	}


	public PrimeCommand constructPrimegapsKeywordCommand ()
	{
		return primes.constructPrimegapsKeywordCommand ();
	}


}

