package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
//This is new code added by sada
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		
	}

	@FindBy(name = "uid")
	WebElement userID;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	@FindBy(name = "btnReset")
	WebElement resetBtn;

	public void loginToGuruBank(String username, String pass) {
		userID.sendKeys(username);
		password.sendKeys(pass);
		loginBtn.click();
	}
}
