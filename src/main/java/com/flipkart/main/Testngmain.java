package com.flipkart.main;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.flipkart.testcases.TC001;
import com.flipkart.testcases.TC002;
import com.flipkart.testcases.TC003;
import com.flipkart.testcases.TC004;

public class Testngmain {

	public static void main(String[] args) {
		
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {TC003.class});
		
		testng.run();
		}
}
