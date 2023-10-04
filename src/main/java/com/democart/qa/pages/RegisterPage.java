package com.democart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	private By fNameTextbox = By.cssSelector("#input-firstname");
	private By lNameTextbox = By.cssSelector("#input-lastname");
	private By emailTextbox = By.cssSelector("#input-email");
	private By telephoneTextbox = By.cssSelector("#input-telephone");
	private By passwordTextbox = By.cssSelector("#input-password");
	private By confirmPasswordTextbox = By.cssSelector("#input-confirm");
	private By subscribeYesRadiobutton = By.xpath("(//input[@name='newsletter']//parent::label)[1]");
	private By subscribeNoRadiobutton = By.xpath("(//input[@name='newsletter']//parent::label)[2]");
	private By agreeCheckbox = By.name("agree");

	private By continueButton = By.xpath("//input[@value='Continue']");

	// xpath => //div[@id='content']/h1
	//private By accountCreationSuccessMsg = By.cssSelector("#content h1");
	private By accountCreationSuccessMsg=By.xpath("//div[@id='content']/p[2]");
	
	private By myAccountHeaderLink = By.xpath("//a[@class='dropdown-toggle' and @title='My Account']");
	private By logoutHeaderLink = By
			.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//child::a[text()='Logout']");
	private By registerHeaderLink = By
			.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//child::a[text()='Register']");

	private By loginHeaderLink = By
			.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//child::a[text()='Login']");
	
	private By logOutLink=By.xpath("//a[@class='list-group-item' and text()='Logout']");
	private By loginLink=By.xpath("//a[@class='list-group-item' and text()='Login']");
	private By registerLink=By.xpath("//a[@class='list-group-item' and text()='Register']");
	
	public boolean userRegistration(String firstName, String lastName, String email, String telephone, String password,
			String newsletterSubscription) {
		//System.out.println("hello1");
		elementUtil.waitForVisibilityOfElement(fNameTextbox, 5);
		//System.out.println("hello2");
		elementUtil.sendKeys(fNameTextbox, firstName,5);
		//elementUtil.sendKeys(fNameTextbox, firstName, 5);
		elementUtil.sendKeys(lNameTextbox, lastName, 5);
		elementUtil.sendKeys(emailTextbox, email, 5);
		elementUtil.sendKeys(telephoneTextbox, telephone, 5);
		elementUtil.sendKeys(passwordTextbox, password, 5);
		elementUtil.sendKeys(confirmPasswordTextbox, password, 5);
		
		if (newsletterSubscription.equalsIgnoreCase("yes")) {
			elementUtil.clickWhenReady(subscribeYesRadiobutton, 5);
		} else {
			elementUtil.clickWhenReady(subscribeNoRadiobutton, 5);
		}
		
		elementUtil.clickWhenReady(agreeCheckbox, 5);
		elementUtil.clickWhenReady(continueButton, 5);
		
		elementUtil.waitForVisibilityOfElement(accountCreationSuccessMsg, 5);
		
		if (elementUtil.doGetText(accountCreationSuccessMsg).equals(Constants.ACCOUNT_CREATION_SUCCESS_MESSAGE)) {
			elementUtil.clickWhenReady(myAccountHeaderLink, 5);
			elementUtil.clickWhenReady(logoutHeaderLink, 5);
			elementUtil.clickWhenReady(myAccountHeaderLink, 5);
			elementUtil.clickWhenReady(loginHeaderLink, 5);
			return true;
		}
		return false;
	}
	
	public boolean userRegistration2(String firstName, String lastName, String email, String telephone, String password,
			String newsletterSubscription) {
		//System.out.println("hello1");
		elementUtil.waitForVisibilityOfElement(fNameTextbox, 5);
		//System.out.println("hello2");
		elementUtil.sendKeys(fNameTextbox, firstName,5);
		//elementUtil.sendKeys(fNameTextbox, firstName, 5);
		elementUtil.sendKeys(lNameTextbox, lastName, 5);
		elementUtil.sendKeys(emailTextbox, email, 5);
		elementUtil.sendKeys(telephoneTextbox, telephone, 5);
		elementUtil.sendKeys(passwordTextbox, password, 5);
		elementUtil.sendKeys(confirmPasswordTextbox, password, 5);
		
		if (newsletterSubscription.equalsIgnoreCase("yes")) {
			elementUtil.clickWhenReady(subscribeYesRadiobutton, 5);
		} else {
			elementUtil.clickWhenReady(subscribeNoRadiobutton, 5);
		}
		
		elementUtil.clickWhenReady(agreeCheckbox, 5);
		elementUtil.clickWhenReady(continueButton, 5);
		
		elementUtil.waitForVisibilityOfElement(accountCreationSuccessMsg, 5);
		
		if (elementUtil.doGetText(accountCreationSuccessMsg).equals(Constants.ACCOUNT_CREATION_SUCCESS_MESSAGE)) {
			elementUtil.clickWhenReady(myAccountHeaderLink, 5);
			elementUtil.clickWhenReady(logoutHeaderLink, 5);
			elementUtil.clickWhenReady(myAccountHeaderLink, 5);
			elementUtil.clickWhenReady(registerHeaderLink, 5);
			return true;
		}
		return false;
	}
	
	public boolean userRegistration3(String firstName, String lastName, String email, String telephone, String password,
			String newsletterSubscription) {
		//System.out.println("hello1");
		elementUtil.waitForVisibilityOfElement(fNameTextbox, 5);
		//System.out.println("hello2");
		elementUtil.sendKeys(fNameTextbox, firstName,5);
		//elementUtil.sendKeys(fNameTextbox, firstName, 5);
		elementUtil.sendKeys(lNameTextbox, lastName, 5);
		elementUtil.sendKeys(emailTextbox, email, 5);
		elementUtil.sendKeys(telephoneTextbox, telephone, 5);
		elementUtil.sendKeys(passwordTextbox, password, 5);
		elementUtil.sendKeys(confirmPasswordTextbox, password, 5);
		
		if (newsletterSubscription.equalsIgnoreCase("yes")) {
			elementUtil.clickWhenReady(subscribeYesRadiobutton, 5);
		} else {
			elementUtil.clickWhenReady(subscribeNoRadiobutton, 5);
		}
		
		elementUtil.clickWhenReady(agreeCheckbox, 5);
		elementUtil.clickWhenReady(continueButton, 5);
		
		elementUtil.waitForVisibilityOfElement(accountCreationSuccessMsg, 5);
		
		if (elementUtil.doGetText(accountCreationSuccessMsg).equals(Constants.ACCOUNT_CREATION_SUCCESS_MESSAGE)) {
			elementUtil.clickWhenReady(logOutLink, 5);
			elementUtil.clickWhenReady(registerLink, 5);
			return true;
		}
		return false;
	}
}
