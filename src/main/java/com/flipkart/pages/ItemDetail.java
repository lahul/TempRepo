package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ItemDetail extends GenericWrappers{

	public ItemDetail(ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}

	public Payment clickOnBuy() {
		clickByxpath(property.getProperty("ItemDetail.BuyButton"));
		clickByxpath(property.getProperty("ItemDetail.BuyButton"));
		return new Payment(extentTest);
	}
	
	public ItemDetail enterPinCode() {
		waitForPageLoad();
		clearFieldByXpath(property.getProperty("ItemDetail.PinCode"));
		
		enterByxpath(property.getProperty("ItemDetail.PinCode"), property.getProperty("ItemDetail.PinCodeValue"));
		return new ItemDetail(extentTest);
	}

	public ItemDetail verifyText() throws InterruptedException {
		//checkVisibilityByXpath(property.getProperty("ItemDetail.CheckText"));
		
		
		clickByxpath(property.getProperty("ItemDetail.CheckButtonXpath"));
		waitForPageLoad();
		//Thread.sleep(10000);
		System.out.println(driver.findElement(By.xpath(property.getProperty("ItemDetail.CheckTextOutOfStockXpath"))).getText());
		System.out.println(property.getProperty("ItemDetail.CheckTextOutOfStock"));
		if(elementIsVisibleByXpath(property.getProperty("ItemDetail.CheckText")) && getTextByXpath(property.getProperty("ItemDetail.CheckText")).contains(property.getProperty("ItemDetail.CheckTextAvailable")))
			reportStep("Deliver for Pincode "+property.getProperty("ItemDetail.PinCodeValue")+" is available", "pass");
		else if(elementIsVisibleByXpath(property.getProperty("ItemDetail.CheckTextInvalidXpath")) && getTextByXpath(property.getProperty("ItemDetail.CheckTextInvalidXpath")).contains(property.getProperty("ItemDetail.CheckTextInvalid")))
			reportStep("Pincode"+property.getProperty("ItemDetail.PinCodeValue")+" is invalid", "pass");
		else if(elementIsVisibleByXpath(property.getProperty("ItemDetail.CheckTextOutOfStockXpath")) && getTextByXpath(property.getProperty("ItemDetail.CheckTextOutOfStockXpath")).contains(property.getProperty("ItemDetail.CheckTextOutOfStock")))
			reportStep("Out of stock for pincode "+property.getProperty("ItemDetail.PinCodeValue"), "pass");
		else if(elementIsVisibleByXpath(property.getProperty("ItemDetail.CheckText")) && getTextByXpath(property.getProperty("ItemDetail.CheckText")).contains(property.getProperty("ItemDetail.CheckTextNotFound")))
			reportStep("Devlivery to this Pincode "+property.getProperty("ItemDetail.PinCodeValue")+" is not available", "pass");
		else
			reportStep("Failed to process the pincode "+property.getProperty("ItemDetail.PinCodeValue"), "fail");
		return new ItemDetail(extentTest);
	}
	

}
