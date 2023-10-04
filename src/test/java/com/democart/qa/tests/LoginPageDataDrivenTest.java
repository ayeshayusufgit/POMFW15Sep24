package com.democart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.democart.qa.base.BaseTest;
import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ExcelUtil;

public class LoginPageDataDrivenTest extends BaseTest{
	
	@Test(priority=1,dataProvider = "getLoginData")
	public void loginDataDrivenTest(String username,String password,String expectedWarning) {
		
		System.out.println("username="+username+" password="+password);
		loginPage.doLogin(username, password);
		String actualWarningMessage=loginPage.getWarningMessage();
		Assert.assertEquals(actualWarningMessage, expectedWarning);
	}
	
	
	@DataProvider
	public Object[][] getLoginData(){
		return ExcelUtil.getExcelData(Constants.LOGIN_PAGE_SHEET_NAME);
	}

}
