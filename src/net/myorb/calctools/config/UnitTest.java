
package net.myorb.calctools.config;

import net.myorb.jxr.JxrScriptChoice;

/**
 * equivalent logic to XML driver
 * @author Michael Druckman
 */
public class UnitTest
{

	public static final void main (String[] args) throws Exception
	{
		JxrScriptChoice.runScript ("cfg/CalcToolsDomainChoice.xml");
	}

	public static final void main0 (String[] args) throws Exception
	{
		OptionList.addOption ("Real Numbers", "cfg/RealNumbers.xml");
		OptionList.addOption ("Factored Numbers", "cfg/FactoredNumbers.xml");
		OptionList.addOption ("Imaginary Numbers", "cfg/Complex.xml");
		new OptionPopup ();
	}

}
