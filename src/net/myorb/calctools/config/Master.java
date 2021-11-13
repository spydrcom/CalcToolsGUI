
package net.myorb.calctools.config;

import net.myorb.jxr.JxrParser;
import net.myorb.jxr.JxrPrimitives;
import net.myorb.jxr.JxrReport;

/**
 * main entry for XML driver using JXR
 * @author Michael Druckman
 */
public class Master
{

	public static final JxrPrimitives.SymbolTable 
				run (String path)
	{
		JxrPrimitives.SymbolTable symbols = null;
		try { symbols = JxrParser.read (path); }
		catch (Exception e) { e.printStackTrace (); }
		return symbols;
	}

	public static final void runScript (String path)
	{
		JxrReport.dump (run (path));
	}

	public static final void main (String[] args) throws Exception
	{
		run ("cfg/DomainChoice.xml");
	}

}
