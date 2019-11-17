package com.automation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataprovider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ConfigDataprovider config;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataprovider();

		Reporter.log("setting up report is ready", true);
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Report/GuruBank_" + Helper.getCurrentTime() + ".html"));
		Reporter.log("Setting is done -test Can be statred", true);
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startBrowser(driver, config.getBrowser(), config.getUrl());
		Reporter.log("Browser and application is up and running", true);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				logger.fail("Test failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

			} else if (result.getStatus() == ITestResult.SUCCESS) {

				logger.pass("Test passed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		report.flush();

		Reporter.log("Report  is done->Test is completed", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

}
