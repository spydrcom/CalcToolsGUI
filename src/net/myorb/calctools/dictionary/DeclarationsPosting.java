
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Declarations;
import net.myorb.math.expressions.OperatorNomenclature;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to symbol declaration.
 *  post the symbol declaration commands to dictionary
 * @author Michael Druckman
 */
public class DeclarationsPosting<T> extends Declarations<T>
	implements CommandDictionaryPosting
{

	public DeclarationsPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postDefineKeywordCommand() {
		id (super.constructDefineKeywordCommand(), OperatorNomenclature.DEFINITION_KEYWORD);
	}

	public void postHGPolynomialKeywordCommand() {
		id (super.constructHGPolynomialKeywordCommand(), OperatorNomenclature.HG_POLYNOMIAL_PREFIX);
	}

	public void postTransformKeywordCommand() {
		id (super.constructTransformKeywordCommand(), OperatorNomenclature.TRANSFORM_PREFIX);
	}

	public void postTransformEnableKeywordCommand() {
		id (super.constructTransformEnableKeywordCommand(), OperatorNomenclature.TRANSFORM_ENABLE);
	}

	public void postLibImportKeywordCommand() {
		id (super.constructLibImportKeywordCommand(), OperatorNomenclature.LIB_IMPORT_PREFIX);
	}

	public void postSegmentedFunctionKeywordCommand() {
		id (super.constructSegmentedFunctionKeywordCommand(), OperatorNomenclature.SEGMENTED_PREFIX);
	}

	public void postLibraryKeywordCommand() {
		id (super.constructLibraryKeywordCommand(), OperatorNomenclature.LIBRARY_KEYWORD);
	}

	public void postFamilyKeywordCommand() {
		id (super.constructFamilyKeywordCommand(), OperatorNomenclature.FAMILY_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postDefineKeywordCommand();
		postTransformKeywordCommand();
		postHGPolynomialKeywordCommand();
		postTransformEnableKeywordCommand();
		postSegmentedFunctionKeywordCommand();
		postLibImportKeywordCommand();
		postLibraryKeywordCommand();
		postFamilyKeywordCommand();
	}

}
