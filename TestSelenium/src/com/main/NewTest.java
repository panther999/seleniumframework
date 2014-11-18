package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.core.BrowserWrapper;

public class NewTest {
	BrowserWrapper DriverMain = new BrowserWrapper();
	WebDriver Driver;
	Properties config;

	  
  @Test
  public void f() {
  }
  
  
  

  @Parameters("browser")
  
  @BeforeClass
  public void beforeClass(String browser) throws FileNotFoundException, IOException {
	  Driver = DriverMain.startbrowser(browser.toString());
	  Properties configprop = new Properties();
	  configprop.load(new FileInputStream("src\\com\\config\\config.properties"));
	  Driver.get(configprop.getProperty("DEFAULTURL"));
	  Driver.manage().window().maximize(); 
  }

  @AfterClass
  public void afterClass() {
  }

}
