package util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGen{
	
	public ExtentReports extent;
	ExtentSparkReporter spark;
	public static ExtentTest test;
	public ExtentReportGen()
	{
		extent= new ExtentReports();
		spark= new ExtentSparkReporter(new File("index.html"));
		spark.config().setDocumentTitle("ResReq Testing");
		spark.config().setReportName("User Tests");
		extent.attachReporter(spark);
	}
	
	public ExtentTest getTest()
	{		
		return test;
	}
	
	public void setTest(String testName)
	{
		test=extent.createTest(testName);
	}

}
