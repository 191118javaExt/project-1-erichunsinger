package com.revature.model;

import java.sql.Timestamp;

public class Reimbursement {

	Long reimbId;
	double amount;
	Timestamp submitDate;
	Timestamp resolvedDate;
	String description;
	String receipt;
	Long authorId;
	Long resolverId;
	Long typeId;
	Long statusId;
	String typeStr;
	String statusStr;

	public Reimbursement(Long reimbId, double amount, Timestamp submitDate, Timestamp resolvedDate, String description,
			String receipt, Long authorId, Long resolverId, Long typeId, Long statusId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.typeId = typeId;
		this.statusId = statusId;
	}

	public Reimbursement() {
	}

	public Long getReimbId() {
		return reimbId;
	}

	public void setReimbId(Long reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public Timestamp getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Timestamp resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getResolverId() {
		return resolverId;
	}

	public void setResolverId(Long resolverId) {
		this.resolverId = resolverId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

}
