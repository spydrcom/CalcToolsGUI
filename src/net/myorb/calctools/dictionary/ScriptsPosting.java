
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Scripts;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to script operations.
 *  post the script related commands to dictionary
 * @author Michael Druckman
 */
public class ScriptsPosting<T> extends Scripts<T>
	implements CommandDictionaryPosting
{

	public ScriptsPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postIterateKeywordCommand() {
		id (super.constructIterateKeywordCommand(), OperatorNomenclature.ITERATE_KEYWORD);
	}

	public void postScriptPrintKeywordCommand() {
		id (super.constructScriptPrintKeywordCommand(), OperatorNomenclature.SCRIPTPRINT_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postScriptPrintKeywordCommand();
		postIterateKeywordCommand();
	}

}
