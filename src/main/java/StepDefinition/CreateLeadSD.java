package StepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadSD 
{
	WebDriver driver;


	@Given("Launch the leaf page")
	public void launch()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@And("Login the leaf page")
	public void login(DataTable table)
	{		

		for(Map<String, String> cred : table.asMaps())
		{
			driver.findElement(By.id("username")).sendKeys(cred.get("username"));
			driver.findElement(By.id("password")).sendKeys(cred.get("password"));
			driver.findElement(By.className("decorativeSubmit")).click();
		}

		//	Map<String, String> cred = (Map<String, String>) table.asMaps(String.class, String.class);
		//	for(int i = 0; i<= cred.size(); i++)
		//	{
		//		driver.findElement(By.id("username")).sendKeys(cred.get(i).get("username"));
		//		driver.findElement(By.id("password")).sendKeys(cred.get(i).get("password"));
		//	}

	}

	@When("Verify successfully login page")
	public void successfullyLogin()
	{
		String title= driver.getTitle();
		System.out.println("page title is :- "+title);
		Assert.assertEquals("wrong title", "Leaftaps - TestLeaf Automation Platform", title);	
	}

	@Then("click click crmsfa button")
	public void crmsfaButton()
	{
		driver.findElement(By.xpath("//div[@for=\"crmsfa\"]")).click();
	}

	@And("Verify crm main page")
	public void crmMainPage()
	{
		String usertitle = driver.findElement(By.xpath("//div[@class='insideHeaderText']//b")).getText().trim();
		System.out.println("Login user name is :"+usertitle);
		Assert.assertEquals("correct name", "demosalesmanager", usertitle);
	}

	@Then("Click Create Lead link")
	public void createLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Enter user details to create lead")
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

	@And("close the browser")
	public void tearDown()
	{
		driver.quit();
	}
}