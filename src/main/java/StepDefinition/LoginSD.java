package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import io.cucumber.datatable.*;

public class LoginSD 
{
	RemoteWebDriver driver;

	@Given("^navigate to login page$")
	public void homepage()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	/*
	@When("^enter \"(.*)\" and \"(.*)\"$")
	public void login_credential(String username, String password)
	{
		WebElement logo = driver.findElement(By.xpath("//img[contains(text(), logo)]"));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}*/

	@When("^enter username and password$")
	public void login_credential(DataTable credential)
	{	
		List<List<String>> data = credential.asLists(String.class);
		System.out.println("size is :"+data.size());
		driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
	}

	@And("^click login button$")
	public void submit_login()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("^page should login successfully$")
	public void successfullLogin()
	{
		String title= driver.getTitle();
		System.out.println("page title is :- "+title);
		Assert.assertEquals("wrong title", "Leaftaps - TestLeaf Automation Platform", title);
		//Assert.assertEquals("Leaftaps - TestLeaf Automation Platform", driver.getTitle().toString(), "wrong title");

	}

	@And("^verify crmsfa enter button$")
	public void verifyButton()
	{
		WebElement button =  driver.findElement(By.xpath("//input[@value='Logout']"));
		boolean logout = button.isDisplayed();
		Assert.assertEquals(true, logout);
	}

	@Then("^verify logout button$")
	public void verifyLogoutButton()
	{
		String text = driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("value");
		System.out.println("button name is :" +text);
		Assert.assertEquals( text, "Logout");
	}

	@And("^Close te browser$")
	public void closebrowser()
	{
		driver.close();
	}
}