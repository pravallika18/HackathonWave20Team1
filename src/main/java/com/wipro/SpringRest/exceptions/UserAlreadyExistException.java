package com.wipro.SpringRest.exceptions;

//Exception class for user AlreadyExist
public class UserAlreadyExistException extends Exception{
	public UserAlreadyExistException(String message)
	{
		super(message);
	}

}
