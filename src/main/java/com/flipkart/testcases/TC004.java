package com.flipkart.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers {

	@BeforeClass
	public void setValues() {
		
		AppURL = property.getProperty("AppURL2");
		TCName = "TC001";
		TCDescription = "LuproLink 4.0";
		TCAuthor = "Kani";
		TCCategory = "Functional Testing";
		
	}

	@Test
	public void TC001_1() throws InterruptedException{
		new HomePage(extentTest)
		.closePopup();
		
	}
	
	
}
