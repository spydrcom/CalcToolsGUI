
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Symbol;
import net.myorb.calctools.atomic.Library;

import net.myorb.math.expressions.evaluationstates.Environment;
import net.myorb.math.expressions.symbols.AssignedVariableStorage;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.ValueManager;
import net.myorb.math.expressions.SymbolMap;

/**
 * a processing bean for declarations of constant values
 * @author Michael Druckman
 */
public class Constant extends Symbol
{

	public Constant (Library library)
	{
		super (library);
	}


	/**
	 * @return the text of the specified value specified
	 */
	public String getSpecifiedValue () { return specifiedValue; }
	public void setSpecifiedValue (String specifiedValue) { this.specifiedValue = specifiedValue; }
	protected String specifiedValue = null;


	/**
	 * @param e the representation of the Environment
	 * @return a named symbol object for the value stored as specifiedValue
	 * @param <T> manager for data type
	 */
	public <T> SymbolMap.Named getCompiledValue (Environment<T> e)
	{
		String constantSymbol = symbol; ValueManager.GenericValue value;
		(value =  evaluate (e.getSpaceManager (), e.getValueManager ())).setName (constantSymbol);
		return new AssignedVariableStorage (constantSymbol, value);
	}


	/**
	 * @param mgr a space manager for the represented data type
	 * @param vm a value manager that can map the underlying representation to the generic one
	 * @return the generic representation for the specified value
	 * @param <T> manager for data type
	 */
	public <T> ValueManager.GenericValue evaluate
	(ExpressionSpaceManager<T> mgr, ValueManager<T> vm)
	{
		return vm.newDiscreteValue (mgr.evaluate (specifiedValue));
	}


	/* (non-Javadoc)
	 * @see net.myorb.calctools.atomic.Symbol#symbolType()
	 */
	public String symbolType () { return " {CON} '" + specifiedValue + "'"; }


}

