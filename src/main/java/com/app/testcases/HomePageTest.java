package com.app.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.base.Base;
import com.app.pages.HomePage;
import com.app.pages.datasetPage;
import com.app.pages.flowsPage;
import com.app.pages.loginpage;
import com.app.util.Testutils;

public class HomePageTest extends Base{
	loginpage loginpage;
	HomePage homepage;
	flowsPage flowpage;
	datasetPage datasetpage;

	String sheetName= "Sheet1";
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new loginpage();
		flowpage = new flowsPage();
		homepage = loginpage.login(props.getProperty("username"), props.getProperty("password"));
	}

	@Test(priority = 1)
	public void HomePagetitleTest() {
		String homepagetitle= homepage.gettitile();
		Assert.assertEquals(homepagetitle, "99 Flows", "Home page title is wrong");

	}
	@Test(priority = 2)
	public void verifyHomepageInboxTest() {
		Assert.assertTrue( homepage.verifyHomepageinbox());
	}

	@Test(priority = 3)
	public void clickonFlowsTest() {
		flowpage= homepage.ClickOnFlows();
	}
	@Test(priority = 4)	
	public  void clickOnDatasetTest() {
		datasetpage= homepage.ClickOnDataset();
	}
		@Test(priority = 5)
		public void verifyProfileImageTest() {
			homepage.verifyProfileImage();
		}
	
	@DataProvider
	public Object[][] getflowNameTest() {
		Object[][] data= Testutils.getTestdata(sheetName);
        return data;
	}
	
	@Test(priority = 6, dataProvider = "getflowNameTest")
	public void createFlowTest(String flowname, String description) throws InterruptedException {
		homepage.clickonCreateFlow();
		homepage.verifyClickOnCreateyourFlow();
	//	homepage.createFlow("Qa-Demo", "for testing automation");
		homepage.createFlow(flowname, description);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
