package com.practise.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.practise.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	readConfig readconfig = new readConfig();
	
	
	 WebDriver driver;
	 public String BaseURL = readconfig.getURL();
	 String userName = readconfig.userName();
	 String passWord = readconfig.passWord();
	 Logger logger;
	
	@Parameters("Browser")
	@BeforeClass
	public void browserSetup(String browser) {
		
		logger=Logger.getLogger(baseClass.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
	
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		}
		
	

	}
	
	@AfterClass
	public void quitBrowser() {
		//driver.quit();
	}
	
	public void captureScreen(WebDriver driver) {
	TakesScreenshot ss = (TakesScreenshot) driver;
	File srcFile = ss.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./FailureScreenshots.png");
	try {
		FileHandler.copy(srcFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

}
