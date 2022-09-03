package com.practise.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting extends TestListenerAdapter implements ITestListener {

	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter htmlReporter;
	ExtentTest logger; 
	
	@Override
	public void onStart(ITestContext context)
	{ 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-"+timeStamp+".html";
		extent = new ExtentReports();
		htmlReporter = new ExtentSparkReporter(reportName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extend-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Rainbow Basic Testing");
		htmlReporter.config().setReportName("Rainbow Testing");
		}
	

	@Override
	public void onTestSuccess(ITestResult result) {
	
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	@Override
	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		logger.addScreenCaptureFromPath("./FailureScreenshots.png");
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	
	public void onFinish(ITestContext context) {
		logger = extent.createTest(context.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(context.getName(), ExtentColor.GREEN));
		extent.flush();
	}
}

