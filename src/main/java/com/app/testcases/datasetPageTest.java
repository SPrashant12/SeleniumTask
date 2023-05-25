package com.app.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.base.Base;
import com.app.pages.HomePage;
import com.app.pages.datasetPage;
import com.app.pages.loginpage;

public class datasetPageTest extends Base{
	
	loginpage loginpage;
	HomePage homepage;
	datasetPage datasetpage;
	public datasetPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new loginpage();
		homepage = new HomePage();
		datasetpage = new datasetPage();
		homepage= loginpage.login(props.getProperty("username"), props.getProperty("password"));
	}
	@Test
	public void verifyNameDatasetTest() {
		Assert.assertTrue(datasetpage.verifyNameDataset(), "Dataset Name is not present"); ;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
