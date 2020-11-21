package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "./src/main/java/Features/LoginHooks.feature",
		glue = {"StepDefinition"},
		monochrome = true,
		strict = true,
		plugin = {"html:test-output", "pretty"},
		dryRun = false
		)
public class LoginHooks extends AbstractTestNGCucumberTests {

}
