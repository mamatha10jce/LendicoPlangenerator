package com.lendico.codingtask.plangenerator.modeldata;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Mamatha Shivanna
 *
 */
public class RepaymentPlanRequest {
	private static final Logger logger = LoggerFactory.getLogger(RepaymentPlanRequest.class);

	@NotNull
	@Positive
	private BigDecimal loanAmount;

	@NotNull
	@Positive
	private Double nominalRate;

	@NotNull
	@Min(1)
	@Positive
	private Integer duration;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date startDate;

	/**
	 * Gets the RepaymentPlanRequest's {@code loanAmount}.
	 *
	 * @return The RepaymentPlanRequest's {@code loanAmount}
	 */
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/**
	 * Gets the RepaymentPlanRequest's {@code nominalRate}.
	 *
	 * @return The RepaymentPlanRequest's {@code nominalRate}
	 */
	public Double getNominalRate() {
		return nominalRate;
	}

	/**
	 * Gets the RepaymentPlanRequest's {@code duration}.
	 *
	 * @return The RepaymentPlanRequest's {@code duration}
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Gets the RepaymentPlanRequest's {@code startDate}.
	 *
	 * @return The RepaymentPlanRequest's {@code startDate}
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the RepaymentPlanRequest's {@code loanAmount}.
	 *
	 * @param loanAmount
	 *            The RepaymentPlanRequest's {@code loanAmount} to set
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * Sets the RepaymentPlanRequest's {@code nominalRate}.
	 *
	 * @param nominalRate
	 *            The RepaymentPlanRequest's {@code nominalRate} to set
	 */
	public void setNominalRate(Double nominalRate) {
		this.nominalRate = nominalRate;
	}

	/**
	 * Sets the RepaymentPlanRequest's {@code duration}.
	 *
	 * @param duration
	 *            The RepaymentPlanRequest's {@code duration} to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Sets the RepaymentPlanRequest's {@code startDate}.
	 *
	 * @param startDate
	 *            The RepaymentPlanRequest's {@code startDate} to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "RepaymentPlanRequest [loanAmount=" + loanAmount + ", nominalRate=" + nominalRate + ", duration="
				+ duration + ", startDate=" + startDate + "]";
	}
}
