package parallelfeatures;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:test-output/FailedScenarios/scenarios_failed.txt"},
features={"src\\test\\resources\\parallelfeatures"},
glue="parallelfeatures",
tags= "@RegressionTest")
public class ParallelRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	                 {
						return super.scenarios();
	                 }

}
