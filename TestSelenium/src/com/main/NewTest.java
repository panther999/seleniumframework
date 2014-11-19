package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import outputreports.Log;

import com.core.BrowserWrapper;

public class NewTest {
	BrowserWrapper DriverMain = new BrowserWrapper();
	WebDriver Driver;
	public static Properties configprop= new Properties();

	  
  @Test
  public void homepage() {
	  
	  
  }
  
  
  

  @Parameters("browser")
  
  @BeforeClass
  public void beforeClass(String browser) throws FileNotFoundException, IOException {
	  DOMConfigurator.configure("log4j.xml");
	  try{
	  Driver = DriverMain.startbrowser(browser.toString());
	  configprop.load(new FileInputStream("src\\com\\config\\config.properties"));
	  Driver.get(configprop.getProperty("DEFAULTURL"));
	  Driver.manage().window().maximize();
	  Log.info("Started webdriver for \"" + browser + "\" successfully");
	  Reporter.log("Started webdriver for \"" + browser + "\" successfully",true);
	  }
	  catch(Exception e){
	  Log.error("Unable to start webdriver. ERROR : " + e.getMessage());
	  Reporter.log("Unable to start webdriver. ERROR : " + e.getMessage(),true);
	  }
  }

  @AfterClass
  public void afterClass() {
	  Driver.close();
	  Driver.quit();
  }

}
