package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import com.main.GLOBAL;

import outputreports.Log;

public class Login_OPS_PI_Page {
	public static WebElement userid;
	public static WebElement password;
	public static WebElement accno;
	public static WebElement submitBtn;
	public static WebElement resetBtn;
	public static WebElement msgbox;
	
	
	public Login_OPS_PI_Page(String url) {
		try{
		GLOBAL.Driver.navigate().to(url);
		this.userid=GLOBAL.Driver.findElement(By.id("login_user_id"));
		this.password=GLOBAL.Driver.findElement(By.id("login_pw"));
		this.accno=GLOBAL.Driver.findElement(By.id("login_acct_num"));
		this.submitBtn=GLOBAL.Driver.findElement(By.id("btn-login-submit"));
		this.resetBtn=GLOBAL.Driver.findElement(By.id("btn-login-reset"));
		this.msgbox=GLOBAL.Driver.findElement(By.id("icp-message"));
		
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public boolean Login_OPS_PI_login(String UserId,String Password,String AccountNo) throws InterruptedException{
		boolean result = false;
		try{
		 this.userid.sendKeys(UserId);
		 this.password.sendKeys(Password);
		 this.accno.sendKeys(AccountNo);
		 this.submitBtn.click();
		 Thread.sleep(2000);
		 result=true;
		 GLOBAL.Driver.switchTo().parentFrame();
		 
		 }
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
       return result;
	}
	
	
	
	
}
