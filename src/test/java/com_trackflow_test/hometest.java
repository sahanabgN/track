package com_trackflow_test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_trackflow_generic.base;
import com_trackflow_generic.exceldata;
import com_trackflow_pages.homepage;

public class hometest extends base
{
    //homepage hp;
    @Test(priority=4)
   public void verifytoolbarelement() throws InterruptedException, IOException
   {
         homepage hp = new homepage(driver);
       List<WebElement> toolbarelement = hp.getalldata();
       String[] allelement=new String[toolbarelement.size()];
       int i=0;
       for(WebElement allelement1:toolbarelement)
       {
           allelement[i]=allelement1.getText();
           Reporter.log(allelement[i], true);
           driver.navigate().refresh();
           if(allelement[i].contains("home"))
              {
               
                 Reporter.log("home icon is present", true);
                 
                  hp.home().click();
                 
               /*  if(Homewebelement.isEnabled())
                 {
                     Homewebelement.click(); 
                     Reporter.log("home element is  enabled", true);
                 }
                 else
                 {
                     Reporter.log("home element is not enabled", true);
                 }
                 
              } */
              }
           else
           {
               Reporter.log("home element is not present", true);
           }
              
       }
      
   }
    @Test(priority=5)
       public void verifySidemenu() throws InterruptedException, IOException
       {
            homepage hp = new homepage(driver);
           List<WebElement> sidemenulist = hp.getallmenudata();
           String[] sidemenuelement=new String[sidemenulist.size()];
           int i=0;
           for(WebElement sidemenuelementtext:sidemenulist)
           {
               sidemenuelement[i]=sidemenuelementtext.getText();
               Reporter.log(sidemenuelement[i], true);
               
           }
         
       }
    @Test(priority=6)
    public List<WebElement> userandgroup() throws InterruptedException, IOException
    {
        int i=0;
        homepage hp = new homepage(driver);
        WebElement userandgroupelement = hp.user$group();
        userandgroupelement.click();
        Thread.sleep(3000);
        //Reporter.log("userandgroup", true);
        List<WebElement> userandgrouplist1 = hp.userandgrouplist();
        return userandgrouplist1;
    } 
    @Test(priority=7)
    public void userandgroup_newuser() throws InterruptedException, IOException
    {
        homepage hp=new homepage(driver);
        hometest ht=new hometest();
        List<WebElement> userandgrouplist1 = ht.userandgroup();
        String[] userandgrouparray=new String[userandgrouplist1.size()];
        int i=0;
        
        for(WebElement userandgrouplist2:userandgrouplist1)
        {
            userandgrouparray[i]=userandgrouplist2.getText();
            Reporter.log(userandgrouparray[i], true);
            //driver.navigate().refresh();
            if(userandgrouparray[i].contains("New user"))
            {
                WebElement newuserelement = hp.newuser();
                newuserelement.click();
                String actualtitle=driver.getTitle();
                base b=new base();
                String expectedtitle=b.validtitle("userandgrouptitle");
                if(actualtitle.equalsIgnoreCase(expectedtitle))
                {
                    Reporter.log("valid usergroupcard title", true);
                    
                }
                else
                {
                    Reporter.log("invalid usergroupcard title", true);
                }
            }
            
            else
            {
                Reporter.log("new user element not present", true);
            }
         
        }
    }
    @Test(priority=9)
    public void userandgroupuser() throws InterruptedException, IOException
    {
        homepage hp=new homepage(driver);
        hometest ht=new hometest();
        List<WebElement> userandgrouplist1 = ht.userandgroup();
        String[] userandgrouparray=new String[userandgrouplist1.size()];
        int i=0;
        
        for(WebElement userandgrouplist2:userandgrouplist1)
        {
            userandgrouparray[i]=userandgrouplist2.getText();
            Reporter.log(userandgrouparray[i], true);
              if(userandgrouparray[i].contains("Users"))
                {
                   hp.user().click();
                   hp.loginsort().click();
                   ArrayList<String> originallist=new ArrayList<String>();
                   List<WebElement> listelement = hp.loginsortcoloumn();
                  // String[] sortingarray=new String[listelement.size()];
                   for(int s=0;s<listelement.size();s++)
                   {
                       originallist.add(listelement.get(s).getText());
                       
                   }
                   System.out.println(originallist);
                   ArrayList<String> sortedlist=new ArrayList<String>();
                   for(int s=0;s<originallist.size();s++)
                   {
                       sortedlist.add(originallist.get(s));
                       
                   }
                   
                   Collections.sort(sortedlist);
                  // Collections.reverse(sortedlist);
                   System.out.println(sortedlist);
                   try
                   {
                  Assert.assertEquals(originallist,sortedlist);
                   }
                   catch(Exception e)
                   {
                       
                   }
                  
                }
              else
              {
                  Reporter.log("Users element is not present", true);
              }
           }
        
    } 
    
        
   @DataProvider
    public Object[][] getuserdata()
    {
        exceldata ex=new exceldata();
        Object retdata[][] = ex.getexceldata(".\\src\\main\\java\\data.xlsx", "userdata");
        return retdata;
    }
    @Test(dataProvider="getuserdata", priority=8)
    public void newuserdata(String lastname, String firstname, String post, String login, String password, String mobile, String note) throws InterruptedException, IOException
    {
       
        //Select s1=new Select(driver.findElement(By.id("admin")));
       // s1.selectByVisibleText("No");
      // String dropdownelement = dropdown;
      // Reporter.log(dropdownelement, true);
       
        homepage hp=new homepage(driver);
        hp.newuserdata(lastname,firstname,post, login, password, mobile, note);
        Thread.sleep(3000);
        
        try
        {
            driver.switchTo().alert();
            Reporter.log("alertmsg", true);
        }
        catch(NoAlertPresentException e)
        {
            Reporter.log("no alert present", true);
        }
        
    
    }
    public void verifycreateduser(String firstname) throws IOException
    {
        
        base b=new base();
        String expectedtitle=b.validtitle("expectedusercardtitle");
        String actualtitle=driver.getTitle();
        
        if(actualtitle.equalsIgnoreCase(expectedtitle))
        {
            Reporter.log("user is created", true);
            String createdusername=firstname;
            
        }
        else
        {
            homepage hp=new homepage(driver);
            WebElement duplicateusermsg1 = hp.duplicateusermsg();
            String getduplicateerrormsg = duplicateusermsg1.getText();
            Reporter.log(getduplicateerrormsg+"user is not created", true);
            
        }
    }
    
}
      
    


