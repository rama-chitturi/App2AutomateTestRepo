package com.qa.testcases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

public class ModulesTest {
	
	BaseConfig baseObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	FileInputStream configfis;
	Properties prop ;

	
	@BeforeTest(alwaysRun=true)
	public void rundriverConfig() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}

	@Test(priority=1, groups= {"ModulesTest","SmokeTest"},dataProvider="pagesnames", dataProviderClass=Dataproviderfile.class)
	public void runSelectInitialPage(String selectInitialPage) throws IOException
	{
		hpObj = new HomePage();
		hpObj.pageClick(selectInitialPage);
		baseObj = new BaseConfig();
		baseObj.navigateBack();
		
	}
		
	@Test (priority=2, groups= {"ModulesTest","SmokeTest"},enabled=true,dataProvider = "userCredentials", dataProviderClass = Dataproviderfile.class)
	public void runPage1Ele(String userNameData, String userEmailData) throws IOException, InterruptedException
	{
		String pageURL = BaseConfig.prop.getProperty("webPage1URLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(pageURL);
		page1Obj =  new Page1HtmlElements();
		page1Obj.triggerAllElements(userNameData, userEmailData);
	}
	
	@Test(priority=3, enabled=true, groups= {"ModulesTest","SmokeTest"})
	public void runPage2Ele() throws IOException, InterruptedException, AWTException
	{
		
		String pageUrl = BaseConfig.prop.getProperty("webPage2URLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(pageUrl);
		page2Obj = new Page2HtmlElements();
		page2Obj.triggerAllAdvElements();
	}
	

	@Test(priority=4, enabled=true, groups= {"ModulesTest","SmokeTest"})
	public void runCanvas() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		
		String canvasUrl = BaseConfig.prop.getProperty("canvasPageURLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(canvasUrl);
		
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.triggerAllCanvasMethods();
		canvasOtherObj.verifyHomeNavigation();
	}

	@AfterTest(alwaysRun=true)
	public void closeActiveBrowserWindow() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.closeBrowserWindow();
	}
}
