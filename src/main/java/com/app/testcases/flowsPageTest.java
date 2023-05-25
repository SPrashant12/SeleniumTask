package com.app.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.base.Base;
import com.app.pages.HomePage;
import com.app.pages.flowsPage;
import com.app.pages.loginpage;

public class flowsPageTest extends Base{
   
	loginpage loginpage;
	flowsPage flowpage;
	HomePage homepage;

	public flowsPageTest() {
	 super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new loginpage();
	    homepage = new HomePage();
	    flowpage = new flowsPage();
		homepage= loginpage.login(props.getProperty("username"), props.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void clickonFlowsTest() {
		 flowpage.verifyClickonFlows();
	}
	
	@Test(priority = 2)
	public void verifyNameflowTest()  { 
		flowpage.verifyClickonFlows();
     Assert.assertTrue(flowpage.verifyNameFlow(), "Name is not present");  	
	}
	@Test(priority = 3)
	public void verifyClickOnCreateFlowTest() throws InterruptedException {
		flowpage.verifyClickonFlows();
		Thread.sleep(3000);
		flowpage.verifyClickOnCreateflow();
		
	}
	@Test(priority = 4)
	public void verifycreateFlowNameTest() throws InterruptedException {
		flowpage.verifyClickonFlows();
		flowpage.verifyClickOnCreateflow();
		Thread.sleep(3000);
		Assert.assertTrue(flowpage.verifyCreateFlowName(), "Create Flow Name is not displayed"); 
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
