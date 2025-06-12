package Automation.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Automation.SeleniumFrameworkDesign.Resource.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports  extent = ExtentReportNG.getreportObject();
	@Override
	
	public void onTestStart(ITestResult result) {
		    // not implemented
		
		 test = extent.createTest(result.getMethod().getMethodName());
		  }

	@Override
	public void onTestSuccess(ITestResult result) {
	   test.log(Status.PASS, "Test passed");
	  }
	
	@Override 
	public void onTestFailure(ITestResult result) {
	   test.log(Status.FAIL, "Test Failed");
	   test.fail(result.getThrowable());
	   try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
				   .get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   String filepath =null;
	   try {
		 filepath = getScreenShot(result.getMethod().getMethodName() , driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	
	}
	   test.addScreenCaptureFromPath(filepath);
	   
	   //screenshot 
	  }
	@Override
	public void onFinish(ITestContext context) {
	   extent.flush();
		
	  }

}
