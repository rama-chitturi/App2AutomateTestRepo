package com.test.runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"rerun:test-output/FailedScenarios/scenarios_failed.txt"},
		features={"src\\test\\resources\\Features"},
		glue="parallelfeatures",
		tags= "@RegressionTest")

public class A2ARunnerTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenrios()
	{
		return super.scenarios();
	}
	
}
