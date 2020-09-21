package com_trackflow_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com_trackflow_generic.base;
 
public class loginpage 
{
   @FindBy(id="username")
   private WebElement login;
   @FindBy(id="password")
   private WebElement passwordelement;
   @FindBy(xpath="//input[@type='submit']")
   private WebElement connection;
   @FindBy(linkText="(Password forgotten ?")
   private WebElement forgotpassword;
   

public loginpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void verifylogincredential(String username, String password) throws InterruptedException
{
    
    login.clear();
	login.sendKeys(username);
	passwordelement.clear();
	passwordelement.sendKeys(password);
	//Thread.sleep(3000);
	connection.click();
	
	
}

}