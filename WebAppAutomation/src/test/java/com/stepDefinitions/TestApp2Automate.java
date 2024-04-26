package com.stepDefinitions;

import java.io.IOException;


import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;

import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.ReportsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestApp2Automate {
	BaseConfig baseObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	CanvasPage canvasObj;
	ReportsPage reportObj;

@Before
public void BeforeTest()
{
	System.out.println("Scripts started");
}
@Given("user open the App2Automate page")
public void user_open_the_app2automate_page() throws IOException {
	baseObj = new BaseConfig();
	baseObj.driverConfig();
}

@When("user clicks on {string} tab")
public void user_clicks_on_tab(String pageName) throws IOException {
	hpObj = new HomePage();
	hpObj.pageClick(pageName);
}

@Then("user should redirects to {string} page")
public void user_should_redirects_to_page(String pageName) {
    System.out.println("Page is redirected");
}


@And("user clicks on home page from html page")
public void user_clicks_on_home_page_from_html_page() throws IOException {
	page1Obj = new Page1HtmlElements();
	page1Obj.navigateToHome();
	
}

@And("user clicks on home page from canvas page")
public void ser_clicks_on_home_page_from_canvas_page() throws IOException {
    canvasObj = new CanvasPage();
    canvasObj.navigateToHome();
}

@And("user clicks on home page from reports page")
public void ser_clicks_on_home_page_from_reports_page() throws IOException {
    reportObj = new ReportsPage();
    reportObj.navigateToHome();
}

@Then("user should redirects to Home page")
public void user_should_redirects_to_home_page() {
   System.out.println("Navigated to Home page");
}

@After
public void closeBrowser() throws IOException {
	baseObj = new BaseConfig();
	baseObj.closeBrowserWindow();
}



}
