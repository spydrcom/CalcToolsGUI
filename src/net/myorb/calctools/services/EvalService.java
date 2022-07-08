
package net.myorb.calctools.services;

import net.myorb.rpc.primitive.ServerConventions;

/**
 * evaluate expression by RPC using socket server
 * @author Michael Druckman
 */
public class EvalService<T> extends ServiceFoundation<T>
	implements ServerConventions.RawTextProcessor
{

	/* (non-Javadoc)
	 * @see net.myorb.data.abstractions.ServerConventions.RawTextProcessor#process(java.lang.String)
	 */
	public String process (String request) throws Exception
	{
		StringBuffer buffer = new StringBuffer ("[ [ ");
		T result = environment.getControl ().evaluate (request);
		for (int i = 0; i < manager.getComponentCount (); i++)
		{
			if ( i > 0 ) { buffer.append (", "); }
			buffer.append (manager.component (result, i));
		}
		buffer.append (" ] ]");
		return buffer.toString ();
	}

}
