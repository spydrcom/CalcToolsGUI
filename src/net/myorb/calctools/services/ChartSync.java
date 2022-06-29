
package net.myorb.calctools.services;

import net.myorb.data.abstractions.ServerConventions;
import net.myorb.data.notations.json.JsonPrettyPrinter;
import net.myorb.data.notations.json.JsonLowLevel.JsonValue;
import net.myorb.math.expressions.evaluationstates.Environment;

/**
 * process chart meta-data to sync for evaluation
 * @author Michael Druckman
 */
public class ChartSync<T>
	implements ServerConventions.JsonProcessor, Environment.AccessAcceptance<T>
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
	 * @see net.myorb.math.expressions.evaluationstates.Environment.AccessAcceptance#setEnvironment(net.myorb.math.expressions.evaluationstates.Environment)
	 */
	public void setEnvironment (Environment<T> environment)
	{
		
	}

}
