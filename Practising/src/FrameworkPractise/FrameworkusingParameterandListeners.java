package FrameworkPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FrameworkusingParameterandListeners implements ITestListener {

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
		WebElement search = driver.findElement(By.xpath("//form[@id='quicksearch']/input"));
		search.sendKeys("CROXE-26051");
		search.submit();
	}
	
	@Test(dependsOnMethods = "jiralogin1")
	public void tempo() {
		String currentwindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		String newwindow = driver.getWindowHandle();
		driver.get("https://jira.ale-international.com/");
		WebElement search = driver.findElement(By.xpath("//form[@id='quicksearch']/input"));
		search.sendKeys("CROXE-26056");
		search.submit();
		
		/*
		 * WebElement tempoclick =
		 * driver.findElement(By.xpath("//a[@id='tempo_menu']")); tempoclick.click();
		 * WebElement selectdropdown = driver.findElement(By.id("timesheet-mlink_lnk"));
		 * selectdropdown.click();
		 */
		driver.switchTo().window(currentwindow);
	}
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Login & Search on Jira starts");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Login & Search on Jira success");
	}
	public void onStart(ITestContext context) {
		System.out.println("Login & Search on Jira begins");
	}
	public void onFinish(ITestContext context) {
		System.out.println("Login & Search on Jira finished");
	}
	
}
		
