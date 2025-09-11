package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Saver_Journey extends Dashbord_login_page{
    public Saver_Journey(WebDriver driver, Properties prop) {
        super(driver, prop);
    }
    //common on allsprint
    private By back_to_dasboard = By.xpath("//a[contains(text(),'Back')]");
    private By Share_button = By.xpath("//a[contains(text(),'Share')]");
    private By Agent_dropdown = By.xpath("//a[contains(text(),'Agent')]");
    
    //Locators on basic customer details

    private By  ProposerName = By.xpath("//input[@id='proposer_name']");
    private By Select_Gender = By.xpath("//select[@id='gender']");
    private By Select_Plan_type  = By.xpath("//select[@id='age']");
    private By Select_piccode = By.xpath("//select[@id='piccode']");
    private By Enter_piccode = By.xpath("//input[@id='piccode']");
    private By Select_Sum_Insure = By.xpath("//select[@id='sum_insure']");
    private By In_Memb_self = By.xpath("//input[@id='mem_self']");
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




}

