package com.practise.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.practise.pageObjects.loginElements;


public class loginPage extends baseClass {

	@Test
	public void loginTest() throws InterruptedException {
		// TODO Auto-generated method stub


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(BaseURL);
		logger.info("URL is entered successfully");		
		Thread.sleep(10000);
		PageFactory.initElements(driver, loginElements.class);
	
		Thread.sleep(5000);
		loginElements.userNameInput.sendKeys(userName);
		Thread.sleep(3000);
	    loginElements.continueButton.click();
		System.out.println("Rainbow Username entered successfully");
		Thread.sleep(3000);
		WebElement KeepAlive = driver.findElement(By.xpath("//div//input[@type='checkbox']"));
		System.out.println(KeepAlive.isSelected());
		Thread.sleep(2000);
		loginElements.passWordInput.sendKeys(passWord);
		Thread.sleep(2000);
		loginElements.loginButton.click();
		logger.info("logged in successfully");	
		
	}

}
