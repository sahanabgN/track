package com_trackflow_generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport
{
  public static ExtentReports getreport()
  {
      String path = System.getProperty("user.dir")+"\\reports\\index.html";
      ExtentSparkReporter reporter =new ExtentSparkReporter(path);
      reporter.config().setReportName("WebAutomationResult");
      reporter.config().setDocumentTitle("TestResults");
       ExtentReports extent = new ExtentReports();
      extent.attachReporter(reporter);
      extent.setSystemInfo("tester", "Sahana");
      return extent;
  }
}
