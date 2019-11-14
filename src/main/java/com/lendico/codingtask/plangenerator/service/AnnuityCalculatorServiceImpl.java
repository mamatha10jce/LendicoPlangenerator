package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

/**
 * @author Mamatha Shivanna
 *
 */
@Service
public class AnnuityCalculatorServiceImpl implements AnnuityCalculatorService {

	@Override
	public BigDecimal calculate(BigDecimal loanAmount, double nominalRate, int duration) {

		// Normalise the rate as a percentage.
		nominalRate = nominalRate / 100.0;

		// Divide the nominal rate by the number of months in a year
		double nominalRateByMonth = nominalRate / 12.0;

		// Calculates the annuity based on the formula
		double annuity = (loanAmount.doubleValue() * nominalRateByMonth)
				/ (1 - Math.pow(1 + nominalRateByMonth, -duration));

		// Consolidate and round the result
		BigDecimal result = new BigDecimal(annuity);
		result = result.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return result;
	}
}