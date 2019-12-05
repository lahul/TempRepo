package com.flipkart.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.pages.LoginPage;
import com.flipkart.wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers{

	@BeforeClass
	public void setValues() {
		
		AppURL = property.getProperty("AppURL");
		TCName = "TC001";
		TCDescription = "LuproLink 4.0";
		TCAuthor = "Kani";
		TCCategory = "Functional Testing";
		
	}

	@Test(dataProvider="TestData")
	public void TC003_1(String text) throws InterruptedException, IOException{
		new LoginPage(extentTest)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.searchItem(text)
		.clickOnItem()
		.enterPinCode()
		.verifyText()
		.closeAllBrowsers();
	}
	
}
