package com.org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.org.qa.base.TestBase;

//import junit.framework.Assert;

public class CreateLeadPage extends TestBase
{

	@FindBy(how=How.LINK_TEXT, using="Create Lead")
	WebElement createleadbtn;

	@FindBy(how=How.ID, using="sectionHeaderTitle_leads")
	WebElement createleadpagename; 

	@FindBy(how=How.ID, using="createLeadForm_companyName")
	WebElement companyname;

	@FindBy(how=How.ID, using="createLeadForm_firstName")
	WebElement firstname;

	@FindBy(how=How.ID, using="createLeadForm_lastName")
	WebElement lastname;

	@FindBy(how=How.ID, using="createLeadForm_primaryEmail")
	WebElement email;

	@FindBy(how=How.ID, using="createLeadForm_primaryPhoneNumber")
	WebElement phnumber;

	@FindBy(how=How.XPATH, using="//input[@class='smallSubmit']")
	WebElement submitformbtn;

	@FindBy(how=How.ID, using="viewLead_firstName_sp")
	WebElement verifyname;

	@FindBy(how=How.LINK_TEXT, using="Find Leads")
	WebElement findleadbtn;

	public CreateLeadPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void cLeadPage()
	{
		createleadbtn.click();
		String pagename = createleadpagename.getText();
		Assert.assertEquals(pagename, "Create Lead", "wrong page title");
	}

	public CreateLeadPage enterCompanyname(String cname)
	{
		clearAndType(companyname, cname);
		return this;
	}

	public CreateLeadPage enterfname(String fname)
	{
		clearAndType(firstname, fname);
		return this;
	}

	public CreateLeadPage enterlname(String lname)
	{
		clearAndType(lastname, lname);
		return this;
	}

	public CreateLeadPage enterEmail(String mail)
	{
		clearAndType(email, mail);
		return this;
	}

	public CreateLeadPage enterPhno(String phno)
	{
		clearAndType(phnumber, phno);
		return this;
	}

	public CreateLeadPage submitCLForm()
	{
		submitformbtn.click();
		return this;
	}

	public CreateLeadPage verifyFirstName(String fname)
	{
		String firstname = verifyname.getText();
		System.out.println("User first name is :"+firstname);
		Assert.assertEquals(firstname, fname, "correct first name");	
		return this;
	}

	public FindLeadPage findLead()
	{
		findleadbtn.click();
		return new FindLeadPage();
	}	
}

