package com.project.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.qa.BaseClass.TestBase;
import com.project.qa.Pages.HomePage;
import com.project.qa.Pages.LandingPage;
import com.project.qa.Pages.ResultPage;
import com.project.qa.Utilities.TestUtility;

public class HomePageTest extends TestBase
{
	
	HomePage homePage;
	TestUtility testUtil;
	ResultPage resultPage;
	LandingPage landingPage;
	
	String sheetName = "GoogleSearch"; //Passing Excel Sheet Name
	
	public HomePageTest()
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
	public void homePageTitleTest(Method method) {
		extentTest = extent.startTest(method.getName());
		String title=homePage.getPageTitle();
		Assert.assertEquals(title, "Google");
	}
	@Test(priority=2)
	public void validateLogoTest(Method method) {
		extentTest = extent.startTest(method.getName());
		Boolean flag=homePage.validateLogo();
		Assert.assertTrue(flag);
	}
	@DataProvider
	public Object[][] getExcelTestData(){
		Object data[][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3,dataProvider="getExcelTestData")
	public void searchTest(String searchText,Method method) {
		extentTest = extent.startTest(method.getName());
		landingPage=homePage.searchAction(searchText);
	}
}
