package com_trackflow_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com_trackflow_generic.base;
import com_trackflow_pages.thirdpartypage;

public class thirdpartytest extends base
{
    @Test(priority=10)
   public void addpointofcontact()
   {
       thirdpartypage tp=new thirdpartypage(driver);
       tp.thirdpartyhome().click();
       List<WebElement> modifiedthirdpartylist = tp.modifiedthirdparties();
       String[] s=new String[modifiedthirdpartylist.size()];
       int i=0;
       for(WebElement modifiedthirdpartieslist:modifiedthirdpartylist)
       {
          s[i] =modifiedthirdpartieslist.getText();
          Reporter.log(s[i], true);
          if(s[i].contains("yamahayamaha"))
          {
              tp.modifiedelement().click();
              tp.addcontact().click();
              tp.lastname.sendKeys("keycontact");
              tp.calendar.click();
              thirdpartytest tpt=new thirdpartytest();
              tpt.selectdate();
              
          }
          else
          {
              Reporter.log("element not present in modified list", true);
          }
       }
       
   }
    public void selectdate()
    {
        
        while(!driver.findElement(By.xpath("//table[@class='dp']")).getText().contains("september, 2021"))
        {
            driver.findElement(By.xpath("//td[@class='dpButtons'][4]")).click();
        }
        List<WebElement> day=driver.findElements(By.xpath("//tr[@class='dpWeek']//td"));
        int count=day.size();
        for(int i=0;i<=count;i++)
        {
            String date = driver.findElements(By.xpath("//td[@class='dpReg']")).get(i).getText();
            if(date.equalsIgnoreCase("21"))
            {
                driver.findElements(By.xpath("//td[@class='dpReg']")).get(i).click();
                Reporter.log(date, true);
                driver.findElement(By.xpath("//input[@type='checkbox']")).click();
                driver.findElement(By.xpath("//input[@name='add']")).click();
                
                break;
            }
            else
            {
                Reporter.log("date is incorrect", true);
            }
        }
    }
    
}
