package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
@FindBy (name="username")
private WebElement userName;

@FindBy (name="password")
private WebElement password;

@FindBy (xpath="//input[@type=\"submit\"]")
private WebElement loginButton;

public void enterLoginName(String loginName){
	userName.sendKeys(loginName);
}
public void enterPassword(String loginPassword){
	password.sendKeys(loginPassword);
}

}
