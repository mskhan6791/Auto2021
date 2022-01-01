package com.abc.search;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class G {
	
	ChromeDriver driver = null;
	
	
	@BeforeClass
	public void b() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\driver\\chrome\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void k() throws InterruptedException {
		
		driver.findElement(By.name("q")).sendKeys("US");	
	}
	
	@Test(dependsOnMethods = "k")
	public void k2() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@aria-label=\"Google apps\"]")).click();
	}
	
	@Test(dependsOnMethods = "k2")
	public void k10() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
	
	}
	
	@AfterClass
	public void a() {
		driver.quit();
	}
	

}
