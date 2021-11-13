
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.MatrixIO;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to matrix features.
 *  post the matrix commands to dictionary
 * @author Michael Druckman
 */
public class MatrixIOPosting<T> extends MatrixIO<T>
	implements CommandDictionaryPosting
{

	public MatrixIOPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }
	
	public void postImportKeywordCommand() {
		id (super.constructImportKeywordCommand(), OperatorNomenclature.IMPORT_KEYWORD);
	}

	public void postExportKeywordCommand() {
		id (super.constructExportKeywordCommand(), OperatorNomenclature.EXPORT_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postImportKeywordCommand();
		postExportKeywordCommand();
	}

}
