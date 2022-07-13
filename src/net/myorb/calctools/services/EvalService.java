
package net.myorb.calctools.services;

import net.myorb.rpc.primitive.ServerConventions;

/**
 * evaluate expression by RPC using socket server
 * @param <T> type on which operations are to be executed
 * @author Michael Druckman
 */
public class EvalService <T> extends ServiceFoundation <T>
	implements ServerConventions.RawTextProcessor
{

	/* (non-Javadoc)
	 * @see net.myorb.data.abstractions.ServerConventions.RawTextProcessor#process(java.lang.String)
	 */
	public String process (String request) throws Exception
	{
		Long traffic;
		StringBuffer buffer = new StringBuffer ();
		if ((traffic = processTraffic (request)) != null) buffer.append (traffic);
		else processEvaluation (environment.getControl ().evaluate (request), buffer);
		return buffer.toString ();
	}

	/**
	 * build response to evaluation request
	 * @param result the resulting value from the evaluation
	 * @param buffer a buffer to hold the generated response
	 */
	public void processEvaluation (T result, StringBuffer buffer)
	{
		buffer.append ("[ [ ");
		for (int i = 0; i < manager.getComponentCount (); i++)
		{
			if ( i > 0 ) { buffer.append (", "); }
			buffer.append (manager.component (result, i));
		}
		buffer.append (" ] ]");
	}

	/**
	 * determine type of request
	 * @param request the text of the RPC request
	 * @return NULL if not a traffic request, otherwise the traffic count
	 */
	public Long processTraffic (String request)
	{
		traffic++;
		if ( ! request.equals ("?") ) return null;
		else return traffic;
	}
	protected long traffic = 0;

}
