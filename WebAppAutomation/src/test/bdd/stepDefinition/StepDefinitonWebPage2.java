package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;
import com.webapp.pages.Page2HtmlElements;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitonWebPage2 {
	
	
	
	Page1HtmlElements page1Obj;
	Page2HtmlElements page2Obj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;

	
	
	
	@Then("^click on link to navigate to next Webpage Successfully$")
	public void click_on_link_to_navigate_to_next_Webpage_Successfully() throws IOException{
		
		page1Obj  = new Page1HtmlElements();
		page1Obj.verifyLinkNavigation();		
	}

	@Then("^select all items in side menu$")
	public void select_all_items_in_side_menu() throws IOException {
		
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifySideMenuItemLinks();
	}

	@Then("^drag and drop blue card to grey$")
	public void drag_and_drop_blue_card_to_grey() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifyDragNDrop();
	}

	@Then("^click on modal$")
	public void click_on_modal() throws Throwable {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifyModalButton();
	}

	@Then("^click on alert message$")
	public void click_on_alert_message() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifyAlertButton();
	}

	@Then("^click on snackbar$")
	public void click_on_snackbar() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifySnackBar();
	}

	@Then("^flip the card$")
	public void flip_the_card() throws IOException, InterruptedException  {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifyFlipcard();
	}

	@Then("^click on Thumb icon$")
	public void click_on_Thumb_icon() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifyThumbSwitching();
	}

	@Then("^click on slider switch$")
	public void click_on_slider_switch() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifySliderSwitching();
		
	}

	@Given("^search keyword in search bar$")
	public void search_keyword_in_search_bar() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifySearchBar("Test");
	}

	@Then("^verify filtered data in Table$")
	public void verify_filtered_data_in_Table() throws IOException {
		page2Obj  = new Page2HtmlElements();
		page2Obj.verifySearchFucntionality("Test");
	}
	


	
}
