package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	System.out.println("Starting test1 2 3 4");
	
	String jenUsername=System.getProperty("username");
	String jenPassword=System.getProperty("password");
	
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
	String appURL=System.getProperty("app.url");
	String driverLocation=System.getProperty("driver.location");
	String env = System.getProperty("app.environment");
	File file = new File(env+"-config.conf");
	System.out.println(file.getAbsolutePath());
	String appURL2=null;
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	//load properties file
	try {
		prop.load(fileInput);
		appURL2=prop.getProperty("application.url");
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("App URl :"+appURL);
	System.out.println("driver and config file Location :"+driverLocation+"&"+env);
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(appURL2);
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
