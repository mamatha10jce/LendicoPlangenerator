package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author Mamatha Shivanna
 *
 */
@Service
public class RepaymentCalculatorServiceImpl implements RepaymentCalculatorService {
	/* (non-Javadoc)
	 * @see com.lendico.codingtask.plangenerator.service.RepaymentCalculatorService#calculateRemainingOutstandingPrincipal(java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public BigDecimal calculateRemainingOutstandingPrincipal(BigDecimal initialOutstandingPrincipal,
			BigDecimal principal) {
		// Calculates outstanding principal
		BigDecimal remainingOutstandingPrincipal;
		remainingOutstandingPrincipal = initialOutstandingPrincipal.subtract(principal);
		/* Because the value cannot be negative, it is set to zero */
		if (remainingOutstandingPrincipal.compareTo(BigDecimal.ZERO) < 0) {
			remainingOutstandingPrincipal = BigDecimal.ZERO.setScale(2);
		}
		return remainingOutstandingPrincipal;
	}

	@Override
	public BigDecimal calculatePrincipal(BigDecimal interest, BigDecimal annuity) {
		BigDecimal principal = annuity.subtract(interest);
		principal = principal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return principal;
	}

	@Override
	public BigDecimal calculateInterest(double nominalRate, BigDecimal initialOutstandingPrincipal) {
		// Interest calculation
		BigDecimal interest = new BigDecimal(
				nominalRate * DAYS_IN_MONTH * initialOutstandingPrincipal.doubleValue() / DAYS_IN_YEAR);
		// Divides by 100 and rounds it with the rounding method
		interest = interest.divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return interest;
	}
}
