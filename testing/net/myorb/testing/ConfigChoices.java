
package net.myorb.testing;

import net.myorb.gui.components.SimplePopupRequest;

import java.util.ArrayList;
import java.util.List;

public class ConfigChoices extends SimplePopupRequest<NameValuePair>
{

	/**
	 * enumerated list of factory objects available
	 */
	class Configurations
		extends ArrayList<NameValuePair>
	{
		public Configurations ()
		{
			add (new NameValuePair ("Real Numbers", "cfg/RealNumbers.xml"));
			add (new NameValuePair ("Factored Numbers", "cfg/FactoredNumbers.xml"));
			add (new NameValuePair ("Imaginary Numbers", "cfg/Complex.xml"));
		}
		private static final long serialVersionUID = 5758872797449622910L;
	}

	/*
	 * description of the field
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getOptions()
	 */
	public List<NameValuePair> getOptions () { return new Configurations (); }

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
	public int getFrameHeight () { return 50; }

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#getFrameWidth()
	 */
	public int getFrameWidth () { return 400; }

	/*
	 * feedback selection to user
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#formatNotificationFor(java.lang.Object)
	 */
	public String formatNotificationFor (NameValuePair selectedItem)
//	{ return "'" + selectedItem + "' Will Now Be Used"; }
	{ return null; }

	/*
	 * identify selection to implementation
	 */

	/* (non-Javadoc)
	 * @see net.myorb.gui.components.SimplePopupRequest#setSelectedItem(java.lang.Object)
	 */
	public void setSelectedItem (NameValuePair item)
	{ Configuration.setConfig (item.getPath ()); }

	/*
	 * unit test
	 */

	/**
	 * unit test for menu
	 * @param args not used
	 */
	public static void main (String[] args)
	{
		new ConfigChoices ();
	}

}

class NameValuePair
{
	NameValuePair (String name, String path)
	{ this.name = name; this.path = path;  }
	public String toString () { return name; }
	String getPath () { return path; }
	String name, path;
}

