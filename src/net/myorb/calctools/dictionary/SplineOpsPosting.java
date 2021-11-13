package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.SplineOps;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to spline operations.
 *  post the spline related commands to dictionary
 * @author Michael Druckman
 */
public class SplineOpsPosting<T> extends SplineOps<T>
	implements CommandDictionaryPosting
{

	public SplineOpsPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postEncodeKeywordCommand() {
		id (super.constructEncodeKeywordCommand(), OperatorNomenclature.ENCODE_KEYWORD);
	}

	public void postSplineKeywordCommand() {
		id (super.constructSplineKeywordCommand(), OperatorNomenclature.SPLINE_KEYWORD);
	}

	public void postSetDomainKeywordCommand() {
		id (super.constructSetDomainKeywordCommand(), OperatorNomenclature.SETDOMAIN_KEYWORD);
	}

	public void postStdDomainKeywordCommand() {
		id (super.constructStdDomainKeywordCommand(), OperatorNomenclature.STDDOMAIN_KEYWORD);
	}

	public void postOptimizeKeywordCommand() {
		id (super.constructOptimizeKeywordCommand(), OperatorNomenclature.OPTIMIZE_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postEncodeKeywordCommand();
		postOptimizeKeywordCommand();
		postStdDomainKeywordCommand();
		postSetDomainKeywordCommand();
		postSplineKeywordCommand();
	}

}
