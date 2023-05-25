package com.app.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.util.Testutils;

public class Base {

	public static WebDriver driver;
	public static Properties props;

	public Base(){

		try {
			props = new Properties();
			FileInputStream ip = new FileInputStream("/home/am-pc-29/Am-pc-Backup/eclipse-workspace/99flows/src/main/java/com/app/config/config.properties"); 
			props.load(ip);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser= props.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/am-pc-29/Downloads/chromedriver_linux64/chromedriver");
			driver= new ChromeDriver();
		}else if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","/home/am-pc-29/Downloads/chromedriver_linux64/geckodriver");
			driver= new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutils.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutils.implicit_wait, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}
}
