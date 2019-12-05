package com.flipkart.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.pages.LoginPage;
import com.flipkart.wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers {

	@BeforeClass
	public void setValues() {
		
		AppURL = property.getProperty("AppURL");
		TCName = "TC001";
		TCDescription = "LuproLink 4.0";
		TCAuthor = "Kani";
		TCCategory = "Functional Testing";
		
	}

	@Test(dataProvider="TestData")
	public void TC001_1(String text) throws InterruptedException{
		new LoginPage(extentTest)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.searchItem(text)
		.clickOnItem()
		.clickOnBuy()
		.closeAllBrowsers();
	}
	
	
}
