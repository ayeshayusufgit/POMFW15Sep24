package com.democart.qa.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final int FORGOT_PASSWORD_LINK_COUNT = 2;
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String HEADER_LOGO_TITLE = "naveenopencart";
	public static final int ACCOUNT_PAGE_SECTION_COUNT = 4;

	public static final List<String> expectedAccountSectionList() {
		List<String> accountSectionList = new ArrayList<String>();
		accountSectionList = new ArrayList<String>();
		accountSectionList.add("My Account");
		accountSectionList.add("My Orders");
		accountSectionList.add("My Affiliate Account");
		accountSectionList.add("Newsletter");
		return accountSectionList;
	}
	
	//public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE="Your Account Has Been Created!";
	public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	public static final String REGISTER_PAGE_SHEET_NAME="registrationData";
	public static final String ACCOUNT_PAGE_SHEET_NAME="searchTerms";
	public static final String LOGIN_PAGE_SHEET_NAME="loginData";
	
}
