package StepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginHooksSD {
WebDriver driver;
	
	@Before
	public void startup()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver84.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@for=\"crmsfa\"]")).click();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("Click the Create Lead link")
	public void createLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@When("Enter the user details to create lead")
	public void enterLead(DataTable dt)
	{
		for(Map<String, String> data : dt.asMaps())
		{
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data.get("company_name"));
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data.get("first_name"));
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data.get("last_name"));
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(data.get("email"));
			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

			String name = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			System.out.println(name);
			Assert.assertEquals("correct name is :"+name, data.get("first_name"), name);
			
			driver.findElement(By.linkText("Create Lead")).click();
		}
	}
	
	@Then("logout the page")
	public void logout()
	{
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
