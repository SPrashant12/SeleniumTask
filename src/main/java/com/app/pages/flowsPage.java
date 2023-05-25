package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.Base;

public class flowsPage extends Base{

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/ul[1]/li[2]/a/i")
	WebElement clickFlow;

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[1]/div/h1")	                 
	WebElement Nameflows;

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[1]/div/div/a")
	WebElement createFlow;

	@FindBy(xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div[1]/div/div/div/h5")
	WebElement NameCreateYourFlow;

	public flowsPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyClickonFlows() {
		clickFlow.click();
	}
	
	public boolean verifyNameFlow() {
		return Nameflows.isDisplayed();
	}

	public void verifyClickOnCreateflow() {
		createFlow.click();
	}

	public boolean verifyCreateFlowName() throws InterruptedException {
		return NameCreateYourFlow.isDisplayed();
	}
	
}
