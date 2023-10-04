package com.democart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.democart.qa.utils.Constants;
import com.democart.qa.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By headerLogo = By.cssSelector("div#logo img");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input");
	private By searchButton = By.cssSelector("div#search button");
	private By searchItemResult=By.cssSelector("div.product-layout .product-thumb");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForTitle(Constants.ACCOUNTS_PAGE_TITLE, 5);
	}

	public String getHeaderLogoTitle() {
		if (elementUtil.doIsDisplayed(headerLogo)) {
			System.out.println(elementUtil.doGetAttribute(headerLogo,"title"));
			 return elementUtil.doGetAttribute(headerLogo,"title");
		}
		return null;
	}
	
	public int getAccountSectionsCount() {
		return elementUtil.getElements(accountSectionHeaders).size();	
	}
	
	public List<String> getAccountSectionsList() {
		List<WebElement> accountSectionEleList=elementUtil.getElements(accountSectionHeaders);
		List<String> accountSectionList=new ArrayList<String>();
		for(WebElement element:accountSectionEleList) {
			accountSectionList.add(element.getText());
		}
		return accountSectionList;
	}
	
	public boolean doSearch(String searchTerm) {
		elementUtil.sendKeys(searchText, searchTerm, 5);
		elementUtil.clickWhenReady(searchButton, 5);
		if(elementUtil.getElements(searchItemResult).size()>1) {
			return true;
		}
		return false;
	}	
	
}
