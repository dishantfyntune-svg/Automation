package com.pages_test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Saver.base;
import pages.Dashbord_login_page;

public class Input_Quickquote_2 extends base{

    private WebDriverWait wait  ;

    @Test (priority = 1)
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
	  @Test(priority = 2)
	  
	  public void login_Dashboard(){
		  test.get().info("Starting Dashboard login test");


		  Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop, wait);
		  
		  loginPage.enterUser();
		  test.get().info("Entered email from config.properties");

          loginPage.enterPassword();
            test.get().info("Entered password from config.properties");
		  
	      //  loginPage.enterCapcha();
	       // test.get().info("Entered captcha automatically");
        loginPage.Check_box_RBOT();
        test.get().info("Checked RBOT checkbox");

        loginPage.Check_Terms_and_condition();

        /*  if (loginPage.CheckLogoDis() ){
              test.get().pass("Logo is displayed");
          }else {
              test.get().fail( "Logo is not displayed");
          }*/
	        loginPage.submitOTP();
	        test.get().info("Clicked Send OTP button");

	       String actualTitle = driver.getTitle();
	        String expectedTitle = "Pru-Dashboard";
	        
	        loginPage.EnterOtp();
	        test.get().info("Otp submit successfully");

            loginPage.VerifyOtp();
            test.get().info("Otp verification successful");

	        if (actualTitle.equals(expectedTitle)) {
	            test.get().pass("Login successful, landed on Dashboard page with title: " + actualTitle);
	        } else {
	            test.get().fail("Login failed. Expected: " + expectedTitle + " but found: " + actualTitle);
	        }
	    }
        @Test(priority = 3)
        public void check_captcha(){
                    test.get().info("Checking Captcha automatically clickable");
                    Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop, wait);

                    loginPage.enterUser();
                    test.get().info("User name entered");

                    loginPage.enterPassword();
                    test.get().info("Password entered");

                    loginPage.CheckCaptcha();
                    test.get().info("Captcha check successfully");

                    loginPage.enterCapcha();
                    test.get().info("Captcha check successfully");

                    loginPage.submitOTP();
                    test.get().info(" otp submit successfully ");

        }
        @Test(priority = 4)
            public void EnterWrongOtp(){
                test.get().info(" Entering wrong OTP automatically ");
                Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop, wait);

                loginPage.enterUser();
                test.get().info("User name entered");

                loginPage.enterPassword();
                test.get().info("Password entered");

               // loginPage.enterCapcha();
               // test.get().info("Captcha check successfully");
                loginPage.Check_box_RBOT();
                test.get().info("RBOT check successfully");

                loginPage.submitOTP();
                test.get().info(" otp submit successfully ");
                loginPage.WrongOpt();
                test.get().info(" wrong otp submit successfully ");

            }

            @Test(priority = 5)
            public void EmptyValue(){
                test.get().info("Empty Value automatically");
                Dashbord_login_page loginInvalid = new Dashbord_login_page(driver ,prop, wait);

                loginInvalid.EmptyValue();
                test.get().info("empty User name entered");
               // loginInvalid.enterCapcha();
               // test.get().info("Captcha check successfully");
                loginInvalid.Check_box_RBOT();
                test.get().info("RBOT check successfully");

                loginInvalid.submitOTP();

                loginInvalid.Error_Message();
                test.get().info(" GEt error message successfully");

            }


            

}
