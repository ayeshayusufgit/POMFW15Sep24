package com.democart.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.democart.qa.base.BaseTest;
import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ExcelUtil;

public class RegisterPageTest3 extends BaseTest {
	
	@BeforeClass
	public void registerPageSetup() {
		registerPage=loginPage.navigateToRegisterPage();
		
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void userRegisterationTest3(String firstName,String lastName,String email,String telephone,String password,String subscription) {
		//registerPage.userRegistration1("Ayesha", "Yusuf", "ayesha.yusuf16@gmail.com", "1234567890", "test123", "yes");
		registerPage.userRegistration3(firstName, lastName, email, telephone, password, subscription);
	}
	
	@DataProvider
	public Object[][] getRegistrationData(){
		return ExcelUtil.getExcelData(Constants.REGISTER_PAGE_SHEET_NAME);
	}
}
