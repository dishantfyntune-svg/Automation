package pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class ExporatoryJourney extends Dashbord_login_page {


    public ExporatoryJourney(WebDriver driver, Properties prop, WebDriverWait wait) {
        super(driver, prop, wait);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators on Exporatory Journey page Input page
    private By user = By.xpath("//input[@name='proposername']");

    private By malegender = By.xpath("//div[@role='radio']//div[contains(@class,'cursor-pointer') and normalize-space(text())='Male']");
    private By femalegender = By.xpath("//div[@role='radio']//div[contains(@class,'cursor-pointer') and normalize-space(text())='Female']");
    private By othergender = By.xpath("//div[@role='radio']//div[contains(@class,'cursor-pointer') and normalize-space(text())='Other']");

    private By selectSumInsureMinimun = By.xpath("//input[@placeholder='Min' and @role='combobox']");
    private By selectSumInsureMaximum = By.xpath("//input[contains(@placeholder,'Max') and @role='combobox']");

    private By Pincode = By.xpath("//input[@placeholder='Select Pincode']");

    //plan type
    private By Individual = By.xpath("//div[@role='radio' and .//div[normalize-space(text())='Individual']]");
    private By MultiFamily = By.xpath("//div[@role='radio' and .//div[normalize-space(text())='Multi-Individual']]");
    private By Family = By.xpath("//div[normalize-space(text())='Floater']");

    //Age
    private By selfAgeButton = By.xpath("//div[.//div[text()='Self']]//button[contains(@id,'headlessui-combobox-button')]");
    private By selfAgeInput = By.xpath("//button[@id='headlessui-combobox-button-«r1b»' and @type='button']");



    private By spouseAgeButton = By.xpath("//div[.//div[text()='Spouse']]//button[contains(@id,'headlessui-combobox-button')]");
    private By childAge1Button = By.xpath("//div[.//div[text()='Child 1']]//button[contains(@id,'headlessui-combobox-button')]");

    //Submit
    private By submit = By.xpath("(//button[normalize-space()='Get Quote'])[1]");

    //quotePage
    private By BuyFlagship2 = By.xpath("//div[contains(@class,'bg-white') and .//h2[text()='PHI Flagship 2']]//button[.//span[text()='Buy Now']]");


    //SalesProduct details
    private By Proceed_to = By.xpath("//button[.//span[text()='Proceed to Proposal']]");


    //Kycpage
    private By DOB = By.xpath("//input[@placeholder='Date of birth']");
    private By DOB_dd = By.xpath("//input[@placeholder='DD']");
    private By DOB_mm = By.xpath("//input[@placeholder='MM']");
    private By DOB_yyyy = By.xpath("//input[@placeholder='YYYY']");

    private By PAN_NUM = By.xpath("//input[@placeholder='Enter Your Pan Card Number']");
    private By Verify_Pan = By.xpath("//button[normalize-space(text())='Verify']");
    private By Continue_to_prop = By.xpath("//button[normalize-space(.//span)='Continue']");

    //Proposer Page

    //Marital Status
    private By Select_Marital_Status_click = By.xpath("//section//button[@aria-haspopup='listbox']//span[contains(text(),'Select Marital Status')]");
    private By Select_Single = By.xpath("//div[@role='option' and text()='Single']" );
    private By Select_Married             = By.xpath("//div[@role='option' and text()='Married']");
    private By Select_Widowed             = By.xpath("//div[@role='option' and text()='Widowed']");
    private By Select_Separated           = By.xpath("//div[@role='option' and text()='Separated']");
    private By Select_Divorced            = By.xpath("//div[@role='option' and text()='Divorced']");
    private By Select_LiveInRelationship  = By.xpath("//div[@role='option' and text()='Live-in Relationship']");

    //Occupation
    private By Occupation_click = By.xpath("//input[@placeholder='Select Occupation' and @role='combobox']");

    //Education
    private By Education_click = By.xpath("//button[.//span[text()='Select Educational Qualification']]");

    //Income
    private By Income_click = By.xpath("//input[@placeholder='Select Annual Income' and @name='annualIncome']");

    //Contact Details
    private   By Contact_clik  = By.xpath("//input[@placeholder='Enter Mobile Number' and @name='mobileNumber']");
    private   By Email_clik  = By.xpath("//input[@placeholder='Enter Email Address' and @name='emailAddress']");
    private By Alternate_clik  = By.xpath("//input[@placeholder='Enter Alternate Mobile Number' and @name='alternateMobileNumber']");


    //Address Details
    private By Address1_clik  = By.xpath("//input[@placeholder='Enter Address Line 1' and @name='addressLine1']");
    private By Address2_click  =By.xpath("//input[@placeholder='Enter Address Line 2' and @name='addressLine2']");
    private By Address3_click = By.xpath("//input[@placeholder='Enter Address Line 3' and @name='addressLine3']");

    //Bank Account
    private By BankAccountNumber = By.xpath("//input[@placeholder='Enter Account Number' and @name='accountNumber']");
    private By BankIFSCODE = By.xpath("//input[@placeholder='Enter IFSC' and @name='ifscCode']");
    private By VerifyButton_IFSC = By.xpath("//div[contains(@class,'flex items-center')]//button[contains(@class,'bg-primary') and text()='Verify']");
    private By accountTypeBtn = By.xpath("//button[contains(@class,'w-full') and .//span[normalize-space()='Select Account Type']]");


    //continue to insure
    private  By continueBtnToInsured = By.xpath("//button[.//span[normalize-space()='Continue']]");

    //Insured page
    private By Height_feet =By.xpath("//input[@placeholder='Select Height' and @role='combobox']");
    private By Height_inches =By.xpath("//input[@placeholder='Select Inches' and @role='combobox']");
    private By Weight =By.xpath("//input[@placeholder='weight' and @name='members.0.weight']");

    //button to nommine page
    private By ContinueToNominee =By.xpath("//button[.//span[contains(text(),'Continue')]]");

    //Nominee Details Page

    //Nominee details
    private  By RelationToProposer =By.xpath("//button[.//span[contains(text(),'Select Relationship')]]");
    private By SelectShare = By.xpath("//input[@placeholder='Enter share percentage' and @name='nominees.0.nomineeShare']");



    //continue to Medical page
    private By ContinueTomedicalPage = By.xpath("//button[.//span[normalize-space()='Continue']]");

    //Medical page
    private By CheckBoxForAnsTOno = By.xpath(
            "//button[.//div[normalize-space()='Answer No to all']]//span[@role='checkbox']"
    );


    //continueTo Summry

    private   By ContinueToSummry = By.xpath("//button[.//span[normalize-space()='Continue']]");

    //Summry Page
    private By TermAndCondition = By.xpath(
            "//div[@class='max-h-min']//span[@role='checkbox' and contains(@id,'headlessui-checkbox')]");

    //SubmitProposer
    private By submitProposerBtn =By.xpath("//button[normalize-space()='Submit proposal']");


    //OTP filed

    private By  EnterOtp = By.xpath("//div[contains(@class,'flex gap-2 mb-4')]/input[@maxlength='1']");

    //Verify Button
    private By verifyButton = By.xpath("//button[normalize-space()='Verify' and contains(@class,'bg-primary')]");


    public void EnterUser() {
        WebElement EnterUsername = wait.until(ExpectedConditions.elementToBeClickable(user));
        EnterUsername.clear();
        EnterUsername.sendKeys(prop.getProperty("p_name_expo1"));
    }

    public void selectGender() {
        String gender = prop.getProperty("gender_expo1");
        try {
            switch (gender) {
                case "Male" -> {
                    WebElement MaleGender = wait.until(ExpectedConditions.elementToBeClickable(malegender));
                    MaleGender.click();
                }
                case "Female" -> {
                    WebElement FemaleGender = wait.until(ExpectedConditions.elementToBeClickable(femalegender));
                    FemaleGender.click();
                }
                case "Other" -> {
                    WebElement OtherGender = wait.until(ExpectedConditions.elementToBeClickable(othergender));
                    OtherGender.click();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to select gender " + gender + e);
        }
    }

    public void selectSumInsured() {
        String minSum = prop.getProperty("min_sum_expo1");
        String maxSum = prop.getProperty("max_sum_expo1");

        try {
        Actions actions = new Actions(driver);
            WebElement minSumField = wait.until(ExpectedConditions.elementToBeClickable(selectSumInsureMinimun));
            minSumField.click();
            minSumField.clear();
            minSumField.clear();
            minSumField.sendKeys(minSum);
            actions.sendKeys(Keys.ARROW_DOWN)
                    .pause(Duration.ofMillis(200))
                    .sendKeys(Keys.ENTER).perform();

          /*  WebElement minOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("(//div[@role='option'])[1]")));
            minOption.click();*/

            WebElement maxSumField = wait.until(ExpectedConditions.elementToBeClickable(selectSumInsureMaximum));
            maxSumField.click();
            maxSumField.clear();
            maxSumField.clear();
            maxSumField.sendKeys(maxSum);
            actions.sendKeys(Keys.ARROW_DOWN)
                    .pause(Duration.ofMillis(200))
                    .sendKeys(Keys.ENTER).perform();

           /* WebElement maxOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("(//div[@role='option'])[1]")));
            maxOption.click();*/

        } catch (Exception e) {
            throw new RuntimeException("Failed to select Sum Insured: min=" + minSum + ", max=" + maxSum + " | " + e);
        }
    }

    public void enterPincode() {
        String pincode = prop.getProperty("pincode_expo1"); // "400001"
        System.out.println("Pincode in config: " + pincode);

        if (pincode == null || pincode.isEmpty()) {
            throw new RuntimeException("Pincode is null or empty! Check your config file.");
        }

        try {
            WebElement EnterPincode = wait.until(ExpectedConditions.elementToBeClickable(Pincode));
            EnterPincode.clear();
            Actions actions = new Actions(driver);
            for (char pindigit : pincode.toCharArray()) {
                EnterPincode.sendKeys(String.valueOf(pindigit));
                    Thread.sleep(500);

            }

            actions.sendKeys(Keys.ARROW_DOWN)
                    .pause(Duration.ofMillis(100))
                    .sendKeys(Keys.ENTER).perform();

            System.out.println("Picode selected: " + EnterPincode.getAttribute("value"));

            // Wait for the dropdown to clos
            /*EnterPincode.sendKeys(pincode);
            By firstOption = By.xpath("(//div[@role='option'])[1]");
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(firstOption));
            System.out.println("Option selected: " + option.getText());
            option.click();*/
            // Wait for the dropdown to close
        } catch (Exception e) {
            throw new RuntimeException("Failed to select pincode " + pincode + ". Error: " + e.getMessage(), e);
        }
    }

    public void SelectPlanType() {
        String planType = prop.getProperty("plan_expo1");
        By locator;

        switch (planType) {
            case "Individual" -> locator = Individual;
            case "Family" -> locator = Family;
            case "MultiFamily" -> locator = MultiFamily;
            default -> throw new IllegalStateException("Unexpected plan type: " + planType);
        }

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        System.out.println(planType + " plan selected successfully");
    }


   public void ProposerAge() {
        String age = prop.getProperty("self_age");

        try {
            Actions action = new Actions(driver);
            //WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(selfAgeButton));
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(selfAgeInput));
            input.click();
            Thread.sleep(500);

            WebElement ageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Age']")));
            ageInput.clear();
            ageInput.sendKeys(age);
            action.sendKeys(Keys.ENTER)
                    .perform();

            System.out.println("Age entered: " + age);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter age " + age + ". Error: " + e.getMessage(), e);
        }
    }
    public void ClickSubmit() {
        try {
            String oldUrl = driver.getCurrentUrl();

            WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));

            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).pause(Duration.ofMillis(200)).perform();

            actions.moveToElement(submitButton).click().perform();
            System.out.println("Submit button clicked successfully using Actions");

            wait.until(driver -> !driver.getCurrentUrl().equals(oldUrl));

            String currentUrl = driver.getCurrentUrl();

           if(oldUrl.equals(currentUrl)){
               throw new RuntimeException("Submit button did not navigate to the quote page. Current URL: " + currentUrl);
           }
            System.out.println("Quote page loaded successfully");
            Thread.sleep(5000);
        } catch (ElementClickInterceptedException e) {
                    throw new RuntimeException("Click intercepted! Possibly overlaying element. Error: " + e.getMessage(), e);
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void SelectPlan() {
        try{
            String oldUrl = driver.getCurrentUrl();
            WebElement selectFlagship2 = wait.until(ExpectedConditions.elementToBeClickable(BuyFlagship2));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", selectFlagship2);

            try {
                selectFlagship2.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectFlagship2);
            }

            wait.until(driver -> !driver.getCurrentUrl().equals(oldUrl));

            String newUrl = driver.getCurrentUrl();
            if(oldUrl.equals(newUrl)){
                throw new RuntimeException("Failed to select Flagship 2 plan. URL did not change. Current URL: " + newUrl);
            }
            System.out.println("Flagship 2 plan selected successfully. Navigated to: " + newUrl);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select plan. Error: " + e.getMessage(), e);
        }
    }
    public void setProceed_to(){
    try{
        WebElement proceed_to = wait.until(ExpectedConditions.elementToBeClickable(Proceed_to));
        proceed_to.click();
        System.out.println("Proceed to button clicked successfully. Navigated to: " + driver.getCurrentUrl());

    } catch (Exception e) {
        throw new RuntimeException("Botton is not click "+e);
    }

    }

public void EnterDOB(){
        String DD = prop.getProperty("DOB_DD_expo1");
        String MM = prop.getProperty("DOB_MM_expo1");
        String YYYY = prop.getProperty("DOB_YYYY_expo1");
        try{
            WebElement dob = wait.until(ExpectedConditions.elementToBeClickable(DOB));
            dob.click();
            dob.sendKeys("01202000");
            Thread.sleep(200);
            dob.sendKeys(Keys.ENTER);
            
            /*WebElement dob_day = wait.until(ExpectedConditions.elementToBeClickable(DOB_dd));
            dob_day.clear();
            dob_day.click();
            dob_day.sendKeys(DD);
            Thread.sleep(300);

            WebElement dob_month = wait.until(ExpectedConditions.elementToBeClickable(DOB_mm));
            dob_month.clear();
            dob_month.click()  ;
            dob_month.sendKeys(MM);
            Thread.sleep(300);

            WebElement dob_year = wait.until(ExpectedConditions.elementToBeClickable(DOB_yyyy));
            dob_year.clear();
            dob_year.click();
            dob_year.sendKeys(YYYY);*/

        } catch (Exception e) {
            throw new RuntimeException("Fail to enter DOB"+e);
        }
}
public void EnterPan(){
        try{
            WebElement paN = wait.until(ExpectedConditions.elementToBeClickable(PAN_NUM));
            paN.click();
            paN.sendKeys(prop.getProperty("PAN_NUM_expo1"));
            Thread.sleep(1000);

            if(!paN.getAttribute("value").isEmpty()){
                WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(Verify_Pan));
                verifyButton.click();
                Thread.sleep(5000);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Faild to veryfy"+e.getMessage());
        }
}
public void EnterContinueToProposer(){
        try{
            WebElement continueToProposer = wait.until(ExpectedConditions.elementToBeClickable(Continue_to_prop));
            Thread.sleep(1000);
            continueToProposer.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("Botton is not click "+e.getMessage());
        }

}
    
//PROPOSER PAGE
    public void Select_marital_Status(){
            String MaritalStatusConfic = prop.getProperty("marital_status");
        System.out.println(prop.getProperty("marital_status") + " plan selected successfully");
        By locator;
        switch (MaritalStatusConfic) {
            case "Single" -> locator = Select_Single;
            case "Married" -> locator = Select_Married;
            case "Widowed" -> locator = Select_Widowed;
            case "Separated" -> locator = Select_Separated;
            case "Divorced" -> locator = Select_Divorced;
            case "Live-in Relationship" -> locator = Select_LiveInRelationship;
            default -> throw new IllegalStateException("Unexpected plan type: " + MaritalStatusConfic);
        }


        try {
            WebElement click =wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Marital_Status_click));
            click.click();

            WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            wait.until(ExpectedConditions.elementToBeClickable(select));
            select.click();
            Thread.sleep(2000);
        } catch (ElementClickInterceptedException e) {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(MaritalStatusConfic + " plan selected successfully");
    }
    public void Select_occupation(){
        String occupationConfic = prop.getProperty("occupation");
        try{
            WebElement occupation = wait.until(ExpectedConditions.elementToBeClickable(Occupation_click));
            occupation.click();
            Thread.sleep(3000);
            occupation.sendKeys(occupationConfic);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void Select_Education_Qualification() {
        try {
            WebElement Education = wait.until(ExpectedConditions.elementToBeClickable(Education_click));
            Education.click();
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ARROW_DOWN) //below 12
                    .sendKeys(Keys.ARROW_DOWN) //10 th
                    .sendKeys(Keys.ARROW_DOWN)  //12 pass
                    .sendKeys(Keys.ARROW_DOWN)  //garduate
                    //.sendKeys(Keys.ARROW_DOWN)  //post garduate
                    // .sendKeys(Keys.ARROW_DOWN)  //Doctrate

                    .sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + " Fail while selecting education qualification");
        }
    }
    public void Enter_income(){
        String incomeConfic = prop.getProperty("ANNUL_INCOME_EXP1");
        try{
            WebElement income = wait.until(ExpectedConditions.elementToBeClickable(Income_click));
            income.click();
            Thread.sleep(3000);
            income.sendKeys(incomeConfic);
            /*Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);*/
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + " Fail while entering income");
        }
    }
    public void Enter_Contack_details(){
        String emailConfic = prop.getProperty("EMAIL_EXP1");
        String mobileConfic = prop.getProperty("MOBILE_NO_EXP1");

        int randomNumber = ThreadLocalRandom.current().nextInt(10000, 99999);
        String mobile = mobileConfic +randomNumber;
        try{
            WebElement enter_mobile = wait.until(ExpectedConditions.elementToBeClickable(Contact_clik));
            WebElement alternate_mobile = wait.until(ExpectedConditions.elementToBeClickable(Alternate_clik));
            WebElement enter_email = wait.until(ExpectedConditions.elementToBeClickable(Email_clik));

            enter_mobile.click();
            enter_mobile.sendKeys(mobile);
            //alternate_mobile.click();
            //alternate_mobile.sendKeys(mobile);
            enter_email.click();
            enter_email.sendKeys(emailConfic);

            Thread.sleep(2000);

        } catch (Exception e) {
            throw new RuntimeException("Fail to enter contack details"+e.getMessage());
        }
    }

    public void Enter_Address(){
        String address1 = prop.getProperty("ADDRESSLINE1_EXP1");
        String address2 = prop.getProperty("ADDRESSLINE2_EXP1");
        try{
            WebElement add1 =wait.until(ExpectedConditions.elementToBeClickable(Address1_clik));
            add1.click();
            add1.sendKeys(address1);
            WebElement add2 =wait.until(ExpectedConditions.elementToBeClickable(Address2_click));
            add2.click();
            add2.sendKeys(address2);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()+"Faild to enter address");
        }
    }

    public void Enter_BankAccount(){

        String accountno = prop.getProperty("ACCOUNT_NO_EXP1");
        String ifsccode = prop.getProperty("IFSC_EXP1");
        try {
            WebElement enteraccountnumber = wait.until(ExpectedConditions.elementToBeClickable(BankAccountNumber));
            enteraccountnumber.click();
            enteraccountnumber.sendKeys(accountno);
            WebElement enterIFSC = wait.until(ExpectedConditions.elementToBeClickable(BankIFSCODE));
            enterIFSC.click();
            enterIFSC.sendKeys(ifsccode);
            WebElement clickVerify = wait.until(ExpectedConditions.elementToBeClickable(VerifyButton_IFSC));
            if(!enterIFSC.equals(null)){
                clickVerify.click();
                Thread.sleep(2000);
            }
            WebElement selectAccoumtType=wait.until(ExpectedConditions.elementToBeClickable(accountTypeBtn));
            selectAccoumtType.click();
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.moveToElement(enteraccountnumber);
            actions.sendKeys(Keys.ARROW_DOWN)//for saving
                    //.sendKeys(Keys.ARROW_DOWN) // for current
                    .sendKeys(Keys.ENTER).perform();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()+"Faild to account verify");
        }
    }

    public void Enter_proposerToInsured_btn(){

        try{
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtnToInsured));
            btn.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(btn);
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void EnterInsuredDetails(){

        String height_inches= prop.getProperty("HEIGHTINCHES_EXP1");
        String height_feet= prop.getProperty("HEIGHTFEET_EXP1");
        String  weight = prop.getProperty("WEIGHT_EXP1");
            Actions actions = new Actions(driver);
            if(!height_inches.equals(null)) {
                WebElement heightfeet = wait.until(ExpectedConditions.elementToBeClickable(Height_feet));
                heightfeet.click();
                heightfeet.sendKeys(height_inches);
                actions.sendKeys(Keys.ARROW_DOWN)
                        .sendKeys(Keys.ENTER)
                        .perform();
                System.out.println("height in feet " + heightfeet);
            }else {
                throw new IllegalArgumentException("FAild to click height inches");
            }
            WebElement heightinches =wait.until(ExpectedConditions.elementToBeClickable(Height_inches));
            heightinches.click();
            heightinches.sendKeys(height_feet);
            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER)
                    .perform();
            System.out.println("Height in inches  "+heightinches);
            WebElement weightI =wait.until(ExpectedConditions.elementToBeClickable(Weight));
            weightI.click();
            weightI.sendKeys(weight);
            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER)
                    .perform();
            System.out.println("Weight  "+weightI);
            System.out.println(height_inches+" "+height_feet+" "+weight);


    }
    public void ContinoToNominee(){
        try {
            WebElement contiBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueToNominee));
            contiBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Select_Nomine(){
        String nomine1 = prop.getProperty("RELATIONSHIP_EXP1");
        WebElement selectRelation ;
        try{
            Actions actions = new Actions(driver);
            selectRelation = wait.until(ExpectedConditions.elementToBeClickable(RelationToProposer));
            selectRelation.click();
            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER).perform();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void SeleectShare() {
        String shares = prop.getProperty("SHARES_EXP1");

        if (shares != null) {
            WebElement EnterShare = wait.until(ExpectedConditions.elementToBeClickable(SelectShare));
            EnterShare.click();
            EnterShare.sendKeys(shares);

        }else {
            throw new IllegalArgumentException("Faild to click height inches");
        }

    }


    public void ContinoToMedical(){
        try {
            Actions actions =  new Actions(driver);
            WebElement contiBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueTomedicalPage));
            actions.moveToElement(contiBtn).perform();
            contiBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void AnswerToNoAll() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(CheckBoxForAnsTOno));

            // Move and click in one action
            Actions actions = new Actions(driver);
            actions.moveToElement(btn).click().perform();


            wait.until(ExpectedConditions.attributeToBe(btn, "aria-checked", "true"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to click 'Answer No to all' checkbox: " + e.getMessage());
        }
    }

    public void ContinoToSummary(){
        try {
            Actions actions =  new Actions(driver);
            WebElement contiBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueToSummry));
            actions.moveToElement(contiBtn).perform();
            Thread.sleep(5000);
            contiBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void CheckBoxButton() {

        int attemps = 0;
        while (attemps < 4) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(TermAndCondition));

                if ("false".equals(btn.getAttribute("aria-checked"))) {
                    // Scroll into view
                    Actions actions = new Actions(driver);
                    actions.moveToElement(btn).click().perform();
                    wait.until(ExpectedConditions.attributeToBe(btn, "aria-checked", "true"));
                    System.out.println(btn );
                }
                return;

            } catch (StaleElementReferenceException e) {
                attemps++;
            } catch (Exception e) {
                throw new RuntimeException("Failed to click Terms & Conditions checkbox: " + e.getMessage());
            }
        }
        throw new RuntimeException("Failed to click Terms & Conditions checkbox after multiple attempts due to stale element");
    }
    public void SubmitProposer(){
        try{


            WebElement btn =wait.until(ExpectedConditions.elementToBeClickable(submitProposerBtn));
            Actions actions =new Actions(driver);
            actions.moveToElement(btn).perform();
            btn.click();


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void EnterOTP() {
        String otp =prop.getProperty("otp");
        try {
            List<WebElement> inputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EnterOtp));

            if (otp.length() != inputs.size()) {
                throw new RuntimeException("OTP length does not match input fields");
            }

            for (int i = 0; i < otp.length(); i++) {
                WebElement input = inputs.get(i);
                input.clear(); // optional
                input.sendKeys(String.valueOf(otp.charAt(i)));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to enter OTP: " + e.getMessage());
        }
    }
    public void ClickVerifyButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(verifyButton));

            // Move to element and click (handles overlays)
            Actions actions = new Actions(driver);
            actions.moveToElement(button).click().perform();

        } catch (Exception e) {
            throw new RuntimeException("Failed to click Verify button: " + e.getMessage());
        }
    }


}






