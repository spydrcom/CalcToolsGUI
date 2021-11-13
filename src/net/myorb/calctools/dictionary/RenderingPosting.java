
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Rendering;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to MML rendering.
 *  post the MML rendering commands to dictionary
 * @author Michael Druckman
 */
public class RenderingPosting<T> extends Rendering<T>
	implements CommandDictionaryPosting
{

	public RenderingPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postRenderKeywordCommand() {
		id (super.constructRenderKeywordCommand(), OperatorNomenclature.RENDER_KEYWORD);
	}

	public void postSelectKeywordCommand() {
		id (super.constructSelectKeywordCommand(), OperatorNomenclature.SELECT_KEYWORD);
	}

	public void postRenderFunctionKeywordCommand() {
		id (super.constructRenderFunctionKeywordCommand(), OperatorNomenclature.RENDER_FUNCTION_KEYWORD);
	}

	public void postRenderDiffEqKeywordCommand() {
		id (super.constructRenderDiffEqKeywordCommand(), OperatorNomenclature.RENDER_DIFFEQ_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postSelectKeywordCommand();
		postRenderDiffEqKeywordCommand();
		postRenderFunctionKeywordCommand();
		postRenderKeywordCommand();
	}

}
