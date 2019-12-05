package com.flipkart.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {

	public String TCName, TCDescription, TCAuthor, TCCategory;

	public ExtentReports extentReports;

	public ExtentTest extentTest;

	public void startReport() {
		extentReports = new ExtentReports("Reports/Report.html");
	}

	public void startTestCase(String TCDescription, String TCName) {
		extentTest = extentReports.startTest(TCName, TCDescription);
		extentTest.assignAuthor(TCAuthor);
		extentTest.assignCategory(TCCategory);
	}

	public void reportStep(String strStepName, String strStatus) {
		long snapshot = takesnap();
		if (strStatus.equalsIgnoreCase("pass")) {
			extentTest.log(LogStatus.PASS,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		} else if (strStatus.equalsIgnoreCase("fail")) {
			System.out.println("Test Case Failed");
			extentTest.log(LogStatus.FAIL,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		} else if (strStatus.equalsIgnoreCase("warning")) {
			extentTest.log(LogStatus.WARNING,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		} else if (strStatus.equalsIgnoreCase("skip")) {
			extentTest.log(LogStatus.SKIP,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		} else if (strStatus.equalsIgnoreCase("info")) {
			extentTest.log(LogStatus.INFO,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		} else {
			extentTest.log(LogStatus.UNKNOWN,
					strStepName + extentTest.addScreenCapture("./../Reports/images/" + snapshot + ".png"));
		}
	}
	
	public abstract long takesnap();

	public void endTestCase() {
		extentReports.endTest(extentTest);
	}
	
	public void endReport() {
		extentReports.flush();
	}
}
