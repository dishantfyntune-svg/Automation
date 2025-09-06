package com.pages_test;

import com.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.quickquote2.Saver.base;

import java.util.*;

public class Dashbord_test  extends base{

    @BeforeMethod
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
    @Test  (priority = 1)
    public void test_SAVER_1(){
        test.get().info("Starting Saver test");
        Dashbord_data dashbordData = new Dashbord_data(driver, prop);

        dashbordData.click_sellpolicy();
        dashbordData.click_sellbUTTON();
        dashbordData.Enter_policy_holder_name();
        dashbordData.Select_gender_as_male();
        dashbordData.Select_plan_indi();
        dashbordData.Enter_pincode();
        dashbordData.Select_proposer_age();

    }

    @AfterMethod
    public void logout(){

    }
    @Test(priority = 2)
    public void test_SAVER_2(){
        test.get().info("Starting Saver test 1A_indi");


    }


}
