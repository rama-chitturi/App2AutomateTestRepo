package com.qa.testcases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

public class FunctionalTest {
	
 BaseConfig baseObj;
	 Page1HtmlElements page1Obj;
	 HomePage hpObj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	
	@BeforeTest(alwaysRun=true)
	public void rundriverConfig() throws IOException
	{
		baseObj = new BaseConfig();
		baseObj.driverConfig();
	}
	

	@Test(priority=1, groups= {"ModulesTest","SmokeTest"},dataProvider="pagesnames", dataProviderClass=Dataproviderfile.class)
	@Parameters(value="searchData")
	public void runSelectInitialPage(String selectInitialPage) throws IOException
	{
		hpObj = new HomePage();
		hpObj.pageClick(selectInitialPage);
		baseObj = new BaseConfig();
		baseObj.navigateBack();
		
	}
	
	@Test(priority=2, enabled=true)
	public  void RunPage1Testcases() throws IOException, InvalidFormatException, InterruptedException
	{
		String pageURL = BaseConfig.prop.getProperty("webPage1URLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(pageURL);
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
	
	@Test(priority=3, enabled=true)
	@Parameters("searchData")
	public void runPage2TestCases(String DataToSearch) throws IOException, InterruptedException
	{

		String pageUrl = BaseConfig.prop.getProperty("webPage2URLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(pageUrl);
		page2Obj  = new Page2HtmlElements();
		page1Obj  = new Page1HtmlElements();
		
		page2Obj.verifySideMenuItemLinks();
		page2Obj.verifyDragNDrop();
		page2Obj.verifyModalButton();
		page2Obj.verifyAlertButton();
		page2Obj.verifySnackBar();
		page2Obj.verifyFlipcard();
		page2Obj.verifyThumbSwitching();
		page2Obj.verifySliderSwitching();
		page2Obj.verifySearchBar(DataToSearch);
		page2Obj.verifySearchFucntionality(DataToSearch);
		page2Obj.verifyChatBox();
		page2Obj.verifyBackArrowNavigation();
		page1Obj.pageClick("Canvas");
		
	}
	
	@Test(priority=5, enabled=true)
	public void runCanvas() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException
	{
		String canvasUrl = BaseConfig.prop.getProperty("canvasPageURLValue");
		baseObj = new BaseConfig();
		baseObj.driverConfigWithURL(canvasUrl);
		canvasObj = new CanvasPage();
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
