package com.democart.qa.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.democart.qa.base.BaseTest;
import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ExcelUtil;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String accountsPageTitle = accountsPage.getAccountPageTitle();
		System.out.println("Accounts Page Title is:" + accountsPageTitle);
		Assert.assertEquals(accountsPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void accountsPageHeaderTitleTest() {
		String logoTitle = accountsPage.getHeaderLogoTitle();
		System.out.println("Account Header Logo Title:" + logoTitle);
		Assert.assertEquals(logoTitle, Constants.HEADER_LOGO_TITLE);
	}

	@Test(priority = 3)
	public void accountPageSectionCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == Constants.ACCOUNT_PAGE_SECTION_COUNT);
	}

	@Test(priority = 4)
	public void accountPageSectionTextTest() {
		List<String> accountSectionList = accountsPage.getAccountSectionsList();
		Assert.assertEquals(accountSectionList, Constants.expectedAccountSectionList());
	}

	@Test(priority = 5, dataProvider = "getSearchData")
	public void searchTest(String searchTerm) {
		Assert.assertTrue(accountsPage.doSearch(searchTerm));
	}

	/*@DataProvider
	public Object[][] getSearchData() {
		Object[][] data = { { "Mac" }, { "Macbook" }, { "iPhone" } };
		return data;
	}*/
	
	
	@DataProvider
	public Object[][] getSearchData() {
		return ExcelUtil.getExcelData(Constants.ACCOUNT_PAGE_SHEET_NAME);
	}
}
