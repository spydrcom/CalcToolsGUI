
package net.myorb.calctools.services;

import net.myorb.data.notations.json.JsonPrettyPrinter;
import net.myorb.data.notations.json.JsonLowLevel.JsonValue;

import net.myorb.rpc.primitive.ServerConventions;

/**
 * process chart meta-data to sync for evaluation
 * @author Michael Druckman
 */
public class ChartSync<T> extends ServiceFoundation<T>
	implements ServerConventions.JsonProcessor
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

	/* (non-Javadoc)
	 * @see net.myorb.rpc.primitive.ServerConventions.DirectedProcessor#handle(java.lang.String)
	 */
	public String handle(String directive) throws Exception {
		return null;
	}

}
