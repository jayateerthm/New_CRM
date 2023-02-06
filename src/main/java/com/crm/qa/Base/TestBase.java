package com.crm.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties pro;
	
	public TestBase() {
		try {
			pro=new Properties();
			FileInputStream fi=new FileInputStream("E:\\Workspaces\\Java-Workspace\\PageObjectModel_Demo\\src\\main\\java\\com\\crm\\qa\\config\\config.property");
			pro.load(fi);
		} catch (Exception e) {
			
		}
	}
	
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		String browserName=pro.getProperty("browser");
	
		if(browserName.equals("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "./PageObjectModel_Demo/src/test/resources/gechodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait_Time, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		
	}
}
