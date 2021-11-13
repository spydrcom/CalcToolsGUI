
package net.myorb.calctools.config;

import net.myorb.math.expressions.gui.DisplayIO;
import net.myorb.gui.components.MdiFrameController;

import javax.swing.ImageIcon;

import net.myorb.gui.components.GuiToolkit;
import net.myorb.jxr.JxrScriptChoice;

/**
 * main entry for XML driver using JXR.
 *  updated to process arguments to accept 
 *  alternate configuration parameters
 * @author Michael Druckman
 */
public class CalcTools
{
	public static final void main (String[] args) throws Exception
	{
		GuiToolkit.setApplicationIcon (MASTER_ICON);
		process (args); JxrScriptChoice.runScript (SCRIPT);
	}
	public static final void process (String[] args) throws Exception
	{
		if (args == null || args.length == 0) return;
		JxrScriptChoice.preparation = new Preparation ();
		GuiToolkit.setApplicationIcon (DARKER_ICON);
		DisplayIO.useUpdatedConfiguration ();
	}
	public static String
	MASTER_ICON = "images/logo.gif",
	SCRIPT = "cfg/datatypes/CalcToolsDomainChoice.xml",
	DARKER_ICON = "images/icon-curl-70.gif";
}

/**
 * permit choice display to use common frame.
 *  prepare for use of MDI when application starts
 */
class Preparation implements JxrScriptChoice.Steps
{
	/* (non-Javadoc)
	 * @see net.myorb.jxr.JxrScriptChoice.Steps#doSteps()
	 */
	public void doSteps ()
	{
		MdiFrameController mdi = null;
		GuiToolkit.setFrameController (mdi = new MdiFrameController ());
		JxrScriptChoice.conclusion = new Middle (mdi);
	}
}

/**
 * pass MDI to end of configuration
 */
class Middle implements JxrScriptChoice.Steps
{
	/* (non-Javadoc)
	 * @see net.myorb.jxr.JxrScriptChoice.Steps#doSteps()
	 */
	public void doSteps ()
	{ JxrScriptChoice.conclusion = new Conclusion (mdi); }
	Middle (MdiFrameController mdi) { this.mdi = mdi; }
	MdiFrameController mdi = null;
}

/**
 * build MDI master frame once configuration concludes
 */
class Conclusion implements JxrScriptChoice.Steps
{
	/* (non-Javadoc)
	 * @see net.myorb.jxr.JxrScriptChoice.Steps#doSteps()
	 */
	public void doSteps ()
	{
		mdi.constructMasterFrame ("CalcTools");
		mdi.getMasterFrame ().setIconImage (new ImageIcon (CalcTools.MASTER_ICON).getImage ());
		mdi.showMasterFrame ();
	}
	Conclusion (MdiFrameController mdi) { this.mdi = mdi; }
	MdiFrameController mdi = null;
}

