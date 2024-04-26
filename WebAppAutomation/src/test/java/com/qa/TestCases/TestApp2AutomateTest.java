package com.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.ReportsPage;

import io.cucumber.java.en.Then;


public class TestApp2AutomateTest {

	BaseConfig baseObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	CanvasPage canvasObj;
	ReportsPage reportObj;

@BeforeTest(alwaysRun = true)
public void BeforeTesting()
{
	System.out.println("Scripts started");
}

@Test(priority=1 ,groups={"StartSetup","SmokeTesting"}, timeOut = 30000)
public void user_open_the_app2automate_page() throws IOException {
	baseObj = new BaseConfig();
	baseObj.driverConfig();
}

@Test(priority=2 ,groups={"FunctionalTesting","SmokeTesting"})
@Parameters({"PageName"})
public void user_clicks_on_tab(String str) throws IOException {
	hpObj = new HomePage();
	hpObj.pageClick(str);
}
@Test(priority=3 ,groups="SmokeTesting")
public void testPrint() {
	Assert.assertEquals(false, true);
	
    System.out.println("Page is redirected");
}
@Test(priority=4 ,dependsOnMethods = { "testPrint"}, groups="SmokeTesting" )
public void testdependentMethods() {
	Assertion softAssert = new SoftAssert();
	softAssert.assertEquals(true, false);
    System.out.println("dependsOnMethods is tested");
}
	
}
