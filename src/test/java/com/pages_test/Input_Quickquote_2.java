package com.pages_test;

import org.testng.annotations.Test;

import com.quickquote2.Saver.base;
import com.pages.*;

public class Input_Quickquote_2 extends base{

	  @Test
	    public void openDashboard() {
		  	String actualTitle = driver.getTitle();
	        System.out.println("Page title: " +actualTitle);	        
	        
	        test.get().info("Actual page title : " + actualTitle);
	        test.get().info("Actual page title : "+ actualTitle);
	        
	        String expectedTitle ="Pru-Dashboard";
	        
	        if(actualTitle.equals(expectedTitle)) {
	        	test.get().pass("page title matched "+ actualTitle);	
	        }else {
	        	test.get().fail( "Page title expected was -"+expectedTitle);
	        }
	    }
	  @Test
	  
	  public void login_Dashboard(){
		  test.get().info("Starting Dashboard login test");
		  
		
		  Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop);
		  
		  loginPage.enterUser();
		  test.get().info("Entered email from config.properties");
		  
	        loginPage.enterCapcha();
	        test.get().info("Entered captcha automatically");


	        loginPage.submitOTP();
	        test.get().info("Clicked Send OTP button");

	       String actualTitle = driver.getTitle();
	        String expectedTitle = "Pru-Dashboard";
	        
	        loginPage.EnterOtp();
	        test.get().info("Otp submit successfully");

	        if (actualTitle.equals(expectedTitle)) {
	            test.get().pass("Login successful, landed on Dashboard page with title: " + actualTitle);
	        } else {
	            test.get().fail("Login failed. Expected: " + expectedTitle + " but found: " + actualTitle);
	        }
	    }
}
