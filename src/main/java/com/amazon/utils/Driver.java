package com.amazon.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;





public class Driver {
	
	private static WebDriver driver;
	
//	public static WebDriver getInstance() {
//		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
//			System.setProperty("webdriver.chrome.driver", "/Users/aigulasanova/Documents/selenium dependencies/drivers/chromedriver");
//			driver = new ChromeDriver();	
//		}
//		return driver;
//		
//	}
	
	
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}

	}
	
	public static WebDriver getInstance() {
		
		try {
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("disable-blink-features=AutomationControlled");
			
			System.setProperty("webdriver.chrome.driver", "/Users/aigulasanova/Documents/selenium dependencies/drivers/chromedriver");
			//ChromeDriver driver = new ChromeDriver(options);
	        
			driver = new ChromeDriver(options);	
			driver.manage().window().maximize();
		} 
		} catch(Exception e) {
			System.out.println("Issue");
		
	}
		return driver;
}
	
	
	

}

