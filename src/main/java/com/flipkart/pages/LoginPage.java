package com.flipkart.pages;

import com.flipkart.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends GenericWrappers{

	public LoginPage(ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}
	
	public LoginPage enterUsername() {
		enterByxpath(property.getProperty("LoginPage.UsernameXpath"), property.getProperty("LoginPage.UsernameValue"));
		return new LoginPage(extentTest);
	}
	
	public LoginPage enterPassword() {
		enterByxpath(property.getProperty("LoginPage.PasswordXpath"), property.getProperty("LoginPage.PasswordValue"));
		return new LoginPage(extentTest);
	}
	
	public HomePage clickLogin() throws InterruptedException {
		clickByxpath(property.getProperty("LoginPage.LoginButton"));
		return new HomePage(extentTest);
	}
}
