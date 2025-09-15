package com.pages_test;

import Saver.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Dashbord_data;
import pages.Dashbord_login_page;
import pages.Saver_Journey ;


public class Saver_journy_Test extends base {
    @BeforeMethod
    public void login_Dashboard(){
        test.get().info("Starting Dashboard login test");

        Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop);

        loginPage.enterUser();
        test.get().info("Entered email from config.properties");

        loginPage.enterPassword();
        test.get().info("Entered password from config.properties");

        loginPage.enterCapcha();
        test.get().info("Entered captcha automatically");


        loginPage.submitOTP();
        test.get().info("Clicked Send OTP button");

        loginPage.EnterOtp();
        test.get().info("Otp submit successfully");

        loginPage.click_sellpolicy();
        test.get().info("Clicked Sell Policy button");

        loginPage.click_sellbUTTON();
        test.get().info("Clicked Sell button");
    }
    @Test
    public void Self_journey_test(){
        test.get().info("Starting Self journey test");
        Saver_Journey journey = new Saver_Journey(driver, prop);

        journey.Enter_proposer_Name();
        test.get().info("Journey submit successfully");

        journey.Select_Gender("male");
    }



    @AfterMethod
    public void logout() {
        driver.quit();
    }
}
