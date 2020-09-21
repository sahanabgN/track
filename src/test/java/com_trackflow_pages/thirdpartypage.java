package com_trackflow_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class thirdpartypage 
{
    @FindBy(xpath="//span[text()='Third parties']")
    private WebElement thirdparty;
    @FindBy(xpath="//td[@class='notopnoleftnoright']//tr//td[1]")
    private List<WebElement> modifiedthirdparties;
    @FindBy(xpath="//a[text()='yamahayamaha']")
    private WebElement modifiedelement;
    @FindBy(xpath="//a[text()='Add contact/address ']")
    private WebElement addcontact;
    @FindBy(xpath="//img[@class='datecallink']")
    public WebElement calendar;
    @FindBy(name="lastname")
    public WebElement lastname;
    public thirdpartypage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public WebElement thirdpartyhome()
    {
        return thirdparty;
    }
    public List<WebElement> modifiedthirdparties()
    {
        return modifiedthirdparties;
    }
    public WebElement modifiedelement()
    {
        return modifiedelement;
    }
    public WebElement addcontact()
    {
        return addcontact;
    }
    
}
