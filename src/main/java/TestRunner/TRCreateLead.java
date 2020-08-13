package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "D:\\eclipse\\workspace\\Cucumber\\src\\main\\java\\Features\\CreateLead.feature",
glue= {"StepDefinition"},
plugin = {"html:test-output", "pretty"},
monochrome = true,
strict = true,
dryRun = false,
tags = {"not @Smoketestcase"})

public class TRCreateLead extends AbstractTestNGCucumberTests {

}
