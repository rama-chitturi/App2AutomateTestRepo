package com.qa.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Dataproviderfile {

	/** DataProvider for User Name and Email credentials data in WebPage 1 **/
	@DataProvider(name="userCredentials")
	public static Object[][] userCrdentaislData(Method method)
	{
		if(method.getName().equalsIgnoreCase("runIntegrationTestPage1Ele"))
		{
			return new Object[][] {
			{ "Tester_Integration", "Tester@test.com" },
		}; 
		
		}

		else
		{
			return new Object[][] {
				{ "Tester_Unit", "Tester2@test.com" } 

			};
		}
	}
	
	@DataProvider(name = "pagesnames")
	public Object[][] getPageName()
	{
		Object[][] pagesdata = {{"HTML"},{"Canvas"},{"Reports"}};
		return pagesdata;
	}


}
