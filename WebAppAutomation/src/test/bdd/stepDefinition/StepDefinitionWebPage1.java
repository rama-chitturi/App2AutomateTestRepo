package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class StepDefinitionWebPage1 {

	BaseConfig baseObj;
	Page1HtmlElements page1Obj;
	HomePage hpObj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;
	
	
	@Then("^check Radiobutton value$")
	public void check_Radiobutton_value() throws IOException {
		page1Obj  = new Page1HtmlElements();
		 page1Obj.verifyGroupRadioButton();
	}

	@And("^check Checkbox value$")
	public void check_Checkbox_value() throws IOException{
		page1Obj  = new Page1HtmlElements();
		 page1Obj.verifyCheckBox();
	}

	@And("^Select an item from dropdown$")
	public void select_an_item_from_dropdown() throws IOException 
	{	
	page1Obj  = new Page1HtmlElements();
	 page1Obj.verifyDropdownItems();
	}

	@And("^Select an file to upload$")
	public void select_an_file_to_upload() throws IOException, InterruptedException{
		page1Obj  = new Page1HtmlElements();
		 page1Obj.verifyUploadFileFormat();
	}

	@And("^Select an item from dropup$")
	public void select_an_item_from_dropup() throws IOException {
		page1Obj  = new Page1HtmlElements();
		 page1Obj.verifyDropupButton();
	}

	@Then("^Click on link to navigate to next Webpage Successfully$")
	public void click_on_link_to_next_page() throws IOException {
		page1Obj  = new Page1HtmlElements();
		page1Obj.verifyLinkNavigation();
	}

	

	

}
