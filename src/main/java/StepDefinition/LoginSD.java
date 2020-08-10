package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSD 
{
	WebDriver driver;

	@Given("^navigate to login page$")
	public void homepage()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver84.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@When("^enter username \"(.*)\" and password \"(.*)\"$")
	public void login_credential(String username, String password)
	{
		WebElement logo = driver.findElement(By.xpath("//img[contains(text(), logo)]"));
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
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
//		Assert.assertEquals("Leaftaps - TestLeaf Automation Platform", driver.getTitle().toString(), "wrong title");

	}

	@And("^verify crmsfa enter button$")
	public void verifyButton()
	{
		WebElement button =  driver.findElement(By.xpath("//input[@value='Logout']"));
		boolean logout = button.isDisplayed();
		Assert.assertEquals(true, logout);
	}
	
	@And("^verify logout button$")
	public void verifyLogoutButton()
	{
		String text = driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("value");
		System.out.println("button name is :" +text);
		Assert.assertEquals( text, "Logout");
		driver.quit();
	}
}
