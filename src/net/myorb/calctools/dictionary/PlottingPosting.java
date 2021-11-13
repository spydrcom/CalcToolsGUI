
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Plotting;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to plots / charts / graphs in general.
 *  post the plotting related commands to dictionary
 * @author Michael Druckman
 */
public class PlottingPosting<T> extends Plotting<T>
{

	public PlottingPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postPlottKeywordCommand() {
		id (super.constructPlottKeywordCommand(), OperatorNomenclature.PLOTT_KEYWORD);
	}

	public void postPlotmKeywordCommand() {
		id (super.constructPlotmKeywordCommand(), OperatorNomenclature.PLOTM_KEYWORD);
	}

	public void postPlot3dKeywordCommand() {
		id (super.constructPlot3dKeywordCommand(), OperatorNomenclature.PLOT3D_KEYWORD);
	}

	public void postScatterKeywordCommand() {
		id (super.constructScatterKeywordCommand(), OperatorNomenclature.SCATTER_KEYWORD);
	}

	public void postFftKeywordCommand() {
		id (super.constructFftKeywordCommand(), OperatorNomenclature.FFT_KEYWORD);
	}

	public void postComparisonKeywordCommand() {
		id (super.constructComparisonKeywordCommand(), OperatorNomenclature.SIDEBYSIDE_KEYWORD);
	}

	public void postPlotcKeywordCommand() {
		id (super.constructPlotcKeywordCommand(), OperatorNomenclature.PLOTC_KEYWORD);
	}

	public void postSetContourKeywordCommand() {
		id (super.constructSetContourKeywordCommand(), OperatorNomenclature.SETCONTOUR_KEYWORD);
	}

	public void postEntitledKeywordCommand() {
		id (super.constructEntitledKeywordCommand(), OperatorNomenclature.ENTITLED_KEYWORD);
	}

	public void postGraphKeywordCommand() {
		id (super.constructGraphKeywordCommand(), OperatorNomenclature.GRAPH_KEYWORD);
	}

	public void postChartKeywordCommand() {
		id (super.constructChartKeywordCommand(), OperatorNomenclature.CHART_KEYWORD);
	}

	public void postDeriveKeywordCommand() {
		id (super.constructDeriveKeywordCommand(), OperatorNomenclature.DERIVE_KEYWORD);
	}

	public void postPlotfKeywordCommand() {
		id (super.constructPlotfKeywordCommand(), OperatorNomenclature.PLOTF_KEYWORD);
	}

	public void postAll() {
		postPlotfKeywordCommand();
		postDeriveKeywordCommand();
		postChartKeywordCommand();
		postGraphKeywordCommand();
		postPlottKeywordCommand();
		postPlotmKeywordCommand();
		postPlot3dKeywordCommand();
		postScatterKeywordCommand();
		postComparisonKeywordCommand();
		postSetContourKeywordCommand();
		postEntitledKeywordCommand();
		postPlotcKeywordCommand();
		postFftKeywordCommand();
	}

}
