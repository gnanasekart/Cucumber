package MyTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "path/Features",
			glue = {"stepDefinitions"},
			tags = {"~@Ignore"},
			plugin = {"pretty",
			"html:target/cucumber-reports/cucumber-pretty",
			"json:target/cucumber-reports/CucumberTestReport.json",
			"rerun:target/cucumber-reports/rerun.txt"}
			//plugin = "json:target/cucumber-reports/CucumberTestReport.json"
			)

			public class TestRunner
			{
			private TestNGCucumberRunner testNGCucumberRunner;

			@BeforeClass(alwaysRun = true)
			public void setUp()
			{
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
			}

			@Test(groups = "cucumber", description = "Runs cucumber Feature", dataProvider = "features")
			public void feature(CucumberFeatureWrapper cucumberFeature)
			{
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
			}

			@DataProvider
			public Object[][] features()
			{
			if(testNGCucumberRunner == null)
			{
			return new Object[0][0];
			}
			return testNGCucumberRunner.provideFeatures();
			}

			@AfterClass(alwaysRun = true)
			public void tearDownClass() 
			{if(testNGCucumberRunner == null)
			{
			return;
			}
			testNGCucumberRunner.finish();
			}
			}


