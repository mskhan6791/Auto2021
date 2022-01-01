package com.abc.core;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PDriver {
	WebDriver driver = null;
	
	public WebDriver createDriver() throws IOException, InterruptedException {
		
		ReadProperty configProperty = new ReadProperty("config");
		ReadProperty envProperty = new ReadProperty("envURL");
		
		String browserName = null;
		String browser = System.getProperty("browser");
		
		if(browser != null) {
			browserName = browser;
		}else {
			browserName = configProperty.getKeyValue("browser");
		}
		
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\driver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"\\driver\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			
		}
		Thread.sleep(5000);
		setDimension();
		
		String testEnv = configProperty.getKeyValue("env");
		String testUrl = envProperty.getKeyValue(testEnv);
		
		driver.get(testUrl);
	
		return driver;
	}
	
	public void setDimension() throws IOException {
		ReadProperty configProperty = new ReadProperty("config");
		String deviceValue = configProperty.getKeyValue("device"); // Key name from config.properties file

		if(!deviceValue.equalsIgnoreCase("")) {
			ReadProperty deviceProperty = new ReadProperty("deviceDimension"); // properties file name
			String d = deviceProperty.getKeyValue(deviceValue);
			System.out.println();
			String xy[] = d.split("X");
					
			int x = Integer.valueOf(xy[0]) /*new Integer(xy[0])*/;
			int y = new Integer(xy[1]);
			
			System.out.println(x+"-"+y);
			
			driver.manage().window().setSize(new Dimension(x, y));
		}
	}
	
	public void fillText(WebElement element, String text) {
		System.out.println("test data -"+text);
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		System.out.println("Click");
		element.click();
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void switchToframeByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

}
