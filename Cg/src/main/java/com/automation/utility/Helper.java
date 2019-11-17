package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		 String screenshootPath=System.getProperty("user.dir")+"./Screenshot/GuruBank_"+getCurrentTime()+".png";

		try {
			FileHandler.copy(src, new File(screenshootPath));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return screenshootPath;
	}

	public static String getCurrentTime() {
	
		Date date=new Date();
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH-mm-ss");
		
	return	customformat.format(date);
		
	}
	public void getFrame() {

	}

	public void switchAlert() {

	}
}
