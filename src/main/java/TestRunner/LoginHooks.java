package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "./src/main/java/Features/LoginHooks.feature",
		glue = {"StepDefinition", "TLLoginHooks"},//we now metoned stepdefinition for scenario and hooks file details also
		monochrome = true,
		strict = true,
		plugin = {"html:test-output", "pretty"},
		dryRun = false,
		tags = "@first" // tags = "@first or @second"
		)
public class LoginHooks extends AbstractTestNGCucumberTests {

}
