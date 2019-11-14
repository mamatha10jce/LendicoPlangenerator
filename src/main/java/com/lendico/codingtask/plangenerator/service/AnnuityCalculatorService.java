package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;

/**
 * @author Mamatha Shivanna
 *
 */
public interface AnnuityCalculatorService {

	BigDecimal calculate(BigDecimal loanAmount, double nominalRate, int duration);
}
