package com.project.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.qa.BaseClass.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(id = "hplogo")
	WebElement logo;
	
	@FindBy(name = "q")
	WebElement searchField;
	
	@FindBy(name = "btnK")
	WebElement searchButton;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public String getPageTitle() {
		return driver.getTitle();	
	}
	
	public LandingPage searchAction(String searchText) {
		searchField.sendKeys(searchText);
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
		return new LandingPage();	
	}
}