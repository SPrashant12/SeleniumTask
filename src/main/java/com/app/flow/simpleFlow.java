package com.app.flow;

import java.beans.BeanProperty;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class simpleFlow {

	public WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/am-pc-41/Downloads/chromedriver_linux64(1)/chromedriver");
		driver= new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://99flows.net/auth/login");
		Thread.sleep(3500);
		driver.findElement(By.name("email")).sendKeys("prashant@angularminds.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Demo@123");;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div[3]/div[1]/button")).click();
		
		Thread.sleep(4000);
	}

	@Test
	public void sampleFlow() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[1]/a[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("Selenium-Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/div[2]/textarea")).
		sendKeys("creating flow using selenium");
		Thread.sleep(2000);
		//		WebDriverWait wait = new WebDriverWait(driver, 15);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"drawer-root\\\"]/div/div[1]/"
		//				+ "div[1]/div/div/div/form/div[3]/div/div/div[1]/div[2]"))).sendKeys("Automatin");
		//		
		//		driver.findElement(By.xpath("//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/div[3]/div/div/div[1]/div[2]"))
		//	.sendKeys("Automatiom");
		//		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"drawer-root\"]/div/div[1]/div[1]/div/div/div/form/button[1]")).click(); // save flow
		Thread.sleep(2000);     

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/section/div[2]/span[1]/button")).click(); //Add field

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/"
				+ "section/div[2]/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("UserName"); // add field name
		Thread.sleep(3000);
		// dropdown to select field type
		WebElement dropdown =driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/section/div[2]/"
				+ "div[2]/div/form/div[1]/div/div[2]/select"));
		dropdown.click();
		
		//        Select dropDown =new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div"
		//        		+ "/section/div[2]/div[2]/div/form/div[1]/div/div[2]/select")));
		//		
		//		dropDown.selectByVisibleText("ShortText");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/section/div[2]/div[2]/div/form/a")).click();//click on validation
		Thread.sleep(2000);
		driver.findElement(By.name("metaData.minLength")).sendKeys("2");
		Thread.sleep(2000);
		driver.findElement(By.name("metaData.maxLength")).sendKeys("8");
		Thread.sleep(4000);
		
        driver.findElement(By.cssSelector("#root > div.d-flex > div.flex-grow-1.px-5.px-xl-3.py-5"
        		+ ".form-view-edit > div > div > div > section > div.form-element.mb-3."
        		+ "form-element-edit-mode.card > div.card-body > div > form >"
        		+ " div.row.align-items-center.border-top.pt-3.mt-3 > div.col-6.text-right > div > label")).click();//click on required
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#root > div.d-flex > div.flex-grow-1.px-5.px-xl-3.py-5.form-view-edit > div > "
        		+ "div > div > section > div.form-element.mb-3.form-element-edit-mode.card > div"
        		+ ".card-body > div > form > div.row.align-items-center.border-top.pt-3.mt-3 > "
        		+ "div:nth-child(1) > button.btn.btn-brand.btn")).click();
        Thread.sleep(2000);
        
        // ADD second field
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/section/div[2]/span[1]/button")).click(); 
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/"
//				+ "section/div[2]/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("setpassword"); // add field name
//		Thread.sleep(3000);
		//add  radio box
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/section/div[2]/span[1]/button")).click(); ////Add field
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/"
					+ "section/div[2]/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("setpassword"); // add field name
			Thread.sleep(3000);
			//select field type
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div/div/se"
				+ "ction/div[3]/div[2]/div/form/div[1]/div/div[2]/select")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
