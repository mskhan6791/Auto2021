package com.abc.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abc.core.PDriver;

public class CreateAccountPageElements extends PDriver{

	public WebDriver driver = null;
	
	public CreateAccountPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstName")
	public WebElement firstName_TextBox;
}
