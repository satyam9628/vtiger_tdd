package com.eva.vtiger.pages.genericScript;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer  {
	private static final int    maxTry = 3;
	   private              int    count  = 0; 
	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess ()) {
	           if (this.count < maxTry) {
	             
	               this.count++;
	               return true;
	           }
	       }
	       return false;
	   
	}

}
