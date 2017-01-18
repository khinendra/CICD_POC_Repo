package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateLogin {
	WebDriver driver;

@Test
public void testLogin() {
	WebElement userText = driver.findElement(By.name("username"));
	WebElement passwordText = driver.findElement(By.name("password"));
	WebElement submit = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
	userText.sendKeys("admin");
	passwordText.sendKeys("admin");
	submit.click();
}
@BeforeTest
public void beforeTest() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/WebExample/");
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
