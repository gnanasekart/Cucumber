package com.org.qa.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/com/org/qa/features/CreateLead.feature",
glue= {"com/qa/org/stepDefinitions"},
monochrome = true,
strict = true,
plugin = {"html:target", "pretty"},
dryRun = true		)

public class CreateLeadTR extends AbstractTestNGCucumberTests
{

}
