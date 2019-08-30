package com.project.qa.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.qa.BaseClass.TestBase;

public class ResultPage extends TestBase
{
	
	@FindBy(xpath = "//*[@title='Return to Selenium home page']")
	WebElement title;
	
	@FindBy(name = "q")
	WebElement searchField;
	
	@FindBy(name = "btnK")
	WebElement searchButton;
	
	public ResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
