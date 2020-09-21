package com_trackflow_generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base 
{
	public static WebDriver driver;
	 
	static Properties prop;
    @BeforeSuite
	public static Properties initialise() throws IOException
	{
    	 prop = new Properties();
    	FileInputStream fis = new FileInputStream("F:\\selenium\\trackflow\\src\\main\\java\\resource.properties");
    	prop.load(fis);
    	
		String browsername=prop.getProperty("browser");
    	if(browsername.equals("chrome"))
		{
    	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
        String url1=prop.getProperty("url");
        System.out.println(url1);
        driver.get(url1);
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        return prop;
	}
public String validtitle(String expectedpagetitle) throws IOException
{
    
    
   // Properties prop1 = base.initialise();
    String expectedtitle = prop.getProperty(expectedpagetitle);
    System.out.println(expectedtitle);
    return expectedtitle;
}
   
    
    public String getscreenshot(String testcasename) throws IOException
    {
        System.out.println("base.getscreenshot()");
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
        FileUtils.copyFile(source, new File(dest));
        return dest;
    }
    @AfterSuite
	public void teardown()
	{
		driver.close();
	}
}
