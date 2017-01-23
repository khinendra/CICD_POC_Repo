package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidateLogin {
	WebDriver driver;

@Test
@Parameters({"user","password"})
public void testLogin(String user, String password) {
	System.out.println("Starting test1 2 3");
	String appURL=System.getProperty("app.url");
	String driverLocation=System.getProperty("driver.location");
	String jenUsername=System.getProperty("username");
	String jenPassword=System.getProperty("password");
	String confFile = System.getProperty("conf.file");
	System.out.println("App URl :"+appURL);
	System.out.println("driver and config file Location :"+driverLocation+"&"+confFile);
	System.out.println("Jenkins UserName & password is:"+jenUsername+"&"+jenPassword);
	
	WebElement userText = driver.findElement(By.name("username"));
	WebElement passwordText = driver.findElement(By.name("password"));
	WebElement submit = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
	userText.sendKeys(user);
	passwordText.sendKeys(password);
	submit.click();
}
@BeforeTest
@Parameters({"url"})
public void beforeTest(String url) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
}

@AfterTest
public void afterTest() {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
	driver.close();
}
}
