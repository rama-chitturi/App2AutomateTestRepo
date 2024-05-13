package com.qa.parallel;

import java.io.IOException;

import com.webapp.base.BaseConfig;
import com.webapp.pages.Page1HtmlElements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestBasicElements {
	
	Page1HtmlElements page1Obj;
	BaseConfig bsObj;
	
	@When("user enters username as {string} and emailId as {string}")
	public void user_enters_username(String userName, String emailID) throws IOException
	{
		page1Obj = new Page1HtmlElements();
		page1Obj.verifyUserCredential(userName, emailID);
	}
	
	@And("^user clicks on submit button$")
	public void user_clicks_on_submit_button() throws IOException
	{
		page1Obj = new Page1HtmlElements();
		page1Obj.verifyCredentialsSubmission();
	}
	@Then("user should see a alert of status {string}")
	public void user_see_alert(String status)
	{
		System.out.println("Alert seen status "+status);
	}
	@When("^user clicks on OK for confirmation alert$")
	public void user_clicks_OK_Alert() throws IOException
	{
		
		bsObj = new  BaseConfig();
		bsObj.acceptAlert("accept");
		System.out.println();
		//Assert.assertEquals(false, true);
	}
	@Then("^user should see the basic elements in page$")
	public void user_see_basic_elements() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		bsObj.getScreenshot( new Throwable().getStackTrace()[0].getMethodName());
	}

	@After
    public void tearDown() {
 System.out.println("AfterTest");
       
    }
	

}
