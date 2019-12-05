package com.flipkart.wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.flipkart.util.Utilities;

public class ProjectWrappers extends GenericWrappers{
	
	//public String BrowserName;
	public String AppURL;
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		startReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		loadProperties();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		startTestCase(TCName, TCDescription);
		initApp(AppURL);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
	}

	@AfterClass
	public void afterClass() {
		endTestCase();
	}

	@AfterTest
	public void afterTest() throws IOException {
		unloadProperties();

	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	
	
	@DataProvider(name= "TestData")
	public static String[][] TestData() throws IOException{
		String fileName = "TestData";
		String sheetName = "Queries";
		System.out.println("The getData function");
		return Utilities.getData(fileName, sheetName);
	}
}
