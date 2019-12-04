package com.automation.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.Pages.BaseClass;
import com.automation.Pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;

public class LoginTestBank extends BaseClass {
	ExcelDataProvider excel1 = new ExcelDataProvider();

	@Test
	public void loginApp() {

		logger = report.createTest("Login to guruBank");
		System.out.println(driver.getTitle());
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");

		loginpage.loginToGuruBank(excel.getStringData(0, 0, 0), excel1.getStringData(0, 0, 1));

		logger.pass("Loginning done successfully..");
	}

	/*
	 * @Test(priority=2) public void logoutApp() { logger =
	 * report.createTest("Login to guruBank");
	 * 
	 * LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	 * logger.info("starting application");
	 * 
	 * loginpage.loginToGuruBank(excel.getStringData(0, 0, 0),
	 * excel1.getStringData(0, 0, 1));
	 * 
	 * logger.fail("Logout Fail."); }
	 */
}
