package com.lendico.codingtask.plangenerator.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.codingtask.plangenerator.modeldata.Repayment;
import com.lendico.codingtask.plangenerator.modeldata.RepaymentPlan;
import com.lendico.codingtask.plangenerator.modeldata.RepaymentPlanRequest;
import com.lendico.codingtask.plangenerator.service.RepaymentService;

/**
 * @author Mamatha Shivanna
 *
 */
@RestController
public class RepaymentPlanController {
	private static final Logger logger = LoggerFactory.getLogger(RepaymentPlanController.class);
	public static final String REQUEST_PATH = "/generate-plan";

	@Autowired
	private RepaymentService service;

	@PostMapping(path = REQUEST_PATH, headers = "Accept=application/json")
	public @ResponseBody List<Repayment> generatePlan(@Validated @RequestBody RepaymentPlanRequest request) {

		/* Get request parameters. */
		BigDecimal loanAmount = request.getLoanAmount();
		Double nominalRate = request.getNominalRate();
		Integer duration = request.getDuration();

		Date startDate = request.getStartDate();
		Instant instant = startDate.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localStartDate = LocalDateTime.ofInstant(instant, zone);

		/* execution of the service. */
		RepaymentPlan plan = service.generatePlan(loanAmount, nominalRate, duration, localStartDate);
		List<Repayment> repayments = plan.getRepayments();

		return repayments;
	}
}
