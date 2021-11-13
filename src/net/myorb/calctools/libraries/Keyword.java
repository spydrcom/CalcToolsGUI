
package net.myorb.calctools.libraries;

import net.myorb.calctools.atomic.Library;

public class Keyword extends Library
{

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	String prefix = "construct", suffix = "KeywordCommand";

	private static final long serialVersionUID = 4115663847054627626L;

}
