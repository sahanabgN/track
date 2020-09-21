package com_trackflow_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_trackflow_generic.base;
import com_trackflow_generic.exceldata;
import com_trackflow_pages.loginpage;

public class logintest extends base
{
    
	@DataProvider
  public Object[][] getlogindata() throws IOException
  {
	    
		exceldata ex=new exceldata();
		Object retdata[][] = ex.getexceldata(".\\src\\main\\java\\data.xlsx", "logindata");
		return retdata;
  }
	
	@Test(priority=1,dataProvider="getlogindata")
	public void logindata(String username, String password) throws InterruptedException, IOException
	{
	    loginpage lp=new loginpage(driver);
		lp.verifylogincredential(username, password);
			logintest.validatetitle();	
	    //Thread.sleep(3000);
  }
	@Test(priority=2)
	public static void validatetitle() throws IOException
	{
	    base b=new base();
	    String expectedtitle = b.validtitle("expectedlogintitle");
	    System.out.println("expected title is " +expectedtitle );
	    String actualtitle=driver.getTitle();
	    System.out.println("actual title is" +actualtitle);
	    if(actualtitle.equalsIgnoreCase(expectedtitle))
	    {
	        //System.out.println("username" +username +"password" + password );
	        Reporter.log("valid login credential", true);
	        
	    }
	    else
	    {
	       // System.out.println("username" +username +"password" + password );
	       Reporter.log("invalid login credential", true);
	       
	       
	    }
	   // hometest hp=new hometest();
	 }
	
}
