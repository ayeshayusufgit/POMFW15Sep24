package com.democart.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.democart.qa.factory.DriverFactory_1b;
import com.democart.qa.pages.AccountsPage;
import com.democart.qa.pages.LoginPage;
import com.democart.qa.pages.RegisterPage;

public class BaseTest {

	public WebDriver driver;
	DriverFactory_1b df;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public RegisterPage registerPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory_1b();
		prop = df.init_prop();
		driver = df.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("appUrl"));
		loginPage = new LoginPage(driver);
		accountsPage=new AccountsPage(driver);
		registerPage=new RegisterPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
