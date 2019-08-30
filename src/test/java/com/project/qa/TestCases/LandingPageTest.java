package com.project.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.qa.BaseClass.TestBase;
import com.project.qa.Pages.HomePage;
import com.project.qa.Pages.LandingPage;
import com.project.qa.Pages.ResultPage;
import com.project.qa.Utilities.TestUtility;

public class LandingPageTest extends TestBase
{
	HomePage homePage;
	TestUtility testUtil;
	ResultPage resultPage;
	LandingPage landingPage;
	
	String sheetName = "Contacts"; //Passing Excel Sheet Name
	
	public LandingPageTest()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{
		initialization(Browser);
		testUtil = new TestUtility();
		Log.info("Application Launched Successfully in the browser: "+Browser);
		homePage=new HomePage();
	}
	
	@Test(priority=1)
	public void validatePageTitleTest(Method method) {
		extentTest = extent.startTest(method.getName());
		String landingpageTitle=landingPage.getPageTitle();
		Assert.assertEquals(landingpageTitle, "selenium - Google Search","Landing page title not matched.");
	}
	
	@Test(priority=2)
	public void validateSearchResultTest(Method method) {
		extentTest = extent.startTest(method.getName());
		Assert.assertTrue(landingPage.validateSearchResult(), "Search result is not displaying");
	}
}

