
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Primes;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to prime number operations.
 *  post the commands related to prime number processing.
 * @author Michael Druckman
 */
public class PrimesPosting<T> extends Primes<T>
	implements CommandDictionaryPosting
{

	public PrimesPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postRunsieveKeywordCommand() {
		id (super.constructRunsieveKeywordCommand(), OperatorNomenclature.RUNSIEVE_KEYWORD);
	}

	public void postPrimetableKeywordCommand() {
		id (super.constructPrimetableKeywordCommand(), OperatorNomenclature.PRIMETABLE_KEYWORD);
	}

	public void postPrimegapsKeywordCommand() {
		id (super.constructPrimegapsKeywordCommand(), OperatorNomenclature.PRIMEGAPS_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postPrimegapsKeywordCommand();
		postPrimetableKeywordCommand();
		postRunsieveKeywordCommand();
	}

}
