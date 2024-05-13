package com.test.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:test-output/FailedScenarios/sceanrios_failed.txt"},
				features="@test=output/FailedScenarios/scenarios_failed.txt",
				glue="com.stepDefinitions")
public class ReRunFailedCases extends AbstractTestNGCucumberTests  {
	
	

}
