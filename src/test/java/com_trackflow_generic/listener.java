package com_trackflow_generic;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

public class listener extends base implements ITestListener
{
  
    ExtentReports extent=Extentreport.getreport();
    ExtentTest test;
    ThreadLocal<ExtentTest> extenttest =new ThreadLocal<ExtentTest>();
    

public void onTestFailure(ITestResult result)
{
    extenttest.get().fail(result.getThrowable());
	//WebDriver driver=null;
    String testmethodname=result.getMethod().getMethodName();
	try {
        driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
    } catch(Exception e)
	{
        
	}
	try
	{
	    extenttest.get().addScreenCaptureFromPath(getscreenshot(testmethodname),result.getMethod().getMethodName());
	}
	catch(IOException e) {
	   e.printStackTrace();
	}
}

public void onFinish(ITestContext context) {
   
   extent.flush();
}

public void onStart(ITestContext arg0) {
   
    
}

public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    // TODO Auto-generated method stub
    
}

public void onTestSkipped(ITestResult arg0) {
    // TODO Auto-generated method stub
    
}

public void onTestStart(ITestResult result) {
    
    test=extent.createTest(result.getMethod().getMethodName());
    extenttest.set(test);
}

public void onTestSuccess(ITestResult arg0) {
    extenttest.get().log(Status.PASS, "Test pass");
    
}
}
