package com.abc.search;

import org.testng.annotations.Test;

import com.abc.base.BaseTest;
import com.abc.pageActions.CreateAccountActions;
import com.abc.pageActions.HomeActions;
import com.abc.pageActions.SignInActions;

public class Goog extends BaseTest{
	
	HomeActions homePage = null;
	
	
	
	@Test(groups = {"SmokeTest", "Regression","Search"})
	public void t() throws InterruptedException {
		homePage = new HomeActions(driver);

		SignInActions signInPage = homePage.clickOnSignIn();
		CreateAccountActions createAccount = signInPage.selectMySelfOptionToCreateAccount();
		createAccount.fillTextInFirstName();
	}
}
