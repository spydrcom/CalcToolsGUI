
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Workspace;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to saving and restoring workspace symbols.
 *  post the save and read commands to dictionary
 * @author Michael Druckman
 */
public class WorkspacePosting<T> extends Workspace<T>
	implements CommandDictionaryPosting
{

	public WorkspacePosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postSaveKeywordCommand() {
		id (super.constructSaveKeywordCommand(), OperatorNomenclature.SAVE_INPUT_KEYWORD);
	}

	public void postReadKeywordCommand() {
		id (super.constructReadKeywordCommand(), OperatorNomenclature.READ_INPUT_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postReadKeywordCommand();
		postSaveKeywordCommand();
	}

}
