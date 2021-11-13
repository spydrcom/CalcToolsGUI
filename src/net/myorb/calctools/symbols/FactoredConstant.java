
package net.myorb.calctools.symbols;

import net.myorb.calctools.atomic.Library;

import net.myorb.math.primenumbers.Factorization;
import net.myorb.math.primenumbers.FactorizationManager;

import net.myorb.math.expressions.ExpressionSpaceManager;
import net.myorb.math.expressions.ValueManager;

import java.math.BigInteger;

/**
 * a sub-class of processing bean for declarations of constant values.
 *  constants described as factored will be represented as a ratio of BigInteger values.
 *  both numerator and denominator may have hundreds of digits so hardware formats cannot be used.
 * @author Michael Druckman
 */
public class FactoredConstant extends Constant
{

	public FactoredConstant (Library library)
	{
		super(library);
	}


	/* (non-Javadoc)
	 * @see net.myorb.calctools.symbols.Constant#evaluate(net.myorb.math.expressions.ExpressionSpaceManager, net.myorb.math.expressions.ValueManager)
	 */
	@SuppressWarnings("unchecked")
	public <T> ValueManager.GenericValue evaluate
	(ExpressionSpaceManager<T> mgr, ValueManager<T> vm)
	{
		ExpressionSpaceManager<Factorization> fmgr =
				(ExpressionSpaceManager<Factorization>) mgr;
		ValueManager<Factorization> fvm = (ValueManager<Factorization>) vm;
		return evaluateFactored (fmgr, fvm);
	}


	/**
	 * specialized evaluation for factored representation
	 * @param mgr a space manager for the represented data type
	 * @param vm a value manager that can map the underlying representation to the generic one
	 * @return the generic representation for the specified value
	 */
	public ValueManager.GenericValue evaluateFactored
	(ExpressionSpaceManager<Factorization> mgr, ValueManager<Factorization> vm)
	{
		String[] fraction = specifiedValue.split ("/");
		BigInteger numerator = new BigInteger (fraction[0]);
		BigInteger denominator = new BigInteger (fraction[1]);
		Factorization n = FactorizationManager.findFactorization (numerator);
		Factorization d = FactorizationManager.findFactorization (denominator);
		Factorization r = mgr.multiply (n, mgr.invert (d));
		return vm.newDiscreteValue (r);
	}


}


