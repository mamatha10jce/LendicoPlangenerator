package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;

/**
 * @author Mamatha Shivanna
 *
 */
public interface RepaymentCalculatorService {

	final static int DAYS_IN_MONTH = 30;
	final static int DAYS_IN_YEAR = 360;

	/**
	 * Given the values of the initial outstanding principal and the principal,
	 * calculates the remaining outstanding principal.
	 * 
	 * @param initialOutstandingPrincipal
	 *            
	 * @param principal
	 *            
	 * @return The  remaining outstanding principal value
	 */
	BigDecimal calculateRemainingOutstandingPrincipal(BigDecimal initialOutstandingPrincipal, BigDecimal principal);

	/**
	 * Given an interest calculated value and an annuity, calculates the principal
	 * value.
	 * 
	 * @param interest
	 *            
	 * @param annuity
	 *            
	 * @return The  principal value
	 */
	BigDecimal calculatePrincipal(BigDecimal interest, BigDecimal annuity);

	/**
	 * Given the nominal interest rate and the initial outstanding principal value,
	 * calculates the interest value.
	 * 
	 * @param nominalRate
	 *            
	 * @param initialOutstandingPrincipal
	 *           
	 * @return The  interest value
	 */
	BigDecimal calculateInterest(double nominalRate, BigDecimal initialOutstandingPrincipal);

}
