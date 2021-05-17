package runner;

import java.awt.Desktop;
import java.io.File;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import com.aventstack.extentreports.ExtentTest;

import util.ExtentReportGen;

public final class MyRunListener extends RunListener {

	private ExtentReportGen reporter;
	public static ExtentTest test;

	public void testRunStarted(Description description) {
		
		reporter = new ExtentReportGen();
	}

	public void testStarted(Description description) throws Exception {
		String methodname = description.getMethodName();
		if (methodname.contains("["))
			 reporter.setTest(methodname.substring(0, methodname.indexOf("[")));
		else
			 reporter.setTest(methodname);
		
		test=reporter.getTest();
	}

	public void testFinished(Description description) throws Exception {
		
	}

	public void testRunFinished(Result result) throws Exception {
		reporter.extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
}
