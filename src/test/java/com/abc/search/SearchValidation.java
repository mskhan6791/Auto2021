package com.abc.search;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchValidation extends B{
	
	@Test(enabled = true)
	public static void main() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\driver\\chrome\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.linkText(""));
		driver.findElement(By.partialLinkText(""));
		
		driver.findElement(By.xpath(""));
		driver.findElement(By.id(""));
		
		driver.findElement(By.name(""));
		driver.findElement(By.cssSelector(""));
		
		driver.findElement(By.tagName(""));
		driver.findElement(By.className(""));
		
		
	}
	
	@Test
	public void x() {
		System.out.println("@Test");
	}
	
	
}
