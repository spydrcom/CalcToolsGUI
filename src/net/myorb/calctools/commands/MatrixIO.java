
package net.myorb.calctools.commands;

import net.myorb.math.expressions.commands.CommandSequence;
import net.myorb.math.expressions.commands.KeywordCommand;
import net.myorb.math.expressions.ExpressionSpaceManager;

/**
 * commands related to matrix features
 * @author Michael Druckman
 */
public class MatrixIO<T> extends Context<T>
{


	public MatrixIO
	(ExpressionSpaceManager<T> manager)
	{ super (manager); }


	/**
	 * import data from a file
	 * @return a keyword command for the IMPORT keyword
	 */
	public KeywordCommand constructImportKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public String describe ()
			{
				return "Import data from a file into specified matrix";
			}

			public void execute (CommandSequence tokens)
			{
				String matrixSymbol = getNextOperandImage (tokens);
				engine.getDataIO ().read (filename (tokens), matrixSymbol);
			}
		};
	}


	/**
	 * export data to a file
	 * @return a keyword command for the EXPORT keyword
	 */
	public KeywordCommand constructExportKeywordCommand ()
	{
		return new KeywordCommand ()
		{
			public void execute (CommandSequence tokens)
			{
				engine.getDataIO ().write
				(
					filename (tokens),
					getMatrixFrom (getNextOperandImage (tokens))
				);
			}

			public String describe ()
			{
				return "Export data to a file from specified matrix";
			}
		};
	}


}

