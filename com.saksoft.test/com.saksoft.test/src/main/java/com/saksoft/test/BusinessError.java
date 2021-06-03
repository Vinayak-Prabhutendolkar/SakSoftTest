package com.saksoft.test;

public class BusinessError extends Exception {

	private String status;
	private String errMsg;

	public BusinessError(String status, String errMsg) {

		this.status = status;
		this.errMsg = errMsg;
	}

	public BusinessError(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
