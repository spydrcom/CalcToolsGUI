
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.Features;
import net.myorb.math.expressions.OperatorNomenclature;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to core features.
 *  post the core features commands to dictionary
 * @author Michael Druckman
 */
public class FeaturesPosting<T> extends Features<T>
	implements CommandDictionaryPosting
{

	public FeaturesPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postMandelbrotKeywordCommand() {
		id (super.constructMandelbrotKeywordCommand(), OperatorNomenclature.MANDELBROT_KEYWORD);
	}

	public void postPolynomialKeywordCommand() {
		id (super.constructPolynomialKeywordCommand(), OperatorNomenclature.POLYNOMIAL_KEYWORD);
	}

	public void postRootKeywordCommand() {
		id (super.constructRootKeywordCommand(), OperatorNomenclature.ROOTOF_KEYWORD);
	}

	public void postMaxMinKeywordCommand() {
		id (super.constructMaxMinKeywordCommand(), OperatorNomenclature.MAXMINOF_KEYWORD);
	}

	public void postDctKeywordCommand() {
		id (super.constructDctKeywordCommand(), OperatorNomenclature.DCT_KEYWORD);
	}

	public void postRpnCommand() {
		id (super.constructRpnCommand(), OperatorNomenclature.RPN_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postMandelbrotKeywordCommand();
		postPolynomialKeywordCommand();
		postRootKeywordCommand();
		postMaxMinKeywordCommand();
		postDctKeywordCommand();
		postRpnCommand();
	}

}
