
package net.myorb.calctools.services;

import net.myorb.math.expressions.ExpressionComponentSpaceManager;

import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.data.abstractions.ServerConventions;

/**
 * evaluate expression by RPC using socket server
 * @author Michael Druckman
 */
public class EvalService<T>
	implements ServerConventions.RawTextProcessor, Environment.AccessAcceptance<T>
{

	/*
	 * initial version to verify service install works and service can then be invoked via RPC
	 */

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

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.evaluationstates.Environment.AccessAcceptance#setEnvironment(net.myorb.math.expressions.evaluationstates.Environment)
	 */
	public void setEnvironment (Environment<T> environment)
	{
		this.manager = (ExpressionComponentSpaceManager<T>) environment.getSpaceManager();
		this.environment = environment;
	}
	ExpressionComponentSpaceManager<T> manager;
	Environment<T> environment;

}
