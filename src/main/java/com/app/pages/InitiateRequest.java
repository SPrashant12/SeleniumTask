package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.base.Base;

public class InitiateRequest extends Base{

	@FindBy (xpath = "//*[@id=\"root\"]/div[2]/div[1]/ul[1]/li[5]/a/i")
	WebElement initiaterequest;
	
	@FindBy (name = "name")
	WebElement search;
	
	@FindBy (xpath = "//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div[3]/div/div[2]/div/div/div/strong")
	WebElement FlowName;
}
