package com.abc.pageActions;

import org.openqa.selenium.WebDriver;

import com.abc.elements.HomePageElements;

public class HomeActions extends HomePageElements{
	
	public HomeActions(WebDriver driver) {
		super(driver);
	}
	
	public SignInActions clickOnSignIn() throws InterruptedException {
		click(signIn_link);
		Thread.sleep(3000);
		return new SignInActions(driver);
	}
}
