package com.abc.reg;

import org.testng.Assert;

public class Validation {
	
	public void verifyTitle(String actual, String expected) {
		if(actual.equals(expected)) {
		System.out.println( "The Title is Matched: ");
	}else {
	System.out.println("The Title does not match: ");
	System.out.println("The Actual value is :"+actual);
	System.out.println("The Actual value is :"+expected);	
	Assert.assertEquals(actual, expected);	
	}
	}
}
