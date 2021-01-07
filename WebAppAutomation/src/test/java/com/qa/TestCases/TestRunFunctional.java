package com.qa.TestCases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;


public class TestRunFunctional {
	
	static BaseConfig baseObj;
	static Page1HtmlElements page1Obj;
	static HomePage hpObj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	
	@Test(priority=1, enabled = true)
	public static void rundriverConfig() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}
	
	@Test(priority=2, enabled=true)
	public static void runHomePage() throws IOException
	{
		hpObj = new HomePage();
		hpObj.pageClick("htmlelements");
	}
	
	@Test(priority=3, enabled=true)
	public static void RunPage1Testcases() throws IOException, InvalidFormatException, InterruptedException
	{
		 page1Obj  = new Page1HtmlElements();
		 page1Obj.verifyMenuItemLinks();
		 page1Obj.verifyUserCredential();
		 page1Obj.verifyGroupRadioButton();
		 page1Obj.verifyCheckBox();
		 page1Obj.verifyDropdownItems();
		 page1Obj.verifyUploadFileFormat();
		 page1Obj.verifyDropupButton();
		 page1Obj.verifyLinkNavigation();
	}
	
	@Test(priority=4, enabled=true)
	public void runPage2TestCases() throws IOException, InterruptedException
	{
		page2Obj  = new Page2HtmlElements();
		page1Obj  = new Page1HtmlElements();
		
		page2Obj.verifySideMenuItemLinks();
		page2Obj.verifyModalButton();
		page2Obj.verifyAlertButton();
		page2Obj.verifyFlipcard();
		page2Obj.verifyThumbSwitching();
		page2Obj.verifySliderSwitching();
		page2Obj.verifySearchFucntionality();
		page2Obj.verifyChatBox();
		page2Obj.verifyBackArrowNavigation();
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
	
	
	@AfterTest
	public void closeActiveBrowserWindow() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.closeBrowserWindow();
	}
	

}
