package com.shopping.exception;

public class CustomerDataInvalidException extends RuntimeException
{
	private String message;

	public CustomerDataInvalidException() {	}

	public CustomerDataInvalidException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerDataInvalidException [Exception Message=" + message + "]";
	}
	
	
}
