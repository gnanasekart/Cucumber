package com.org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.org.qa.base.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(how=How.ID, using="username")
	WebElement username;

	@FindBy(how=How.ID, using = "password")
	WebElement password;

	@FindBy(how=How.CLASS_NAME, using="decorativeSubmit")
	WebElement loginbtn;

	@FindBy(how=How.XPATH, using="//div[@for=\"crmsfa\"]")
	WebElement crmsfabtn;

	@FindBy(how=How.XPATH, using="//div[@id='logo']//img")
	WebElement logo;

	@FindBy(how=How.XPATH, using="//h2[contains(.,'Demo Sales Manager')]")
	WebElement loginname;

	@FindBy(how=How.XPATH, using="//b[text()='demosalesmanager']")
	WebElement loginusername;

	@FindBy(how=How.XPATH, using="//a[text()='Logout']")
	WebElement logout;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void title()
	{
		String pagetitle = driver.getTitle();
		Assert.assertEquals(pagetitle, "Leaftaps - TestLeaf Automation Platform", "Page Title does not match");
	}

	public void verifyLogo()
	{
		boolean value =  logo.isDisplayed();
		Assert.assertTrue(value, "logo not visible");
	}

	public CreateLeadPage landPage(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		loginbtn.click();
		
		//Assert.assertTrue(logo.isDisplayed(), "not displayed");
		String loginuname = loginusername.getText();
		System.out.println("username is :"+loginuname);
	//	Assert.assertEquals("Demo Sales Manager", loginuname, "wrong name");

		crmsfabtn.click();
		return new CreateLeadPage();
	}

	public LoginPage verifyusername()
	{
		String mainpageusername = loginusername.getText();
		System.out.println("main page user name is :"+mainpageusername);
		Assert.assertEquals("demosalesmanager", mainpageusername, "wrong user name in main page");
		return this;
	}
	
	public LoginPage userLogout()
	{
		logout.click();
		return this;
	}
}
