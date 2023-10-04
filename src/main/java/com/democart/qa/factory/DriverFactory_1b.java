package com.democart.qa.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory_1b {

	public WebDriver driver;
	public ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	public synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {

		Properties prop = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
		
	//with SeleniumManager using Selenium 4.11.0
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser Name:" + browser);
		
		switch (browser) {
						//From Selenium library of v4.6.0 onwards has implemented the
						//feature SeleniumManager which is exactly like the WDM
		
		case "chrome": 	//SeleniumManager is the new replacement of WDM
						//SeleniumManager is part of selenium now
						//a check is made that the ChromeDriver is there for chrome 117
						//if not then the compatible ChromeDriver is download and associated
						//"C:\Users\ayesh\.cache\selenium\chromedriver\win64\117.0.5938.88"
						//the ChromeDriver is downloaded above and its value will be updated using
						//using System.property("webdriver.chrome.driver")
						//or
						//using System.property("webdriver.gecko.driver")
			
						//local--chrome(116) is not available
						//download 116(CFT+chromedriver.exe)
			
						//To launch on the chrome version not present locally
						//ChromeOptions co=new ChromeOptions();
						//co.setBrowserVersion("118");
						//driver = new ChromeDriver(co);
						
						//To launch on the default version of chrome present locally
						//driver = new ChromeDriver();
						tlDriver.set(new ChromeDriver());
					  	break;
					  	
					  	//WebDriverManager is used for the management of the WebDriver
					  	
		case "firefox": //WebDriverManager.firefoxdriver().setup();
						//driver = new FirefoxDriver();
						tlDriver.set(new FirefoxDriver());
						break;
						
		case "safari": 
						//driver = new SafariDriver();
						tlDriver.set(new SafariDriver());
						break;
						
		default: System.out.println("Please pass the right browser name!");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public String getScreenshot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public void main(String args[]) {
		Properties prop=init_prop();
		System.out.println(prop.get("browser"));
		init_driver("firefox");
	}
}

