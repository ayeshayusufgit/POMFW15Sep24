package com.democart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.democart.qa.base.BaseTest;
import com.democart.qa.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login Page Title:"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkPresent_a());
		Assert.assertTrue(loginPage.isForgotPasswordLinkPresent_b());
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
