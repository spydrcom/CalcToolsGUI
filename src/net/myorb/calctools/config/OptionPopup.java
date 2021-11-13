
package net.myorb.calctools.config;

import net.myorb.gui.components.SimplePopupRequest;

import java.util.List;

/**
 * instance of simple PopUp to use with XML driver
 * @author Michael Druckman
 */
public class OptionPopup extends SimplePopupRequest<NameValuePair>
{

	/*
	 * description of the field
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getOptions()
	 */
	public List<NameValuePair> getOptions () { return OptionList.items; }

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getFieldWidth()
	 */
	public int getFieldWidth () { return 20; }

	/*
	 * description of the frame
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getFrameTitle()
	 */
	public String getFrameTitle () { return "Choose Data Type"; }

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getFrameHeight()
	 */
	public int getFrameHeight () { return 100; }

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getFrameWidth()
	 */
	public int getFrameWidth () { return 300; }

	/*
	 * feedback selection to user
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#formatNotificationFor(java.lang.Object)
	 */
	public String formatNotificationFor (NameValuePair selectedItem) { return null; }

	/*
	 * identify selection to implementation
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#setSelectedItem(java.lang.Object)
	 */
	public void setSelectedItem (NameValuePair item)
	{ Master.runScript (item.getPath ()); }

}
