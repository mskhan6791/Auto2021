package com.abc.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.abc.elements.CreateAccountPageElements;

public class CreateAccountActions extends CreateAccountPageElements{
	public CreateAccountActions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void fillTextInFirstName() {
		
		//firstName_TextBox.sendKeys("Test");
		
		fillText(firstName_TextBox, "Test");
	}
}
