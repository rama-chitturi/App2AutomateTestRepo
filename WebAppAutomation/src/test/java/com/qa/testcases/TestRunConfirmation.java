package com.qa.TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.webapp.base.BaseConfig;
import com.webapp.pages.Page1HtmlElements;

public class TestRunConfirmation   {

	Page1HtmlElements page1Obj;
	BaseConfig bcObj ;
	TestRunFunctional trfObj;


	@Test(groups= {"sanity"})
	public void verifyCredentialsValidation() throws IOException, InvalidFormatException
	{
		trfObj = new TestRunFunctional();
		trfObj.rundriverConfig();
		trfObj.runHomePage();
		page1Obj  = new Page1HtmlElements();
		page1Obj.verifyUserCredential();
	}

	@Test(groups="regression")
	public void verifyCredentialsDependency() throws IOException, InvalidFormatException, InterruptedException
	{
		trfObj = new TestRunFunctional();
		trfObj.rundriverConfig();
		trfObj.runHomePage();
		trfObj.RunPage1Testcases();
	}

	@Test(groups="smoke")
	public void verifybrokenLinks() throws MalformedURLException, IOException
	{
		bcObj =  new BaseConfig();
		bcObj.driverConfig();
		bcObj.verifyBrokenLinks();
	}


	@AfterMethod
	public void closeActiveBrowserWindow() throws IOException
	{
		bcObj = new BaseConfig();
		bcObj.closeBrowserWindow();
	}
}
