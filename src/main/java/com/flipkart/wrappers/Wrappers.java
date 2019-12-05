package com.flipkart.wrappers;

public interface Wrappers {
	
	public void enterByxpath(String xpath, String value);
	public void clickByxpath(String xpath);
	public void enterById(String id, String value);
	public String getTextByXpath(String Xpath);
	public void checkVisibilityByXpath(String Xpath);
	public void changeToNewTab();
	public boolean elementIsVisibleByXpath(String Xpath);
	public void waitForPageToLoad(String Xpath1, String Xpath2);	
	public boolean checkText(String str1, String str2);
	public void clearFieldByXpath(String str);
	public void waitForPageLoad();
}
