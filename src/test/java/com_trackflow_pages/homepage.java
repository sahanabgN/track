package com_trackflow_pages;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com_trackflow_generic.base;
import com_trackflow_test.hometest;

public class homepage
{
   @FindBy(id="tmenu_tooltip")
   private List<WebElement> menubar;
   @FindBy(xpath="//div[@class='mainmenu home']")
   private  WebElement home;
   @FindBy(xpath="//div[@class='vmenu']")
   private List<WebElement> sidemenu;
   @FindBy(xpath="//div[@class='vmenu'] //a[text()=\"Users & Groups\"]")
   private WebElement userandgroup;
   @FindBy(xpath="//div[@class='menu_contenu'] ")
   private List<WebElement> userandgrouplist;
   @FindBy(xpath="//a[text()='New user']")
   private WebElement newuser;
   @FindBy(name="nom")
   private WebElement lastname;
   @FindBy(name="prenom")
   private WebElement firstname;
   @FindBy(name="job")
   private WebElement PostOrFunction;
   @FindBy(name="login")
   private WebElement login;
   @FindBy(name="password")
   private WebElement password;
   @FindBy(name="user_mobile")
   private WebElement Mobile;
   @FindBy(name="note")
   private WebElement note;
   @FindBy(xpath="//input[@class='button']")
   private WebElement createuser;
   @FindBy(xpath="//a[text()='Users']")
   private WebElement users;
   @FindBy(xpath="//th[text()='Login'] //img[@class='imgdown']")
   private WebElement loginsort;
   @FindBy(xpath="//table[@class='noborder']//tr//td[1]")
   private List<WebElement> loginsortcoloumn;
   @FindBy(id="admin")
   private WebElement dropdown;
   @FindBy(xpath="//div[text()='Login  already exists.']")
   private WebElement duplicateusermsg;
   
   public homepage(WebDriver driver)
   {
       PageFactory.initElements(driver, this);
   }

public List<WebElement> getalldata()

{
   return menubar;
}
public WebElement home()
{
    return home;
}
public List<WebElement> getallmenudata()
{
    return sidemenu;
}
public WebElement user$group()
{
    return userandgroup;
}    
public List<WebElement> userandgrouplist()
{
    return userandgrouplist;
}
public WebElement newuser()
{
    return newuser;
}
public WebElement user()
{
    return users;
}
public WebElement loginsort()
{
    return loginsort;
}
public List<WebElement> loginsortcoloumn()
{
    return loginsortcoloumn;
}
public WebElement createuser()
{
    return createuser;
}
public WebElement duplicateusermsg()
{
    return duplicateusermsg;
}


public void newuserdata(String lastname1, String firstname1, String post1, String login1, String password1, String mobile1, String note1) throws IOException, InterruptedException
{
   
    lastname.sendKeys(lastname1);
    firstname.sendKeys(firstname1);
    PostOrFunction.sendKeys(post1);
    login.sendKeys(login1);
    password.sendKeys(password1);
    Mobile.sendKeys(mobile1);
    note.sendKeys(note1);
    createuser.click();
    hometest ht=new hometest();
    ht.verifycreateduser(firstname1);
    newuser.click();
   
}
}