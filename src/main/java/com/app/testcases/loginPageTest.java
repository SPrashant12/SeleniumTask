package com.app.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.HomePage;
import  com.app.pages.loginpage;
import com.app.base.Base;

public class loginPageTest extends Base{
    loginpage loginpage;
    HomePage homepage;
    
	public loginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new loginpage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest() { 
		String title = loginpage.ValidateloginPageTittl();
		Assert.assertEquals(title, "99 Flows");
	}
	@Test(priority = 2)
	public void loginTest() {
		homepage = loginpage.login(props.getProperty("username"), props.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
