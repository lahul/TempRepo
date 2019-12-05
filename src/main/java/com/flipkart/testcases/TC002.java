package com.flipkart.testcases;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.flipkart.pages.LoginPage;
import com.flipkart.wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers{
	@BeforeClass
	public void setValues() {
		
		AppURL = property.getProperty("AppURL");
		TCName = "TC001";
		TCDescription = "LuproLink 4.0";
		TCAuthor = "Kani";
		TCCategory = "Functional Testing";
		
	}

	@Test
	public void TC002_1() throws InterruptedException, IOException{
		new LoginPage(extentTest)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.validateItems();
	}
}
