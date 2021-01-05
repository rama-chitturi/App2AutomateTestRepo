package com.qa.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

public class TestRunIntergration {
	
	
	BaseConfig baseObj;
	Page1HtmlElements htmlPageObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	
	@BeforeSuite
	public void rundriverConfig() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}
	
	@Test(priority=2, enabled=true)
	public void runHomePage() throws IOException
	{
		hpObj = new HomePage();
		hpObj.pageClick("htmlelements");
	}
	
	
	@Test(priority=3, enabled=true)
	public void runHtmlElements() throws IOException
	{
		page1Obj =  new Page1HtmlElements();
		page1Obj.triggerAllElements();
	}
	
	@Test(priority=4, enabled=true)
	public void runHtmlAdvElements() throws IOException, InterruptedException, AWTException
	{
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
		canvasObj = new CanvasPage();
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.triggerAllCanvasMethods();
		canvasOtherObj.verifyHomeNavigation();
	}

}
