package com.capp.exception;

public class UserBlockException extends Exception{

	public UserBlockException() {
	}
	public UserBlockException(String userDes) {
		super(userDes);
	}
}
