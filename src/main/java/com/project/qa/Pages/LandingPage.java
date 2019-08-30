package com.project.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.qa.BaseClass.TestBase;

public class LandingPage extends TestBase
{
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[contains(text(),'Selenium - Web Browser Automation')]")
	WebElement seleniumLink;
	
	public String getPageTitle() {
		return driver.getTitle();	
	}
	
	public ResultPage openSearchLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(seleniumLink)).click();
		return new ResultPage();	
	}
	
	public boolean validateSearchResult() {
		return seleniumLink.isDisplayed();	
	}
}
