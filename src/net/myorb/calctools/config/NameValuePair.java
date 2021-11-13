
package net.myorb.calctools.config;

/**
 * pair a display name with the config file path
 * @author Michael Druckman
 */
public class NameValuePair
{
	NameValuePair (String name, String path)
	{ this.name = name; this.path = path;  }
	public String toString () { return name; }
	String getPath () { return path; }
	String name, path;
}
