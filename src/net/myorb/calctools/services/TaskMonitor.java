
package net.myorb.calctools.services;

import net.myorb.data.notations.json.JsonPrettyPrinter;
import net.myorb.data.notations.json.JsonLowLevel.JsonValue;
import net.myorb.rpc.primitive.ServerConventions;

/**
 * monitor task progress by RPC using socket server
 * @param <T> type on which operations are to be executed
 * @author Michael Druckman
 */
public class TaskMonitor <T> extends ServiceFoundation <T>
	implements ServerConventions.JsonProcessor
{

	/* (non-Javadoc)
	 * @see net.myorb.rpc.primitive.ServerConventions.JsonProcessor#process(net.myorb.data.notations.json.JsonLowLevel.JsonValue)
	 */
	public String process (JsonValue request)
	{
		try { JsonPrettyPrinter.sendTo (request, System.out); } catch (Exception e) {}
		return "OK, handshake complete";
	}

	/* (non-Javadoc)
	 * @see net.myorb.rpc.primitive.ServerConventions.DirectedProcessor#handle(java.lang.String)
	 */
	public String handle (String directive) throws Exception
	{
		return "123456";
	}

}
