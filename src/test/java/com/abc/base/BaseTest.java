package com.abc.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.abc.core.PDriver;

public class BaseTest extends PDriver{
	public WebDriver driver = null;
	
	@BeforeMethod(groups ={"SmokeTest"})
	public void bm() throws IOException, InterruptedException {
		driver = createDriver();
	}

}
