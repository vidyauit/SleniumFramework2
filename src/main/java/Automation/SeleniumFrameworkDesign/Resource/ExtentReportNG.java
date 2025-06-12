package Automation.SeleniumFrameworkDesign.Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getreportObject() {
		//ExtentReport and extentSparkReporter
		
		     String path = System.getProperty("user.dir")+"\\reports\\index.html";
		     ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		     reporter.config().setReportName("Web Auromation Testresult");
		     reporter.config().setDocumentTitle("Test Results");
		     
		     ExtentReports extent = new ExtentReports();
		     extent.attachReporter(reporter);
		     extent.setSystemInfo("Tester", "Vidya Devi");
		     return extent;
		     
	}
	
	public static void repotrt() {
		String path  = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Automation");
		report.config().setDocumentTitle("test result");
		ExtentReports ext  =  new ExtentReports();
		ext.attachReporter(report);
		ext.setSystemInfo("Testet", "Vidya");
	}
	

}
