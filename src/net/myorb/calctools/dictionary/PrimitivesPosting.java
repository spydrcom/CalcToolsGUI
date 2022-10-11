
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Primitives;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to display and render of symbols.
 *  post the rendering commands to dictionary
 * @author Michael Druckman
 */
public class PrimitivesPosting<T> extends Primitives<T>
	implements CommandDictionaryPosting
{


	public PrimitivesPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	public void postShowKeywordCommand() {
		id (super.constructShowKeywordCommand(), OperatorNomenclature.SHOW_SYMBOLS_KEYWORD);
	}

	public void postPrettyPrintKeywordCommand() {
		id (super.constructPrettyPrintKeywordCommand(), OperatorNomenclature.PRETTYPRINT_KEYWORD);
	}

	public void postPolyPrintKeywordCommand() {
		id (super.constructPolyPrintKeywordCommand(), OperatorNomenclature.POLYPRINT_KEYWORD);
	}

	public void postSetModeKeywordCommand() {
		id (super.constructSetModeKeywordCommand(), OperatorNomenclature.SETMODE_KEYWORD);
	}

	public void postRecognizeKeywordCommand() {
		id (super.constructRecognizeKeywordCommand(), OperatorNomenclature.RECOGNIZE_KEYWORD);
	}

	public void postBackgroundKeywordCommand() {
		id (super.constructBackgroundKeywordCommand(), OperatorNomenclature.BACKGROUND_KEYWORD);
	}

	public void postAssertKeywordCommand() {
		id (super.constructAssertKeywordCommand(), OperatorNomenclature.ASSERT_KEYWORD);
	}

	public void postCommentCommand() {
		id (super.constructCommentCommand(), OperatorNomenclature.COMMENT_PREFIX);
	}

	public void postConditionalBlockCommand() {
		id (super.constructConditionalBlockStartCommand (), OperatorNomenclature.START_OF_CONDITIONAL_BLOCK_DELIMITER);
	}

	public void postCountedBlockCommand() {
		id (super.constructCountedBlockStartCommand (), OperatorNomenclature.START_OF_LOOP_BLOCK_DELIMITER);
	}

	public void postCalculateKeywordCommand() {
		id (super.constructCalculateKeywordCommand(), OperatorNomenclature.CALCULATE_KEYWORD);
	}

	public void postRadixKeywordCommand() {
		id (super.constructRadixKeywordCommand(), OperatorNomenclature.RADIX_KEYWORD);
	}

	public void postDescribeKeywordCommand() {
		id (super.constructDescribeKeywordCommand(), OperatorNomenclature.DESCRIBE_KEYWORD);
	}

	public void postHelpKeywordCommand() {
		id (super.constructHelpKeywordCommand(), OperatorNomenclature.HELP_KEYWORD);
	}

	public void postDocsKeywordCommand() {
		id (super.constructDocsKeywordCommand(), OperatorNomenclature.DOCS_KEYWORD);
	}

	public void postVerifyKeywordCommand() {
		id (super.constructVerifyKeywordCommand(), OperatorNomenclature.VERIFY_KEYWORD);
	}


	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postCommentCommand();
		postCountedBlockCommand();
		postConditionalBlockCommand();
		postAssertKeywordCommand();
		postBackgroundKeywordCommand();
		postRecognizeKeywordCommand();
		postSetModeKeywordCommand();
		postPolyPrintKeywordCommand();
		postCalculateKeywordCommand();
		postDescribeKeywordCommand();
		postRadixKeywordCommand();
		postShowKeywordCommand();
		postHelpKeywordCommand();
		postDocsKeywordCommand();
		postVerifyKeywordCommand();
	}


}
