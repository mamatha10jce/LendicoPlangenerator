package com.lendico.codingtask.plangenerator.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendico.codingtask.plangenerator.modeldata.Repayment;
import com.lendico.codingtask.plangenerator.modeldata.RepaymentPlan;

/**
 * @author Mamatha Shivanna
 *
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {

	@Autowired
	private AnnuityCalculatorService annuityCalculator;

	@Autowired
	private RepaymentCalculatorService repaymentCalculator;

	/**
	 * Constructor.
	 * 
	 */
	public RepaymentServiceImpl() {
	}

	/**
	 * Constructor.
	 * 
	 * @param annuityCalculator
	 *            A valid implementation of {@link AnnuityCalculator}
	 * @param repaymentCalculator
	 *            A valid implementation of {@link RepaymentCalculatorService}
	 */
	public RepaymentServiceImpl(AnnuityCalculatorService annuityCalculator,
			RepaymentCalculatorService repaymentCalculator) {
		this.annuityCalculator = annuityCalculator;
		this.repaymentCalculator = repaymentCalculator;
	}

	@Override
	public RepaymentPlan generatePlan(BigDecimal loanAmount, double nominalRate, int duration,
			LocalDateTime startDate) {
		List<Repayment> repayments = new ArrayList<>();
		BigDecimal initialOutstandingPrincipal = loanAmount;

		for (int i = 0; i < duration; i++) {
			Repayment repayment = generateRepayment(loanAmount, nominalRate, duration, startDate,
					initialOutstandingPrincipal, i);

			/* initial outstanding principal for the coming month. */
			BigDecimal remainingOutstandingPrincipal = repayment.getRemainingOutstandingPrincipal();
			initialOutstandingPrincipal = remainingOutstandingPrincipal;
			repayments.add(repayment);
		}

		RepaymentPlan plan = new RepaymentPlan();
		plan.setRepayments(repayments);
		return plan;
	}

	@Override
	public Repayment generateRepayment(BigDecimal loanAmount, double nominalRate, int duration, LocalDateTime startDate,
			BigDecimal initialOutstandingPrincipal, int monthsAfterStart) {

		Repayment repayment = new Repayment();

		// Date
		LocalDateTime date = startDate.plusMonths(monthsAfterStart);
		repayment.setDate(date);

		// Interest
		BigDecimal interest = repaymentCalculator.calculateInterest(nominalRate, initialOutstandingPrincipal);
		repayment.setInterest(interest);

		// Annuity
		BigDecimal annuity = annuityCalculator.calculate(loanAmount, nominalRate, duration);
		repayment.setBorrowerPaymentAmount(annuity);

		// Principal
		BigDecimal principal = repaymentCalculator.calculatePrincipal(interest, annuity);
		repayment.setPrincipal(principal);

		// Initial outstanding principal
		repayment.setInitialOutstandingPrincipal(initialOutstandingPrincipal);

		// Remaining outstanding principal
		BigDecimal remainingOutstandingPrincipal = repaymentCalculator
				.calculateRemainingOutstandingPrincipal(initialOutstandingPrincipal, principal);
		repayment.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
		return repayment;
	}
}
