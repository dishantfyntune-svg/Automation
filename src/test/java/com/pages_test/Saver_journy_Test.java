package com.pages_test;

import Saver.base;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Dashbord_login_page;
import pages.Saver_Journey ;


public class Saver_journy_Test extends base {
    private WebDriverWait wait;

    @BeforeMethod
    public void login_Dashboard(){
        test.get().info("Starting Dashboard login test");

        Dashbord_login_page loginPage =new Dashbord_login_page(driver, prop, wait);

        loginPage.enterUser();
        test.get().info("Entered email from config.properties");

        loginPage.enterPassword();
        test.get().info("Entered password from config.properties");

        //loginPage.enterCapcha();
       // test.get().info("Entered captcha automatically");
        loginPage.Check_box_RBOT();
        test.get().info("Checked ROBOT checkbox");

        loginPage.Check_Terms_and_condition();
        test.get().info("Checked Terms and Conditions checkbox");

        loginPage.submitOTP();
        test.get().info("Clicked Send OTP button");

        loginPage.EnterOtp();
        test.get().info("Otp submit successfully");

        loginPage.VerifyOtp();
        test.get().info("Otp verification successful");

        loginPage.click_sellpolicy();
      //loginPage.click_Expolatory_sellpolicy();
        test.get().info("Clicked Sell Policy button");

        loginPage.click_sellbUTTON();
        test.get().info("Clicked Sell button");
    }
   /* @DataProvider(name = "journeyData")
    public Object[][] getJourneyData() {
        // Each row represents one test run with its own data.
        // Columns: Proposer Name, Gender, Pincode
        return new Object[][]{
                {"Amit Kumar", "male", "110001"},
                {"Priya Singh", "female", "400001"},
                {"Alex Ray", "other", "560001"}
        };
    }*/
    @Test
    public void Self_journey_test_1(){
        test.get().info("Starting Self journey test");
        Saver_Journey journey = new Saver_Journey(driver, prop,wait);

       journey.enterProposerName("Amit Kumar");
        test.get().info("Journey submit successfully");



    }
   /*  @Test
   public void fillCustomerDetailsForm() {


        Saver_Journey customerPage = new Saver_Journey(driver, prop);

        // Fill form
        customerPage.enterProposerName("Amit Kumar");
        customerPage.selectGender("Male");
        customerPage.selectPlanType("Individual");
        customerPage.enterPincode("110001");
        customerPage.selectSumInsured("5000");
        customerPage.enterInsuredAges(Arrays.asList("30", "28"));

        // Add a wait to observe results (optional)
        try { Thread.sleep(3000); } catch (InterruptedException e) { }

        driver.quit();
    }



  */


}
