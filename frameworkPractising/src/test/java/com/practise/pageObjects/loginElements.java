package com.practise.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginElements {

	
	@FindBy(id="username")
	public static WebElement userNameInput;
	
	@FindBy(xpath="//div//button//span[text()='Continue']")
	public static WebElement continueButton;
	
	@FindBy(xpath="//div//input[@name=\"authPwd\"]")
	public static WebElement passWordInput;
	
	@FindBy(xpath="//div//button//span[text()='Connect']")
	public static WebElement loginButton;
	
}
