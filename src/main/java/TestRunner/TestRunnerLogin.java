package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\eclipse\\workspace\\Cucumber\\src\\main\\java\\Features\\Login.feature",
glue={"StepDefinition"},
plugin= {"html:test-output", "pretty"},
dryRun = true,
monochrome = true, 
strict = true)

public class TestRunnerLogin extends AbstractTestNGCucumberTests 
{

	
}
