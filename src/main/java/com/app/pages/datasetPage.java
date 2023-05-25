package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.Base;

public class datasetPage extends Base{

	public datasetPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div[1]/div/h1")
	WebElement Namedataset;
		
	public boolean verifyNameDataset() {
		 return Namedataset.isDisplayed();
	}
}
