package com.qa.org.stepDefinitions;

import com.org.qa.base.TestBase;
import com.org.qa.pages.CreateLeadPage;
import com.org.qa.pages.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSD extends TestBase
{
	//WebDriver driver;
	TestBase base;
	LoginPage loginPage = new LoginPage();
	CreateLeadPage clpage = new CreateLeadPage();	

	public LoginSD()
	{
		super();
	}
	
	@Given("Navigate to the website")
	public void enterIntoWebsite()
	{
		TestBase.Initialize();
	}
	
	@And("verify the page logo")
	public void verifyLogo()
	{
		System.out.println("sss");
	//loginPage.verifyLogo();
	}
	
	@When("login into the website")
	public void login()
	{
		clpage = loginPage.landPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Then("verify the pagetitle")
	public void verifyUsername()
	{
		loginPage.verifyusername();
	}
	}