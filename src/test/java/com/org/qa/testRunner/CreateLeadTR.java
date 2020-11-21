package com.org.qa.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "D:\\eclipse\\workspace\\Cucumber\\src\\test\\java\\com\\org\\qa\\features\\CreateLead.feature",
glue= {"com/qa/org/stepDefinitions"},
monochrome = true,
strict = true,
plugin = {"html:target", "pretty"},
dryRun = false		)

public class CreateLeadTR extends AbstractTestNGCucumberTests
{

}
