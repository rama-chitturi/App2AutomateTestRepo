package runnerFiles;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/bdd/featureFiles/AppFunctionality.feature"},
				 glue= {"stepDefinition"},
				 plugin= {"html:target/cuucmber_report"},
				 tags= {"~@canvasPage" , "@webPage1"}
				)
public class RunnerClass {

}
