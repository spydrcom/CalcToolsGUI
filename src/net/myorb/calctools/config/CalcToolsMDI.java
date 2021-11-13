
package net.myorb.calctools.config;

/**
 * main entry for XML driver using JXR.
 *  alternate configuration parameters passed to
 *  CalcTools entry to request the MDI presented GUI
 * @author Michael Druckman
 */
public class CalcToolsMDI
{
	public static final void main (String[] args) throws Exception
	{
		CalcTools.main (new String[]{"MDI"});
	}
}
