package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TLLoginHooks {


	RemoteWebDriver driver;

	@Before
	public void startup()
	{
		WebDriverManager.chromedriver().setup();
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

	@Before("@First")//tags
	public void firstScenario(Scenario sc)
	{//we can use scenario interface to get more details about the scenarios
		System.out.println("Before the first scenario");
		sc.getName();
		sc.getStatus();
		sc.getUri();
	}

	@After("@First")//tags
	public void afterFirstScenario()
	{ 
		System.out.println("After first scenario");
	}

	@Before("@Second")
	public void beforeSecond()
	{
		System.out.println("before second scenario");
	}

	@After("@Second")
	public void AfterSecond()
	{
		System.out.println("After Seocnd Scenario");
	}

	@BeforeStep()
	public void beforeSteps()
	{
		System.out.println("take screenshot or wait");
	}

	@AfterStep()
	public void afterStepscomplete()
	{
		System.out.println("refresh or verify result");
	}
}
