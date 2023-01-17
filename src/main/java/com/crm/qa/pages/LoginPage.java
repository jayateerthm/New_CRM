package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//span[contains(text(), 'Log In')]")
	WebElement Loginhomebtn;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath="(//a[contains(@title,'free crm home')])[1]")
	WebElement CRMlogo;

	// @FindBy(xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left
	// btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	// WebElement signUpbtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCRMLogo()
	{
		return CRMlogo.isDisplayed();
	}

	public HomePage Login(String un, String pwd) {
		Loginhomebtn.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}

	/*public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayateerth\\Desktop\\ChromeDriver_Sep\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.co.in/");
		String logoText = driver.findElement(By.xpath("(//div[@class='rd-navbar-brand']/a[@class='brand-name'])[1]"))
				.getText().trim();
		System.out.println(logoText);*/
	

}
