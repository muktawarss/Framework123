package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataprovider {
	Properties prop;
	public ConfigDataprovider() {
	File file =new File("./Configuration/Confing.properties");
	try {
	FileInputStream fis=new FileInputStream(file);
	prop=new Properties();
	prop.load(fis);
	}
	catch (Exception e) {
		System.out.println("unable to load properties file"+e.getMessage());;
	}
	
	}

	private String getDataFromConfig(String keyToSearch) {
	return	prop.getProperty(keyToSearch);

	}

	public String getBrowser() {
	return	prop.getProperty("Browser");

	}

	public String getUrl() {
	return prop.getProperty("qaUrl");
	}
}
