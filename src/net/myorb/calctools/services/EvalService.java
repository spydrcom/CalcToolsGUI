
package net.myorb.calctools.services;

import net.myorb.data.abstractions.ServerConventions;

import net.myorb.math.expressions.evaluationstates.Environment;

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
		return environment.getControl ().evaluate (request).toString ();
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.evaluationstates.Environment.AccessAcceptance#setEnvironment(net.myorb.math.expressions.evaluationstates.Environment)
	 */
	public void setEnvironment (Environment<T> environment)
	{
		this.environment = environment;
	}
	Environment<T> environment;

}
