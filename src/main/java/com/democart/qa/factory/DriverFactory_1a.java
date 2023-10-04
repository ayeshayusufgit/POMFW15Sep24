package com.democart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory_1a {

	public static WebDriver driver;

	public static Properties init_prop() {

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

	//with WDM using Selenium 3.141.49
	public static WebDriver init_driver(String browser) {
		
		System.out.println("Browser Name:" + browser);
		
		switch (browser) {
		
		case "chrome": 	
						//WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
					  	break;
			
		case "firefox": //WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						break;
						
		case "safari":  driver = new SafariDriver();
						break;
						
		default: System.out.println("Please pass the right browser name!");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void main(String args[]) {
		Properties prop=init_prop();
		System.out.println(prop.get("browser"));
		
		init_driver("chrome");
	}
}
