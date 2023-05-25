	package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.app.base.Base;

public class loginpage extends Base{

	//page-factory for login page or object repository

	@FindBy(name="email")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div[3]/div[1]/button")
	WebElement Signin;

	public loginpage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateloginPageTittl() {
		return driver.getTitle();
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Signin.click();

		return new HomePage();
	}
}

