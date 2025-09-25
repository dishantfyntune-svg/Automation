package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class Saver_Journey extends Dashbord_login_page{
    public Saver_Journey(WebDriver driver, Properties prop,WebDriverWait wait) {
        super(driver, prop, wait);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    //common on allsprint
    protected By back_to_dasboard = By.xpath("//a[contains(text(),'Back')]");
    protected  By Share_button = By.xpath("//a[contains(text(),'Share')]");
    protected  By Agent_dropdown = By.xpath("//a[contains(text(),'Agent')]");

    //DASHBOARD page

    //Locators on basic customer details




    private By proposerNameInput = By.xpath("//input[contains(@id,'p_name')]");

    private By genderOptions = By.xpath("//input[@name='gender']/following-sibling::span");
    private By planTypeOptions = By.xpath("//input[@name='planType']/following-sibling::span");
    private By pincodeInput = By.xpath("//input[@placeholder='Enter Pincode']");
    private By sumInsuredInput = By.xpath("//input[@placeholder='Select Sum Insured']");
    private By sumInsuredOptions = By.xpath("//ul[@role='listbox']/li");
    private By insuredAgesInputs = By.xpath("//input[contains(@id,'headlessui-combobox-input')]");
    private By select_Sum_Insure(String amount) {
        return By.xpath("//li[@role='option' and contains(text(),'" + amount + "')]");
        }
    // Page class locator
    private By In_Memb_self = By.xpath("//input[@placeholder='Age' and @aria-label='Assignee']");

    private By IN_Memb_spouse = By.xpath("//input[@id='mem_spouse']");
    private By In_memb_son = By.xpath("//input[@id='mem_son']");
    private By In_memb_dauther = By.xpath("//input[@id='mem_dauther']");
    // more child aslo can add ----------------------
    private By In_Memb_Father = By.xpath("//input[@id='mem_father']");
    private By In_Memb_Mother = By.xpath("//input[@id='mem_mother']");
    private By In_Memb_Father_in_Law = By.xpath("//input[@id='mem_father_in_Law']");
    private By In_Memb_Mother_in_law = By.xpath("//input[@id='mem_mother_in_law']");
    private By Calculate_premium = By.xpath("//input[@id='premium']");


    //locators on Quote__page
    private  By  SeeDetails = By.xpath("//input[@id='see_details']");
        //plan Details
        private By Download_brochure = By.xpath("//input[@id='download_brochure']");
        private By policy_wording = By.xpath("//input[@id='policy_wording']");
        //add-on //
        //customise_coverage
        private By Click_See_All_options=By.xpath("//input[@id='click_see_all_options']");
            private By copayment = By.xpath("//input[@id='copayment']");
            private By surrogate_mother= By.xpath("//input[@id='surrogate_mother']");
            private By Hospi_cash = By.xpath("//input[@id='hospi_cash']");
            //drop_down
            private By Hospi_cash_daily_limite=By.xpath("//input[@id='hospi_cash_daily_limite']");
        private By Air_ambulance_cover= By.xpath("//input[@id='air_ambulance_cover']");
        private By Ooctey_doner= By.xpath("//input[@id='ooctey_doner']");
        private By Organ_Donar  = By.xpath("//input[@id='organ_donar']");
        private By HIV_AIDS =By.xpath("//input[@id='organ_donar']");
        //CAshLEss Hospital
        private By select_pincodes_Name_hospital= By.xpath("//select[@id='pincodes_hospital']");
        private By Search_hospital= By.xpath("//input[@id='hospital']");
        //Claim process
        private By click_call_helpline= By.xpath("//input[@id='call_helpline']");
        private By click_mail = By.xpath("//input[@id='mail']");
        private By click_download_claim_form = By.xpath("//input[@id='phone']");
        //cut buttom "X" ------cut
        private By Clicl_Cancle = By.xpath("//input[@id='cancle']");


    //Choose Multi-Year Options\
        //check_box
        private By Year_one_premium= By.xpath("//input[@id='year_one_premium']");
        private By Year_Two_premium= By.xpath("//input[@id='year_two_premium']");
        private By Year_Three_premium= By.xpath("//input[@id='year_three_premium']");

    //show premium breakup
    private By Show_premium_breakup= By.xpath("//input[@id='premium_breakup']");

    //Buy now button
    private By BuyNow_btn= By.xpath("//input[@id='buynow_btn']");





// Method


    public void enterProposerName(String name) {
        try{
            String currentHandle = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {

                if (!handle.equals(currentHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(proposerNameInput));

        input.click();
        input.clear();
        input.sendKeys(name);
        }  catch (Exception e){


           System.out.println("Error occurred while entering proposer name: " + e.getMessage());
        }

    }

    public void selectGender(String gender) {
        List<WebElement> options = driver.findElements(genderOptions);

        switch (gender.toLowerCase()) {
            case "male":
                // Assuming 'Male' is the first option (index 0)
                if (!options.isEmpty()) {
                    options.get(0).click();
                }
                break;
            case "female":
                // Assuming 'Female' is the second option (index 1)
                if (options.size() > 1) {
                    options.get(1).click();
                }
                break;
            case "other":
                // Assuming 'Other' is the third option (index 2)
                if (options.size() > 2) {
                    options.get(2).click();
                }
                break;
        }
    }

    public void selectGender() {
        String gender = prop.getProperty("gender").toLowerCase();
        List<WebElement> options = driver.findElements(genderOptions);

        switch (gender) {
            case "male":
                // Assuming 'Male' is the first option
                if (!options.isEmpty()) {
                    options.get(0).click();
                }
                break;
            case "female":
                // Assuming 'Female' is the second option
                if (options.size() > 1) {
                    options.get(1).click();
                }
                break;
            case "other":
                // Assuming 'other ' is the third option
                if (options.size() > 1) {
                    options.get(3).click();
                }
                break;
        }
    }


    // Select plan type
    public void selectPlanType(String planType) {
        List<WebElement> options = driver.findElements(planTypeOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(planType)) {
                option.click();
                break;
            }
        }
    }

    // Enter pincode
    public void enterPincode(String pincode) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(pincodeInput));
        input.clear();
        input.sendKeys(pincode);
    }

    // Select sum insured
    public void selectSumInsured(String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(sumInsuredInput));
        input.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sumInsuredOptions));
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                option.click();
                break;
            }
        }
    }

    // Enter ages for insured members
    public void enterInsuredAges(List<String> ages) {
        List<WebElement> inputs = driver.findElements(insuredAgesInputs);
        for (int i = 0; i < ages.size() && i < inputs.size(); i++) {
            inputs.get(i).clear();
            inputs.get(i).sendKeys(ages.get(i));
        }
    }
}





