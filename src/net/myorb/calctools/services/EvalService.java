
package net.myorb.calctools.services;

import net.myorb.data.abstractions.ServerConventions;

import net.myorb.data.notations.json.JsonPrettyPrinter;
import net.myorb.data.notations.json.JsonLowLevel.JsonValue;

/**
 * evaluate expression by RPC using socket server
 * @author Michael Druckman
 */
public class EvalService implements ServerConventions.JsonProcessor
{

	/*
	 * initial version to verify service install works and service can then be invoked via RPC
	 */

	/* (non-Javadoc)
	 * @see net.myorb.data.abstractions.ServerConventions.JsonProcessor#process(net.myorb.data.notations.json.JsonLowLevel.JsonValue)
	 */
	public String process (JsonValue value)
	{
		try { JsonPrettyPrinter.sendTo (value, System.out); } catch (Exception e) {}
		return "OK, response incomplete";
	}

}
