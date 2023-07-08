package com.example.StockCharting.exception;

public class UserAlreadyExistsException extends Throwable
{
	private String message;

	public UserAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public UserAlreadyExistsException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
