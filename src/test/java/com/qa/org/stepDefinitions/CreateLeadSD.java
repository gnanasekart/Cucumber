package com.qa.org.stepDefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.org.qa.base.TestBase;
import com.org.qa.pages.CreateLeadPage;
import com.org.qa.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CreateLeadSD extends TestBase{

	WebDriver driver;
	//TestBase base;
	LoginPage loginPage = new LoginPage();
	CreateLeadPage clpage = new CreateLeadPage();

	@Before
	public void startup()
	{
		TestBase.Initialize();
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

	@Given("Click the Create Lead link")
	public void createLead()
	{
		clpage.cLeadPage();
	}

	@When("Enter the user details to create lead")
	public void enterLead(DataTable dt)
	{
		for(Map<String, String> data : dt.asMaps())
		{
			clpage.enterCompanyname(data.get("company_name"));
			String fname = data.get("first_name").trim();
			clpage.enterfname(data.get("first_name"));
			clpage.enterlname(data.get("last_name"));
			clpage.enterEmail(data.get("email"));
			clpage.enterPhno(data.get("phone"));
			clpage.submitCLForm();

			clpage.verifyFirstName(fname);

			clpage.cLeadPage();

			//			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data.get("company_name"));
			//			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data.get("first_name"));
			//			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data.get("last_name"));
			//			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(data.get("email"));
			//			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
			//			String name = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			//			System.out.println(name);
			//			Assert.assertEquals("correct name is :"+name, data.get("first_name"), name);
			//			driver.findElement(By.linkText("Create Lead")).click();
		}
	}

	@Then("logout the page")
	public void logout()
	{
		loginPage.userLogout();
	}
}
