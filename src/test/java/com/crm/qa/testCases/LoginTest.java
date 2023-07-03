package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase{
LoginPage loginpage;
HomePage homepage;
public LoginTest()
{
	super();
}
@BeforeMethod
public void setUp()
{
	initialization();
	 loginpage=new LoginPage();
}

@Test(priority=1)
public void loginPageTitleTest()
{
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "#1 Free CRM App for every business CRM and VCM verifiable credentials management", "Title not found");
}
@Test(priority=2)
public void CRMLogoImageTest()
{
	boolean flag=loginpage.validateCRMLogo();
	Assert.assertTrue(flag);
}
@Test(priority=3)
public void loginTest()
{
	homepage=loginpage.Login(pro.getProperty("Username"), pro.getProperty("Password"));
}




@AfterMethod
public void tearDown()
{
	driver.quit();
}

}
