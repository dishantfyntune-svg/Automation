package pages;

import utils.FrameUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;


public class Saver_Journey extends Dashbord_login_page{
    public Saver_Journey(WebDriver driver, Properties prop) {
        super(driver, prop);
    }
    //common on allsprint
    protected By back_to_dasboard = By.xpath("//a[contains(text(),'Back')]");
    protected  By Share_button = By.xpath("//a[contains(text(),'Share')]");
    protected  By Agent_dropdown = By.xpath("//a[contains(text(),'Agent')]");

    //DASHBOARD page

    //Locators on basic customer details


    private By ProposerName = By.xpath("//input[@name='fullName']");

    private By Select_Gender_male = By.xpath("//div[@role='radio' and  .//div[normalize-space(text())='Male']]");
    private By Select_Gender_female = By.xpath("//div[@role='radio' and  .//div[normalize-space(text())='Female']]");
    private By Select_Gender_other = By.xpath("((//div[contains(@class,'border-textBlack')])[5]");
    private By Select_Plan_type_individual  = By.xpath("(//input[contains(@type,'radio')])[2]");
    private By Select_Plan_type_floter  = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/section[1]/div[1]/div[2]/div[1]");
    private By Select_Plan_type_multi_indivi  = By.xpath("(//div[contains(@class,'border-textBlack')])[10]");
    private By Select_piccode = By.xpath("//input[@role='combobox' and @aria-label='Search']");
    private By Enter_piccode = By.xpath("//input[@placeholder='Select Pincode']");
    private By Click_Sum_Insure = By.xpath("//input[@placeholder='Select Sum Insured']");
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


    public void Enter_proposer_Name() {
        String proposerName = prop.getProperty("pname");
        git gui
        WebElement NameInput = FrameUtils.findElementInFrames(driver, ProposerName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(NameInput));
        NameInput.sendKeys(proposerName);

    }
    public void Select_Gender(String gender) {
        By genderLocator; // l variable

        switch (gender.toLowerCase()) {
            case "male":
                genderLocator = Select_Gender_male;
                break;
            case "female":
                genderLocator = Select_Gender_female;
                break;
            default:
                genderLocator = Select_Gender_other;
        }

        // This line **actually clicks the radio button**
        WebElement genderOption = FrameUtils.findElementInFrames(driver, genderLocator);
        genderOption.click();
    }
    public void Select_Gender_female() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement female = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Gender_female));
        female.click();
    }
    public void Select_Gender_other() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Gender_other));
        other.click();
    }
    public void Select_Plan_type_individual() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement individual = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Plan_type_individual));
        individual.click();
    }
    public void Select_Plan_type_floter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement floter = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Plan_type_floter));
        floter.click();
    }
    public void Select_Plan_type_multi_indivi() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement multi_indivi = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Plan_type_multi_indivi));
        multi_indivi.click();
    }
    public void Select_Enter_piccode(String piccode) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement piccodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_piccode));
        piccodeInput.clear();
        piccodeInput.sendKeys(piccode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Enter_piccode)).click();

    }

    public void Select_Enter_Sum_Insure(String amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sumInsure = wait.until(ExpectedConditions.visibilityOfElementLocated(Click_Sum_Insure));
        sumInsure.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(select_Sum_Insure(amount))).click();
    }
    public void Enter_In_Memb_self(String selfAge) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement In_Memb_selfInput = wait.until(ExpectedConditions.visibilityOfElementLocated(In_Memb_self));
        In_Memb_selfInput.clear();
        In_Memb_selfInput.sendKeys(selfAge);
    }

}


