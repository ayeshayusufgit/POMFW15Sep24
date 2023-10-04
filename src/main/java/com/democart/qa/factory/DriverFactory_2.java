package com.democart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory_2 {
	static WebDriver driver;
		public static void main(String args[]) {
		//chrome 116.x with Selenium 3.14.x
		//1.Set the System Property:download the chromedriver.exe from the CFT dashboard or CFT Endpoint URL
		//System.setProperty("webdriver.chrome.driver","path of the chromedriver.exe");	
		
		//2.Using Bonigracia --- WebDriverManager(WDM) with Selenium 3.14.x
		//Add the bonigracia maven dependency
		//It will automatically download the chromedriver.exe
		//WebDriverManager.chromedriver().setup();
		
		//3.Selenium 4.11.0: do we need WDM?
		//Since SelniumManager is already there, will the WDM be required?
		//Not required to use the WDM with Selenium 4.12
		//It will automatically download the chromedriver.exe from the CFT dashboard			
		//CFT url -> https://googlechromelabs.github.io/chrome-for-testing/
			
		driver=new ChromeDriver(); 
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle()); 
	}
}

