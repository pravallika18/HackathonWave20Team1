package com.wipro.SpringRest.exeptions;

public class UsernameAndEmailIdIsRequiredException  extends Exception{
	public UsernameAndEmailIdIsRequiredException(String message)
	{
		super(message);
	}

}
