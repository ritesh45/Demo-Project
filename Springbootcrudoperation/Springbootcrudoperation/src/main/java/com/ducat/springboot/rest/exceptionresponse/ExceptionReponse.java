package com.ducat.springboot.rest.exceptionresponse;

import java.util.Date;

public class ExceptionReponse {
	private Date timestamp;
	private String error_message;
	private String details;

	public ExceptionReponse(Date timestamp, String error_message, String details) {
		super();
		this.timestamp = timestamp;
		this.error_message = error_message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getError_message() {
		return error_message;
	}

	public String getDetails() {
		return details;
	}

}
