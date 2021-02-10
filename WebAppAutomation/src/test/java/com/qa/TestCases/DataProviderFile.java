package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderFile {

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
	
	


}
