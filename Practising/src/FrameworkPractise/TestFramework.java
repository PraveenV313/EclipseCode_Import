package FrameworkPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestFramework {

	WebDriver driver;
	@BeforeTest
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prave\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	@Parameters({"username", "password"})
	public void jiralogin1(String uname, String pword) {
		driver.get("https://jira.ale-international.com/login.jsp");
		WebElement username = driver.findElement(By.xpath("//input[@id='login-form-username']"));
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id, 'login-form-pass')]"));
		password.sendKeys(pword);
		WebElement login = driver.findElement(By.xpath("//input[contains(@name, 'login')]"));
		login.click();
	}
	
	@Test(dependsOnMethods = "jiralogin1")
	public void tempo() {
		WebElement tempoclick = driver.findElement(By.xpath("//a[@id='tempo_menu']"));
		tempoclick.click();
		WebElement selectdropdown = driver.findElement(By.id("timesheet-mlink_lnk"));
		selectdropdown.click();
		//Select dropdowntempo = new Select(selectdropdown);
		//dropdowntempo.selectByIndex(0);
		
	}
		
	

}
