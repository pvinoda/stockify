package com.example.StockCharting.exception;

public class InvalidTokenException extends Throwable
{
	private String message;

	public InvalidTokenException(String message) {
		super();
		this.message = message;
	}

	public InvalidTokenException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
