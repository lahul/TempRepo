package com.flipkart.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.util.Reporter;
import com.relevantcodes.extentreports.LogStatus;

public class GenericWrappers extends Reporter implements Wrappers{

	public static RemoteWebDriver driver;
	
	public static Properties property;
	
	public RemoteWebDriver initApp(String path) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.get(path);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void enterByxpath(String xpath, String value) {
		try{
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			reportStep("The webelement with an ID: '" + xpath + "' is identified and entered with the data '"+ value + "' successfully.","Pass");
			}catch(NoSuchElementException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(ElementNotVisibleException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(ElementNotInteractableException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(WebDriverException e){
				reportStep("Application crashed for unknown error","Fail");
			}
		
	}
	
	public void enterById(String id, String value) {
		try{
			driver.findElement(By.id(id)).sendKeys(value);
			reportStep("The webelement with an ID: '" + id + "' is identified and entered with the data '"+ value + "' successfully.","Pass");
			}catch(NoSuchElementException e){
				reportStep("Element with id "+ id + "not found","Fail");
			}catch(ElementNotVisibleException e){
				reportStep("Element with id "+ id + "not found","Fail");
			}catch(ElementNotInteractableException e){
				reportStep("Element with id "+ id + "not found","Fail");
			}catch(WebDriverException e){
				reportStep("Application crashed for unknown error","Fail");
			}
	}

	public void clickByxpath(String xpath) {
		try{
			driver.findElement(By.xpath(xpath)).click();
			reportStep("The webelement with an ID: '" + xpath + "' is identified and clicked.","Pass");
			}catch(NoSuchElementException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(ElementNotVisibleException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(ElementNotInteractableException e){
				reportStep("Element with id "+ xpath + "not found","Fail");
			}catch(WebDriverException e){
				reportStep("Application crashed for unknown error","Fail");
			}
		
	}
	
	public void clickById(String Id) {
		try{
			driver.findElement(By.xpath(Id)).click();
			reportStep("The webelement with an ID: '" + Id + "' is identified and clicked.","Pass");
			}catch(NoSuchElementException e){
				reportStep("Element with id "+ Id + "not found","Fail");
			}catch(ElementNotVisibleException e){
				reportStep("Element with id "+ Id + "not found","Fail");
			}catch(ElementNotInteractableException e){
				reportStep("Element with id "+ Id + "not found","Fail");
			}catch(WebDriverException e){
				reportStep("Application crashed for unknown error","Fail");
			}
		
	}
	
	public String getTextByXpath(String Xpath) {
		String text = null;
		try{
			text = driver.findElement(By.xpath(Xpath)).getText();
			reportStep("The webelement with an ID: '" + Xpath + "' is identified and clicked.","Pass");
			}catch(NoSuchElementException e){
				reportStep("Element with id "+ Xpath + "not found","Fail");
			}catch(ElementNotVisibleException e){
				reportStep("Element with id "+ Xpath + "not found","Fail");
			}catch(ElementNotInteractableException e){
				reportStep("Element with id "+ Xpath + "not found","Fail");
			}catch(WebDriverException e){
				reportStep("Application crashed for unknown error","Fail");
			}
		return text;
	}
	
	public void loadProperties() {
		try {
			property = new Properties();
			File file = new File("./src/main/java/config.properties");
			FileInputStream fins = new FileInputStream(file);
			property.load(fins);
			System.out.print(property);
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}catch(Exception e) {
			System.out.println("Error found");
		}
	}
	
	public void unloadProperties() {
		property = null;
		
	}
	
	public void closeAllBrowsers() {
		driver.quit();
	}
	
	public long takesnap() {
		long snapshot = 0;
        try {
               snapshot = (long) Math.floor(Math.random()*1000000000+1000000);
               File tmpFile = driver.getScreenshotAs(OutputType.FILE);
               File destFile = new File("./Reports/images/"+snapshot+".png");
               FileUtils.copyFile(tmpFile, destFile);
               //System.out.println("The screen snap is captured successfully in the path '" + destFile+"'.");
        } catch (ScreenshotException e) {
               //System.err.println("The screen snap is not captured due to Screenshot Exception.");
               reportStep("The screen snap is not captured due to Screenshot Exception.", "FAIL");
        } catch (IOException e) {
               //System.err.println("The screen snap is not captured due to Input & Output Exception.");
               reportStep("The screen snap is not captured due to Input & Output Exception.", "FAIL");
        } catch (WebDriverException e) {
               //System.err.println("The application got crashed for unknown error.");
               reportStep("The application got crashed for unknown error.", "FAIL");
        } catch (Exception e) {
               //System.err.println("Unable to take snap shot for unknown error.");
               reportStep("The application got crashed for unknown error.", "FAIL");
        }
        return snapshot;
	}

	public void changeToNewTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public boolean elementIsVisibleByXpath(String Xpath) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Xpath))));
		return driver.findElement(By.xpath(Xpath)).isDisplayed();
		}catch(Exception e){
			return false;
		}
	}

	
	public void waitForPageToLoad(String Xpath1, String Xpath2) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		int count = 0;
		while(count<4){
		
		if(driver.findElements(By.xpath(Xpath1)).size() != 0||driver.findElements(By.xpath(Xpath2)).size() != 0)
			return;
		else{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				return;
			}
			count++;
	}
	}
	}

	public void checkVisibilityByXpath(String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		int count = 0;
		while(count<4){
		
		if(driver.findElements(By.xpath(Xpath)).size() != 0)
			return;
		else{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				return;
			}
			count++;
	}		
	}
}

	
	
	public boolean checkText(String str1, String str2) {
		if(str1.contains(str2)) {
			return true;
		}
		return false;
	}
	
	public void waitForPageLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}

	public void clearFieldByXpath(String str) {
		//driver.findElement(By.xpath(property.getProperty("HomePage.searchbarXpath"))).clear();
		for (int i = 0; i < 10; i++) {
		    driver.findElement(By.xpath(str)).sendKeys(Keys.BACK_SPACE);
		}
	}
}
