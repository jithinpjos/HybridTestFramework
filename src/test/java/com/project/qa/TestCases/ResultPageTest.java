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
import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager.Property;


public class ResultPageTest extends TestBase
{
	HomePage homePage;
	TestUtility testUtil;
	ResultPage resultPage;
	LandingPage landingPage;
	
	String sheetName = "Contacts"; //Passing Excel Sheet Name
	
	public ResultPageTest()
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
		landingPage=new LandingPage();
		homePage=new HomePage();
		landingPage=homePage.searchAction(property.getProperty("SearchText"));
		resultPage=landingPage.openSearchLink();
	}
	
	@Test(priority=1)
	public void validateTitleTest(Method method) throws InterruptedException {
		extentTest = extent.startTest(method.getName());
		Thread.sleep(2000);
		String resultPageTitle=resultPage.getPageTitle();
		Log.info("Title from the result Page:" +resultPageTitle);
		Assert.assertEquals(resultPageTitle, "Selenium - Web Browser Automation","Result page title not matched");
	}
	
}
