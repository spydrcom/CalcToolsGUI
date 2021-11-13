
package net.myorb.calctools.dictionary;

import net.myorb.calctools.commands.PropertyManagement;
import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.OperatorNomenclature;

/**
 * commands related to Property Management.
 *  post the Property Management commands to dictionary
 * @author Michael Druckman
 */
public class PropertyManagementPosting<T> extends PropertyManagement<T>
	implements CommandDictionaryPosting
{

	public PropertyManagementPosting
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }

	public void postPsetCommand() {
		id (super.constructPsetCommand(), OperatorNomenclature.PSET_KEYWORD);
	}

	public void postPdelCommand() {
		id (super.constructPdelCommand(), OperatorNomenclature.PDEL_KEYWORD);
	}

	public void postPclrCommand() {
		id (super.constructPclrCommand(), OperatorNomenclature.PCLR_KEYWORD);
	}

	public void postPloadCommand() {
		id (super.constructPloadCommand(), OperatorNomenclature.PLOAD_KEYWORD);
	}

	public void postPsaveCommand() {
		id (super.constructPsaveCommand(), OperatorNomenclature.PSAVE_KEYWORD);
	}

	/* (non-Javadoc)
	 * @see net.myorb.calctools.dictionary.CommandDictionaryPosting#postAll()
	 */
	public void postAll() {
		postPsaveCommand();
		postPloadCommand();
		postPclrCommand();
		postPdelCommand();
		postPsetCommand();
	}

}
