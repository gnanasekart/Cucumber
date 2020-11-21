package com.org.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static RemoteWebDriver driver;
	public static Properties prop;

	public TestBase() 
	{
		prop = new Properties();
		FileInputStream file;
		try 
		{
		file = new FileInputStream("D:\\eclipse\\workspace\\Cucumber\\src\\test\\java\\com\\org\\qa\\config\\config.properties");
		prop.load(file);
		}
		catch (FileNotFoundException e1) 
		{	
			e1.printStackTrace();
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}

	public static void Initialize()
	{
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		driver.get(prop.getProperty("url"));
	}

	public void clearAndType(WebElement ele, String data)
	{
		try 
		{
			ele.clear();
			ele.sendKeys(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
