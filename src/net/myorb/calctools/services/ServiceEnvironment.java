
package net.myorb.calctools.services;

import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.netcom.ServerConventions;
import net.myorb.netcom.protocol.RpcManagement;

import net.myorb.data.abstractions.ErrorHandling;
import net.myorb.gui.BackgroundTask;

/**
 * extend RPC service management for background.
 * - for use under swing components, execute in SwingWorker
 * @author Michael Druckman
 */
public class ServiceEnvironment extends RpcManagement
{

	/**
	 * provide Environment Access to processors
	 * @param <T> type from environment of application
	 */
	public interface Control<T>
		extends Environment.AccessAcceptance<T>
	{
		/**
		 * RPC service can be terminated from Control access
		 */
		void terminateTask ();
	}

	/**
	 * swing version of RPC management using SwingWorker
	 * @param name the name given to the service processor
	 * @param port the port number to be given to the service
	 * @return the control object for the SwingWorker wrapper
	 * @throws ErrorHandling.Notification for lookup failure
	 * @param <T> data type of environment
	 */
	public static <T> Control<T> startBackgroundService (String name, String port)
	{
		BackgroundService<T> svc = new BackgroundService<T>
			(lookupProcessor (name), Integer.parseInt (port));
		svc.setName (name); svc.startTask ();
		return svc;
	}

}

/**
 * SwingWorker control object for service
 * @param <T> data type of environment
 */
class BackgroundService<T> extends BackgroundTask
	implements ServiceEnvironment.Control<T>
{

	protected BackgroundService
	(ServerConventions.Processor processor, int port)
	{
		super
		(
			new ServerConventions
			(
				port,
				processor,
				"\f"
			)
		);
		this.processor = processor;
	}
	protected ServerConventions.Processor processor;

	/**
	 * @param name a name to give the service
	 */
	public void setName (String name)
	{
		((ServerConventions) task).setName (name);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.expressions.evaluationstates.Environment.AccessAcceptance#setEnvironment(net.myorb.math.expressions.evaluationstates.Environment)
	 */
	public void setEnvironment (Environment<T> environment)
	{
		environment.provideAccessTo (processor);
	}

}
