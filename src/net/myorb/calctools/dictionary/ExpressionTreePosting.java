
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.ExpressionTree;
import net.myorb.math.expressions.OperatorNomenclature;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to Expression Tree operations.
 *  post the Expression Tree commands to dictionary
 * @author Michael Druckman
 */
public class ExpressionTreePosting<T> extends ExpressionTree<T>
	implements CommandDictionaryPosting
{

	public ExpressionTreePosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postExpressKeywordCommand() {
		id (super.constructExpressKeywordCommand(), OperatorNomenclature.EXPRESS_KEYWORD);
	}

	public void postSaveJsonKeywordCommand() {
		id (super.constructSaveJsonKeywordCommand(), OperatorNomenclature.SAVEJSON_KEYWORD);
	}

	public void postLoadJsonKeywordCommand() {
		id (super.constructLoadJsonKeywordCommand(), OperatorNomenclature.LOADJSON_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postExpressKeywordCommand();
		postSaveJsonKeywordCommand();
		postLoadJsonKeywordCommand();
	}

}
