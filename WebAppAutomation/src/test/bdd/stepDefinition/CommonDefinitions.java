package stepDefinition;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.webapp.base.BaseConfig;
import com.webapp.pages.HomePage;
import com.webapp.pages.Page1HtmlElements;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonDefinitions {
	
	BaseConfig baseObj;
	HomePage hpObj;
	Page1HtmlElements page1Obj;
	
	@Given("^user navigates to AppAutomate$")
	public void user_navigates_to_App_Automate() throws IOException  {
		baseObj = new BaseConfig();
		baseObj.driverConfig();

	}

	@When("^user clicks on HtmlPageTag card$")
	public void user_clicks_on_HtmlPageTag_card() throws IOException {
		hpObj = new HomePage();
		hpObj.pageClick("htmlelements");
	}
	
	
	
	@When("^username \"([^\"]*)\" and useremail \"([^\"]*)\" validates$")
	public void userCredentialsValidation(String username, String useremail) throws IOException, InvalidFormatException {
		
		page1Obj  = new Page1HtmlElements();
		page1Obj.verifyUserCredential(username,useremail);
	}
	
	@When("^username and user emailID validates$")
	public void userCredentialsValidationDataTable(DataTable dataTable) throws IOException, InvalidFormatException {
		
		Map<String, String> mapObj = dataTable.asMap(String.class, String.class);
		page1Obj  = new Page1HtmlElements();
		page1Obj.verifyUserCredential(mapObj.get("username"),mapObj.get("useremail"));
	}
	

}
