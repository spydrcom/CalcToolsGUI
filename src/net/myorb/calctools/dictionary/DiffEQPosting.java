
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.DiffEQ;

import net.myorb.math.expressions.OperatorNomenclature;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to DIFF EQ operations.
 *  post the DIFF EQ commands to dictionary
 * @author Michael Druckman
 */
public class DiffEQPosting<T> extends DiffEQ<T>
	implements CommandDictionaryPosting
{


	public DiffEQPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	public void postPrepareKeywordCommand() {
		id (super.constructPrepareKeywordCommand(), OperatorNomenclature.PREPARE_KEYWORD);
	}


	public void postPrepPolyKeywordCommand() {
		id (super.constructPrepPolyKeywordCommand(), OperatorNomenclature.PREPPOLY_KEYWORD);
	}


	public void postTdesKeywordCommand() {
		id (super.constructTdesKeywordCommand(), OperatorNomenclature.TDES_KEYWORD);
	}


	public void postDifeqKeywordCommand() {
		id (super.constructDifeqKeywordCommand(), OperatorNomenclature.DIFEQ_KEYWORD);
	}


	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postTdesKeywordCommand();
		postPrepareKeywordCommand();
		postPrepPolyKeywordCommand();
		postDifeqKeywordCommand();
	}


}

