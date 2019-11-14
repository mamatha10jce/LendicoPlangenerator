package com.lendico.codingtask.plangenerator.modeldata;

import java.util.List;

/**
 * @author Mamatha Shivanna
 *
 */
public class RepaymentPlan {
	private List<Repayment> repayments;

	/**
	 * Gets the RepaymentPlan's {@code repayments}.
	 *
	 * @return the {@code RepaymentPlan}'s {@code repayments}
	 */
	public List<Repayment> getRepayments() {
		return repayments;
	}

	/**
	 * Sets the RepaymentPlan's {@code repayments}.
	 *
	 * @param repayments
	 *            the {@code RepaymentPlan}'s {@code repayments} to set
	 */
	public void setRepayments(List<Repayment> repayments) {
		this.repayments = repayments;
	}

	@Override
	public String toString() {
		return "RepaymentPlan [repayments=" + repayments + "]";
	}
}