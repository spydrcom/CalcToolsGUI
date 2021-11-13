
package net.myorb.testing;

import net.myorb.jxr.JxrParser;
import net.myorb.jxr.JxrPrimitives;
import net.myorb.jxr.JxrReport;

public class Configuration
{
	public static final void setConfig (String path)
	{
		JxrPrimitives.SymbolTable symbols = null;
		try { symbols = JxrParser.read (path); }
		catch (Exception e) { e.printStackTrace (); }
		JxrReport.dump (symbols);
	}
	public static final void main (String[] args) throws Exception
	{
		JxrPrimitives.SymbolTable symbols;
		if (REAL) symbols = JxrParser.read ("cfg/RealNumbers.xml");
		else symbols = JxrParser.read ("cfg/Complex.xml");
		JxrReport.dump (symbols);
	}
	static boolean REAL = false;
}
