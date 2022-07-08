
package net.myorb.calctools.services;

import net.myorb.math.expressions.evaluationstates.Environment;

import net.myorb.data.abstractions.ErrorHandling;

import net.myorb.rpc.primitive.ServerConventions;
import net.myorb.rpc.protocol.RpcManagement;

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

	/**
	 * start the named service
	 * @param serviceName the identifier for the service
	 * @param onPort the port assigned for use of this service
	 * @param inEnvironment the application environment serving requests
	 * @param <T> data type of environment
	 */
	public static <T> void start
		(
			String serviceName, String onPort,
			Environment<T> inEnvironment
		)
	{
		Control<T> processor =
				startBackgroundService (serviceName, onPort);
		inEnvironment.provideAccessTo (processor);
	}

	/**
	 * ErrorHandling around port assignment
	 * @param serviceNamed the identifier for the service
	 * @param requestingPort the port commonly assigned for this service
	 * @return the port assigned by the service management system
	 */
	public static String post (String serviceNamed, String requestingPort)
	{
		try
		{ return assign (serviceNamed, requestingPort); }
		catch (ErrorHandling.Messages m) { throw m; }
		catch (Exception e) { fail (e); }
		return null;
	}

	/**
	 * request port assignment for a service
	 * @param serviceNamed the identifier for the service
	 * @param requestingPort the port commonly assigned for this service
	 * @return the port assigned by the service management system
	 * @throws Exception for port assignment errors
	 */
	public static String assign (String serviceNamed, String requestingPort) throws Exception
	{
		String assignedPort = RpcManagement.post (serviceNamed, requestingPort);
		if (assignedPort == null) throw new ErrorHandling.Notification ("Port assignment failed");
		return assignedPort;
	}

	/**
	 * ErrorHandling for unexpected Exception
	 * @param e the exception received during the attempt
	 * @throws ErrorHandling.Messages the translated configuration message
	 */
	public static void fail (Exception e) throws ErrorHandling.Messages
	{
		throw new ErrorHandling.Terminator ("Configuration fails to support RPC", e);
	}

	/**
	 * register the service to assign a port then start
	 * @param serviceNamed the identifier for the service
	 * @param requestingPort the port commonly assigned for this service
	 * @param inEnvironment the application environment serving requests
	 * @return the port assigned to the named service
	 * @param <T> data type of environment
	 */
	public static <T> String registerAndStart
	(String serviceNamed, String requestingPort, Environment<T> inEnvironment)
	{
		String assignedPort = post (serviceNamed, requestingPort);
		start (serviceNamed, assignedPort, inEnvironment);
		return assignedPort;
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
