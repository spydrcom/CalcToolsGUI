
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.ComplexPlots;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to complex number plots.
 *  post the complex number plot commands to dictionary
 * @author Michael Druckman
 */
public class ComplexPlotsPosting<T> extends ComplexPlots<T>
	implements CommandDictionaryPosting
{

	public ComplexPlotsPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postSplotKeywordCommand() {
		id (super.constructSplotKeywordCommand(), OperatorNomenclature.SPLOT_KEYWORD);
	}

	public void postPlotriKeywordCommand() {
		id (super.constructPlotriKeywordCommand(), OperatorNomenclature.PLOTRI_KEYWORD);
	}

	public void postAngularKeywordCommand() {
		id (super.constructAngularKeywordCommand(), OperatorNomenclature.POLAR_ANGULAR_KEYWORD);
	}

	public void postRadialKeywordCommand() {
		id (super.constructRadialKeywordCommand(), OperatorNomenclature.POLAR_RADIAL_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postSplotKeywordCommand();
		postPlotriKeywordCommand();
		postAngularKeywordCommand();
		postRadialKeywordCommand();
	}

}
