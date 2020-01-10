package com.revature.data;

public class UserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7752346782696396032L;
	
	int errCode = 0;
	String description;
	/**
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}
	/**
	 * @param errCode the errCode to set
	 */
	public void setErrCode(int errCode) {
		this.errCode = errCode;
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
	
	

}
