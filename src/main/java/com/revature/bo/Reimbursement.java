package com.revature.bo;

import java.math.BigDecimal;
import java.util.Date;

public class Reimbursement {

	Long reimbId;
	BigDecimal amount;
	Date submitDate;
	Date resolvedDate;
	String description;
	User user;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(Long reimbId, BigDecimal amount, Date submitDate, Date resolvedDate, String description,
			User user) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.user = user;
	}


	/**
	 * @return the reimbId
	 */
	public Long getReimbId() {
		return reimbId;
	}


	/**
	 * @param reimbId the reimbId to set
	 */
	public void setReimbId(Long reimbId) {
		this.reimbId = reimbId;
	}


	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	/**
	 * @return the submitDate
	 */
	public Date getSubmitDate() {
		return submitDate;
	}


	/**
	 * @param submitDate the submitDate to set
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}


	/**
	 * @return the resolvedDate
	 */
	public Date getResolvedDate() {
		return resolvedDate;
	}


	/**
	 * @param resolvedDate the resolvedDate to set
	 */
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitDate=" + submitDate
				+ ", resolvedDate=" + resolvedDate + ", description=" + description + ", user=" + user + "]";
	}



	
	
	
	
}
