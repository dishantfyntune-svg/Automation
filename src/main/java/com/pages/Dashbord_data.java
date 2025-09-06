package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Dashbord_data extends Dashbord_login_page{


    public Dashbord_data(WebDriver driver, Properties prop) {
        super(driver, prop);

    }

    //Locators
    private By sellpolicy = By.xpath("//span[normalize-space()='Sell Policy']");
    private By sellBUTTON = By.xpath("/html/body/div/div/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[3]/button");
    private By Entername_holder = By.xpath("//input[@type='text' and @placeholder='Enter Full Name']");
    private By Select_gender_male = By.xpath("//*[@id='headlessui-radio]");
    private By Select_plan_indi =By.xpath("//*[@id='headlessui-label']");
    private By Enter_pincode =By.xpath("//input[@id='headlessui-combobox-input']");
    private By Select_proposer_age =By.xpath("//input[@id='headlessui-combobox-input']");



    public void click_sellpolicy(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sellpolicy_element = wait.until(ExpectedConditions.elementToBeClickable(sellpolicy));

        sellpolicy_element.click();

    }
    public void click_sellbUTTON(){
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement sellbutton_element = wait.until(ExpectedConditions.elementToBeClickable(sellBUTTON));
    sellbutton_element.click();
    }
    public void Enter_policy_holder_name(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement enter_name=wait.until(ExpectedConditions.visibilityOfElementLocated(Entername_holder));
        //System.out.println("HTML of element: " + enter_name.getAttribute("outerHTML"));
        enter_name.sendKeys("Automation tester");

    }
    public void Select_gender_as_male(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement select_gender=wait.until(ExpectedConditions.elementToBeClickable(Select_gender_male));
        select_gender.click();

    }
    public void Select_plan_indi(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selc_plan_indi = wait.until(ExpectedConditions.elementToBeClickable(Select_plan_indi));
        selc_plan_indi.click();
    }
    public void Enter_pincode(){
        String pincode=prop.getProperty("pincode");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enter_pincode = wait.until(ExpectedConditions.elementToBeClickable(Enter_pincode));
        List<WebElement> pincodes =driver.findElements(By.xpath("//*[@id='headlessui-pincode-input']"));
        for(int i =0;i<pincodes.size() && i <pincode.length() ;i++){
            pincodes.get(i).clear();
            pincodes.get(i).sendKeys(String.valueOf(pincode.charAt(i)));
        }
    }
    public void Select_proposer_age(){
        String age30 = prop.getProperty("age30");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ageInput = wait.until(ExpectedConditions.elementToBeClickable(Select_proposer_age));
        ageInput.click();
        WebElement ageSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Age']")));
        ageSelect.sendKeys(age30);

    }




}


