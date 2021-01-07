package com.qa.TestCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.Page2HtmlElements;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;

public class TestRunUnit {
	
	BaseConfig baseObj;
	Page1HtmlElements htmlPageObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	FileInputStream configfis;
	Properties prop ;

	
	@Test(priority=1, enabled = true)
	public void rundriverConfig() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}

	@Test(priority=2)
	@Parameters("selectInitialPage")
	public void runSelectInitialPage(String selectInitialPage) throws IOException
	{
		hpObj = new HomePage();
		hpObj.pageClick(selectInitialPage);
	}
	
	@Test(priority=3, enabled=true, dataProvider="userCredentials", dataProviderClass=DataProviderFile.class)
	public void runUnitTestPage1Ele(String userNameData, String userEmailData) throws IOException
	{
		page1Obj =  new Page1HtmlElements();
		page1Obj.triggerAllElements(userNameData, userEmailData);
	}
	
	@Test(priority=4, enabled=true)
	public void runUnitTestPage2Ele() throws IOException, InterruptedException, AWTException
	{
		
		baseObj = new BaseConfig();
		String page2Url = BaseConfig.prop.getProperty("webPage2URLValue");
		baseObj.driverConfigWithURL(page2Url);
		
		page2Obj = new Page2HtmlElements();
		page2Obj.triggerAllAdvElements();
	}
	

	@Test(priority=5, enabled=true)
	public void runCanvas() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		
		baseObj = new BaseConfig(); 
		String canvasUrl = BaseConfig.prop.getProperty("canvasPageURLValue");
		baseObj.driverConfigWithURL(canvasUrl);
		
		canvasObj = new CanvasPage();
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.triggerAllCanvasMethods();
		canvasOtherObj.verifyHomeNavigation();
	}

	@AfterTest
	public void closeActiveBrowserWindow() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.closeBrowserWindow();
	}
}
