package com.app.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.Base;

public class HomePage extends Base{

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[1]/div[1]/h1")
	WebElement inbox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/ul[1]/li[2]/a/i")
	WebElement flows;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/ul[1]/li[3]/a/i")
	WebElement dataset;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/ul[2]/li[3]/div/a/div/img")
	WebElement profileimg;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[1]/a[1]/i")
	WebElement createFlow;
	
	@FindBy(xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div[1]/div/div/div/button")
	WebElement createyourFlow;
	                  //*[@id="drawer-root"]/div/div[1]/div[1]/div/div/div/form/div[1]/input
	@FindBy(xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/div[1]/input")
	WebElement flowname;
	
	@FindBy(xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/div[2]/textarea")
	WebElement description;
	
	@FindBy(xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/button[1]")
	WebElement saveButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
   public String gettitile() {
	   return driver.getTitle();
   }
 
    public void verifyProfileImage() {
    	 Boolean ImgPresent =  (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof "
    	 		+ "arguments[0].naturalWidth "
    	 		+ "!= \"undefined\" && arguments[0].naturalWidth > 0", profileimg);
    	 if(!ImgPresent) {
    		 System.out.println("Image not displayed");
    	 }else {
    		 System.out.println("image displayed");
    	 }
    }
    
   public boolean verifyHomepageinbox() {
	   return inbox.isDisplayed();
   }
   
   public flowsPage ClickOnFlows() {
	   flows.click();
	   return new flowsPage();
   }
   
   public datasetPage ClickOnDataset() {
	   dataset.click();
	   return new datasetPage();
   }
   
   public void clickonCreateFlow() {
	   createFlow.click();
   }
   
   public void verifyClickOnCreateyourFlow() {
	   createyourFlow.click();
   }
   
   public void createFlow(String Fname, String desc) {
	   flowname.sendKeys(Fname);
	   description.sendKeys(desc);
	   saveButton.click();   
   }
}
