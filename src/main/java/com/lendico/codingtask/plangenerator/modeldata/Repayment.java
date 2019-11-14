package com.lendico.codingtask.plangenerator.modeldata;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Mamatha Shivanna
 *
 */
public class Repayment {
	private static final Logger logger = LoggerFactory.getLogger(Repayment.class);
	
	private BigDecimal borrowerPaymentAmount;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private LocalDateTime date;
	private BigDecimal initialOutstandingPrincipal;
	private BigDecimal interest;
	private BigDecimal principal;
	private BigDecimal remainingOutstandingPrincipal;
	
	

	/**
	 * @return the {@code Repayment}'s {@code borrowerPaymentAmount}
	 */
	public BigDecimal getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	/**
	 * @return the {@code Repayment}'s {@code date}
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @return the {@code Repayment}'s {@code initialOutstandingPrincipal}
	 */
	public BigDecimal getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	/**
	 * @return the {@code Repayment}'s {@code interest}
	 */
	public BigDecimal getInterest() {
		return interest;
	}

	/**
	 * Gets the Repayment's {@code principal}.
	 *
	 * @return the {@code Repayment}'s {@code principal}
	 */
	public BigDecimal getPrincipal() {
		return principal;
	}

	/**
	 * @return the {@code Repayment}'s {@code remainingOutstandingPrincipal}
	 */
	public BigDecimal getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	/**
	 * Sets the Repayment's {@code borrowerPaymentAmount}.
	 */
	public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	/**
	 * Sets the Repayment's {@code date}.
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * Sets the Repayment's {@code initialOutstandingPrincipal}.
	 */
	public void setInitialOutstandingPrincipal(
			BigDecimal initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	/**
	 * Sets the Repayment's {@code interest}.
	 *
	 * @param interest
	 *            the {@code Repayment}'s {@code interest} to set
	 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	/**
	 * Sets the Repayment's {@code principal}
	 */
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	/**
	 * Sets the Repayment's {@code remainingOutstandingPrincipal}.
	 */
	public void setRemainingOutstandingPrincipal(
			BigDecimal remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	@Override
	public String toString() {
		return "Repayment [borrowerPaymentAmount=" + borrowerPaymentAmount + ", date=" + date
				+ ", initialOutstandingPrincipal=" + initialOutstandingPrincipal + ", interest=" + interest
				+ ", principal=" + principal + ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal + "]";
	}
}