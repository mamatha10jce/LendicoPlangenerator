package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lendico.codingtask.plangenerator.modeldata.Repayment;
import com.lendico.codingtask.plangenerator.modeldata.RepaymentPlan;

/**
 * @author Mamatha Shivanna
 *
 */
public interface RepaymentService {
	/**
	 * @param loanAmount
	 *           
	 * @param nominalRate
	 *           
	 * @param duration
	 *            
	 * @param startDate
	 *            
	 * @return The  repayments plan for the given input values
	 */
	RepaymentPlan generatePlan(BigDecimal loanAmount, double nominalRate, int duration, LocalDateTime startDate);

	/**
	 * Calculates the repayments for a given month after the start date.
	 * 
	 * @param loanAmount
	 *            
	 * @param nominalRate
	 *            
	 * @param duration
	 *           
	 * @param startDate
	 *           
	 * @param initialOutstandingPrincipal
	 *           
	 * @param monthsAfterStart
	 *           
	 * @return The resulting repayment for the given input values
	 */
	Repayment generateRepayment(BigDecimal loanAmount, double nominalRate, int duration, LocalDateTime startDate,
			BigDecimal initialOutstandingPrincipal, int monthsAfterStart);
}
