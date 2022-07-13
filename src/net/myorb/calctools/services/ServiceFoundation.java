
package net.myorb.calctools.services;

import net.myorb.math.expressions.ExpressionComponentSpaceManager;
import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.rpc.primitive.ServerConventions;

/**
 * base class for RPC service implementations
 * @param <T> type on which operations are to be executed
 * @author Michael Druckman
 */
public class ServiceFoundation <T>
	implements ServerConventions.Processor, Environment.AccessAcceptance <T>
{

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.evaluationstates.Environment.AccessAcceptance#setEnvironment(net.myorb.math.expressions.evaluationstates.Environment)
	 */
	public void setEnvironment (Environment <T> environment)
	{
		this.manager = (ExpressionComponentSpaceManager <T>)
				environment.getSpaceManager ();
		this.environment = environment;
	}
	protected ExpressionComponentSpaceManager <T> manager;
	protected Environment <T> environment;

}
