package com.pages_test;

import Saver.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Dashbord_login_page;
import pages.ExporatoryJourney;
import static org.junit.jupiter.api.Assertions.*;

public class ExporatoryJourneyTest extends base {
private WebDriverWait wait ;

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
        test.get().info("Checked ROBOT checkbox")   ;

        loginPage.Check_Terms_and_condition();
        test.get().info("Checked Terms and Conditions checkbox");

        loginPage.submitOTP();
        test.get().info("Clicked Send OTP button");

        loginPage.EnterOtp();
        test.get().info("Otp submit successfully");

        loginPage.VerifyOtp();
        test.get().info("Otp verification successful");

        loginPage.click_sellpolicy();
        test.get().info("Clicked Sell button");

        loginPage.click_Expolatory_sellpolicy();
        test.get().info("Clicked Sell Policy button");
    }
    @Test
    public void testExportJourneyOneAdult() {
        ExporatoryJourney adultOne = new  ExporatoryJourney(driver, prop, wait);

        test.get().info("Navigated to export journey");

        // Switch to new window
        try {
            SwitchToNewWindow();
            test.get().pass("Switched to new window");
        } catch (Exception e) {
            test.get().fail("Failed to switch window: " + e.getMessage());
            throw e;
        }

        // Enter user details
        adultOne.EnterUser(); // Now EnterUser() already has assertion
        test.get().pass("User details entered successfully");


        // Select gender
        try {
            adultOne.selectGender();
            test.get().pass("Gender selected successfully: " + prop.getProperty("p_gender_expo1"));
        } catch (Exception e) {
            test.get().fail("Gender selection failed: " + e.getMessage());
            throw e;
        }

        // Select sum insured
        try {
            adultOne.selectSumInsured();
            String minSum = prop.getProperty("min_sum_expo1");
            String maxSum = prop.getProperty("max_sum_expo1");
            test.get().pass("Sum Insured selected successfully: " + minSum + " to " + maxSum);
        } catch (Exception e) {
            test.get().fail("Sum Insured selection failed: " + e.getMessage());
            throw e;
        }


            adultOne.enterPincode();
            test.get().pass("Pincode entered successfully");

            adultOne.SelectPlanType();
            test.get().pass("Plan type selected successfully: " + prop.getProperty("plan_expo1"));

            adultOne.ProposerAge();
       // adultOne.enterMemberAge("Self", prop.getProperty("self_age"));
            test.get().info("Proposer age entered successfully");
            test.get().pass("Proposer age entered successfully");


        adultOne.ClickSubmit();
            test.get().info("Submit button clicked successfully");
            test.get().pass("Submit button clicked successfully");

            adultOne.SelectPlan();
            test.get().info("Plan selected successfully");
            test.get().pass("Plan selected successfully");

            adultOne.setProceed_to();
            test.get().info("Proceed to button clicked successfully");
            test.get().pass("Proceed to button clicked successfully");

            adultOne.EnterDOB();
            test.get().info("DOB entered successfully");
            test.get().pass("DOB entered successfully");

            adultOne.EnterPan();
            test.get().info("Pan entered successfully");
            test.get().pass("Pan entered successfully");

            adultOne.EnterContinueToProposer();
            test.get().info("Continue to Proposer button clicked successfully");
            test.get().pass("Continue to Proposer button clicked successfully");

            adultOne.Select_marital_Status();
            test.get().info("Marital status selected successfully");
            test.get().pass("Marital status selected successfully");

            adultOne.Select_occupation();
            test.get().info("Occupation selected successfully");
            test.get().pass("Occupation selected successfully");

            adultOne.Select_Education_Qualification();
            test.get().info("Education qualification selected successfully");
            test.get().pass("Education qualification selected successfully");

            adultOne.Enter_income();
            test.get().info("Income entered successfully");
            test.get().pass("Income entered successfully");

            adultOne.Enter_Contack_details();
            test.get().info("Contact details entered successfully");
            test.get().pass("Contact details entered successfully");

            adultOne.Enter_Address();
            test.get().info("Address Detailes are enter");
            test.get().pass("Address Detailes are enter");

            adultOne.Enter_BankAccount();
            test.get().info("Account details are enter");
            test.get().pass("Account details are enter");

            adultOne.Enter_proposerToInsured_btn();
        test.get().info("navigate to insure page");
        test.get().pass("Navigate to insure page");

        adultOne.EnterInsuredDetails();
        test.get().info("InsuredDetails");
        test.get().pass("InsuredDetail");

        adultOne.ContinoToNominee();

        adultOne.Select_Nomine();

        adultOne.SeleectShare();

        adultOne.ContinoToMedical();

        adultOne.AnswerToNoAll();

      adultOne.ContinoToSummary();

      adultOne.CheckBoxButton();

      adultOne.SubmitProposer();

      adultOne.EnterOTP();

      adultOne.ClickVerifyButton();




    }


}
