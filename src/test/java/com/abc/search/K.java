package com.abc.search;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.abc.core.Exel;
import com.abc.core.ReadProperty;

public class K {
	
	WebDriver driver = null;
	
	@Test(invocationCount = 1, threadPoolSize = 5)
	public void k() throws InterruptedException, IOException {
		ReadProperty property = new ReadProperty("config");
		
		String browserName = property.getKeyValue("browser");
		
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
		if(!property.getKeyValue("device").equalsIgnoreCase("")) {

			if(property.getKeyValue("device").equalsIgnoreCase("iPhoneX")) {
				setDimension("iPhoneX");
			}else if(property.getKeyValue("device").equalsIgnoreCase("iPhone13Pro")){
				setDimension("iPhone13Pro");
			}
			else if(property.getKeyValue("device").equalsIgnoreCase("iPhone13proMax")){
				setDimension("iPhone13pro");
			}
		}
		
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
		//driver.close();
		
		
		
	}
	
	@Test(dataProvider = "data")
	public void k1(String dataName, String userName, String password) throws InterruptedException {
		/*
		 * System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
		 * +"\\driver\\chrome\\chromedriver.exe");
		 * 
		 * ChromeDriver driver = new ChromeDriver();
		 * driver.get("https://www.google.com/"); Thread.sleep(2000);
		 */
		
		System.out.println(dataName+ "-----"+userName + " --- " + password);
		
		//driver.close();
		
	}
	
	
	@DataProvider(name = "data")
	public Object [][] d() throws InvalidFormatException, IOException {
		
		Exel exel= new Exel("Data");
		return exel.getDataFordataProvider("A");
		
	}
	
	public void setDimension(String device) throws IOException {
		ReadProperty deviceProperty = new ReadProperty("device");
		String d = deviceProperty.getKeyValue(device);
		String xy[] = d.split("X");
				
		int x = new Integer(xy[0]);
		int y = new Integer(xy[1]);
		
		System.out.println(x+"-"+y);
		
		driver.manage().window().setSize(new Dimension(x, y));
	}
	
	

}
