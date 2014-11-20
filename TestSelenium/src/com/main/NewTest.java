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
import com.gui.guiwin;
import com.utility.Excelutils;

public class NewTest {
	BrowserWrapper DriverMain = new BrowserWrapper();
	WebDriver Driver;
	public static Properties configprop= new Properties();
	guiwin windowst = new guiwin();

	  
  @Test
  public void homepage() throws InterruptedException {
	 
		Thread.sleep(2000);
	
	  Excelutils ex= new Excelutils();
	  System.out.println(ex.readdatafromxl("homepage", "pathtype", 2));
  }
  
  
  

  @Parameters("browser")
  
  @BeforeClass
  public void beforeClass(String browser) throws FileNotFoundException, IOException, InterruptedException {
	  DOMConfigurator.configure("log4j.xml");
	  windowst.createstatusbox("Here we go :)");
	  
	  try{
	  windowst.changestatus("trying to open browser");
	  Driver = DriverMain.startbrowser(browser.toString());
	  configprop.load(new FileInputStream("src\\com\\config\\config.properties"));
	  
	  Driver.get(configprop.getProperty("DEFAULTURL"));
	  Driver.manage().window().maximize();
	  windowst.changestatus("Started webdriver for \"" + browser + "\" successfully");
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
	  try{
	 windowst.changestatus("Closing webdriver.");
	  Driver.close();
	  Driver.quit();
	  
	  Log.error("Closed webdriver");
	  Reporter.log("Closed webdriver");
	  }
	  catch(Exception e){
		  windowst.changestatus("Unable to close webdriver. ERROR : " + e.getMessage());
		  Log.error("Unable to close webdriver. ERROR : " + e.getMessage());
		  Reporter.log("Unable to close webdriver. ERROR : " + e.getMessage(),true);
		  }
	  
  }

}
