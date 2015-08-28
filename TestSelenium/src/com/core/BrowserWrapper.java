package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.ini4j.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import outputreports.Log;

public class BrowserWrapper {
public String BrowserType;
public WebDriver Driver;

	
	

public WebDriver startbrowser(String browser){

	Properties configprop = new Properties();
	
		/*configprop.load(new FileInputStream("src\\com\\config\\config.properties"));
		BrowserType = configprop.getProperty("BROWSERTYPE");*/
		BrowserType=browser;
		switch (BrowserType){
		case "firefox": 
			Driver = new FirefoxDriver();break;
		case "iexplore":
			System.setProperty("webdriver.ie.driver", "..\\TestSelenium\\externaldrivers\\32bit\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "..\\TestSelenium\\externaldrivers\\32bit\\chromedriver.exe");
			Driver = new ChromeDriver();break;
		case "other":
			break;
		
		}
			
		
		
		Log.info("Started webdriver for \"" + browser + "\" successfully");
		Reporter.log("Started webdriver for \"" + browser + "\" successfully",true);
		Driver.manage().window().maximize();
		
	return Driver;
	
}
	
}
