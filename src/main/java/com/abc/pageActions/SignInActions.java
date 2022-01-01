package com.abc.pageActions;

import org.openqa.selenium.WebDriver;

import com.abc.elements.SignInPageElements;

public class SignInActions extends SignInPageElements{
	public SignInActions(WebDriver driver) {
		super(driver);
	}

	public CreateAccountActions selectMySelfOptionToCreateAccount() throws InterruptedException {
		click(createAccount_button);
		click(mySelf_button);
		Thread.sleep(3000);
		return new CreateAccountActions(driver);
	}
}