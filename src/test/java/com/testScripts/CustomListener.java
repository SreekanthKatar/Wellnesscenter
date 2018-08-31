package com.testScripts;
	

	import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
	import org.testng.Reporter;
	import org.testng.TestListenerAdapter;








	public class CustomListener extends TestListenerAdapter{
	
		
		 

		/*@Override
		public void onStart(ITestContext testContext) {
			Reporter.log("TEST--->>::::|| "+ testContext.getName() +" ||::::",true);
			Reporter.log("\n",true);
		
		}*/
		
		@Override
		public void onTestStart(ITestResult result) {

			Bill_Settlement_Repository util = new Bill_Settlement_Repository();
			
			Reporter.log("\n",true);
			Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",true);
			Reporter.log("TEST----------->>::::|| "+ result.getName() +" ||:::: "+util.DateandTime(),true);
			Reporter.log("-------------------------------------------------------------------------------",true);

		}
		@Override
		public void onTestSuccess(ITestResult tr)
		{
			Bill_Settlement_Repository util = new Bill_Settlement_Repository();
			Reporter.log("\n",true);
			Reporter.log("-------------------------------------------------------------------------------",true);
			Reporter.log("DONE==>>----<< "+tr.getName()+" >>",true);
			Reporter.log("	R E S U L T--->>::::::::TEST PASSED::::::: "+util.DateandTime(),true);
			Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",true);
			
		}
		@Override
		public void onTestFailure(ITestResult tr) {
			Bill_Settlement_Repository util = new Bill_Settlement_Repository();
			Reporter.log("\n",true);
			Reporter.log("-------------------------------------------------------------------------------",true);
			Reporter.log("ERROR==>>----<< "+tr.getName()+" >>",true);
			Reporter.log("	R E S U L T--->>::::::::TEST FAILED::::::: "+util.DateandTime(),true);
			Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",true);
			
			
//			File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			try{
//				FileUtils.copyFile(scrfile, new File("D:/MyWorkspace/MyAppointment/MyAppointment/target/ "+tr.getName()+" .png"));
//				
//				
//			}catch(Exception e){
//				Reporter.log(e.getMessage(),true);
//			}
		}
		
		@Override
		public void onTestSkipped(ITestResult tr) {
			Bill_Settlement_Repository util = new Bill_Settlement_Repository();
			Reporter.log("\n",true);
			Reporter.log("-------------------------------------------------------------------------------",true);
			Reporter.log("SKIPPED==>>----<< "+tr.getName()+" >>",true);
			Reporter.log("	R E S U L T--->>::::::::TEST SKIPPED::::::: "+util.DateandTime(),true);
			Reporter.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",true);
		
			
			
		}


	}


