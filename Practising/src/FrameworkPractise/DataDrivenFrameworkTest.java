package FrameworkPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenFrameworkTest implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Login & Search on Jira starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Login & Search on Jira success");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Login & Search on Jira begins");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Login & Search on Jira finished");
	}

	String[][] data = { { "pvelusam", "Prvn@31031997" }, { "kthayuma", "Kannagi!004" } };

	WebDriver driver;

	@DataProvider(name = "jiratest")
	public String[][] dataprovide() {
		return data;
	}
	
	@Test(dataProvider="jiratest")
	public void jiralogin1(String uname, String pword) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prave\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jira.ale-international.com/login.jsp");
		WebElement username = driver.findElement(By.xpath("//input[@id='login-form-username']"));
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id, 'login-form-pass')]"));
		password.sendKeys(pword);
		WebElement login = driver.findElement(By.xpath("//input[contains(@name, 'login')]"));
		login.click();
		driver.quit();
		/*
		 * WebElement search =
		 * driver.findElement(By.xpath("//form[@id='quicksearch']/input"));
		 * search.sendKeys("CROXE-26051"); search.submit();
		 */
	}


}
