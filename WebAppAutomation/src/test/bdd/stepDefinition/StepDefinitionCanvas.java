package stepDefinition;

import static org.junit.Assert.fail;

import java.io.IOException;

import com.webapp.base.BaseConfig;
import com.webapp.pages.CanvasPage;
import com.webapp.pages.CanvasPageOtherMethods;
import com.webapp.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionCanvas {


	BaseConfig baseObj;
	HomePage hpObj;
	CanvasPage canvasObj;
	CanvasPageOtherMethods canvasOtherObj;


	@When("^user clicks on Canvas card$")
	public void user_clicks_on_Canvas_card() throws IOException {
		hpObj = new HomePage();
		hpObj.pageClick("canvas");
	}

	@Given("^pick \"([^\"]*)\" to draw$")
	public void color_to_pick(String colorname) throws IOException {
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.pickColorMethod(colorname);

	}

	@Then("^clear canvas by cliking on clear canvas$")
	public void clear_canvas_by_cliking_on_clear_canvas() throws IOException, InterruptedException {
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.clearCanvasMethod();
	}

	@Then("^Draw a \"([^\"]*)\" shape$")
	public void draw_a_shape(String shape) throws IOException {
		canvasObj = new CanvasPage();
		switch(shape)
		{
		case "square":
			canvasObj.drawSquareMethod();
			break;
		case "rhombus":
			canvasObj.drawRhombusMethod();
			break;
		case "alphabet":
			canvasObj.drawCharMethod();
			break;
		default:
			System.out.println("Given shape to draw not inclued to run");

		}


	}

	

	@Then("^click on back to home page$")
	public void click_on_back_to_home_page() throws IOException {
		canvasOtherObj = new CanvasPageOtherMethods();
		canvasOtherObj.verifyHomeNavigation();
	}

}
