
package net.myorb.calctools.config;

import java.util.ArrayList;

/**
 * collect a list of configuration choices
 * @author Michael Druckman
 */
public class OptionList
{

	static ArrayList<NameValuePair> items = new ArrayList<> ();

	public static void addOption (String name, String value)
	{
		items.add (new NameValuePair (name, value));
	}

}
