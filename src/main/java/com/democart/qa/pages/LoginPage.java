package com.democart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By continueButton=By.xpath("//a[text()='Continue']");
	private By warningMsg=By.cssSelector("div.alert.alert-danger.alert-dismissible");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(Constants.LOGIN_PAGE_TITLE, 5);
	}

	public boolean isForgotPasswordLinkPresent_a() {
		return elementUtil.checkElement(forgotPasswordLink);
	}

	public boolean isForgotPasswordLinkPresent_b() {
		if(elementUtil.getElements(forgotPasswordLink).size() == Constants.FORGOT_PASSWORD_LINK_COUNT)
			return true;
		return false;
	}
	
	public AccountsPage doLogin(String uname,String pwd) {
		System.out.println("Login with username:"+uname+" and password:"+pwd);
		elementUtil.doSendkey(email, uname);
		elementUtil.doSendkey(password, pwd);
		elementUtil.clickWhenReady(loginButton, 5);
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		elementUtil.clickWhenReady(continueButton, 5);
		return new RegisterPage(driver);
	}
	
	
	public String getWarningMessage() {
		return elementUtil.waitForVisibilityOfElement(warningMsg, 5).getText();
	}
	
}
