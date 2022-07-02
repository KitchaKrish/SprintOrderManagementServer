package com.online.entity;

public class OutputMessage {

	private boolean status;
	private String message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OutputMessage(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public OutputMessage() {
		super();
	}

}
