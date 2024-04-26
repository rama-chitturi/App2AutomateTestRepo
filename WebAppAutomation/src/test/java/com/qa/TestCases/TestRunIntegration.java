package com.qa.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

public class TestRunIntegration {
	
	
	BaseConfig baseObj;
	Page1HtmlElements htmlPageObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	
	@Test(priority=1, enabled=true)
	public void rundriverConfig() throws IOException
	{
		System.out.println("rundriverConfig");
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}
	
	@Test(priority=2, enabled=true)
	@Parameters("selectInitialPage")
	public void runHomePage(String selectInitialPage) throws IOException
	{
		System.out.println("runHomePage");
		hpObj = new HomePage();
		hpObj.pageClick(selectInitialPage);
	}
	
	
	@Test(priority=3, enabled=true, dataProvider="userCredentials", dataProviderClass=DataProviderFile.class)
	public void runIntegrationTestPage1Ele(String userNameData, String userEmailData) throws IOException
	{
		page1Obj =  new Page1HtmlElements();
		page1Obj.triggerAllElements(userNameData, userEmailData);
		
	}
	
	@Test(priority=4, enabled=true)
	public void runIntegrationTestPage2Ele() throws IOException, InterruptedException, AWTException
	{
		System.out.println("runIntegrationTestPage2Ele");
		page2Obj = new Page2HtmlElements();
		baseObj = new BaseConfig();
		page1Obj = new Page1HtmlElements();
		
		page2Obj.triggerAllAdvElements();
		baseObj.navigateBack();
		page1Obj.pageClick("canvas");
	}

	@Test(priority=5, enabled=true)
	public void runCanvas() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		System.out.println("runCanvas");
		canvasObj = new CanvasPage();
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.triggerAllCanvasMethods();
		canvasOtherObj.verifyHomeNavigation();
	}
	
//	@AfterTest
//	public void closeActiveBrowserWindow() throws IOException
//	{
//		baseObj = new BaseConfig();
//		baseObj.closeBrowserWindow();
//	}

}
