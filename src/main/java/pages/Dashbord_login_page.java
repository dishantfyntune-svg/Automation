package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Dashbord_login_page
{
    protected WebDriver driver;
    protected Properties prop;

    //locators
    private By userAgentname = By.xpath("//input[@placeholder='Email or Phone Number' or @name='emailOrMobile']");
    private By password = By.xpath("//input[@placeholder='Enter password' or @name='password']");
    private By userCapchaname = By.xpath("//input[@placeholder='Enter captcha code' or @name='captchaCode']");
    private By captchaDiv = By.xpath("//div[contains(@class,'bg-extraLightGray mt-1 w-24 rounded-md p-2')]");
    private By Sendotp = By.xpath("//button[@type='submit' or normalize-space(text())='Get OTP']");
    private By Enterotp = By.xpath("//input[@maxlength='1']");
    private By CheckLogo = By.xpath("//img[@class='h-12' or @alt='prudential']");
    private By checkcapcha = By.xpath("(//button[@type='button'])[1]");
    private By Errormsg_usermail = By.xpath("//div[@class='text-error font-semi pl-1 text-xs']");
    //
    private By sellpolicy = By.xpath("//span[normalize-space()='Sell Policy']");
    private By sellBUTTON = By.xpath("(//button[normalize-space(text())='Sell Now'])[1] ");


    public Dashbord_login_page(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }


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

    public void enterUser() {
        String email = prop.getProperty("email");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));

        emailField.sendKeys(email);
    }
    public void enterPassword() {
        String pass = prop.getProperty("password");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));

        passwordField.sendKeys(pass);
    }
    public boolean CheckLogoDis() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLogo));
            return logo.isDisplayed();
        } catch (Exception e) {
            {
                return false;
            }
        }

    }

    public void enterCapcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String capchaText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(captchaDiv)
        ).getText();

        WebElement captchaInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(userCapchaname));
        captchaInput.sendKeys(capchaText);
    }

    public void submitOTP() {

        driver.findElement(Sendotp).click();
    }

    public void EnterOtp() {
        String Otp = prop.getProperty("otp");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement EnterOtpfield = wait.until(ExpectedConditions.visibilityOfElementLocated(Enterotp));
        List<WebElement> otpBoxes = driver.findElements(By.xpath("//input[@maxlength='1']"));
        for (int i = 0; i < Otp.length(); i++) {
            otpBoxes.get(i).sendKeys(Character.toString(Otp.charAt(i)));
        }

    }
    public boolean CheckCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement capchaRfresh = wait.until(ExpectedConditions.elementToBeClickable(checkcapcha));
        if( capchaRfresh.isEnabled()){
            return true;
        }else {
            return false;
        }
    }
    public void WrongOpt(){
        String Otp = prop.getProperty("Wrongpin");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enterotp = wait.until(ExpectedConditions.elementToBeClickable(Enterotp));
        List<WebElement> otpBoxes = driver.findElements(By.xpath("//input[@maxlength='1']"));
        for (int i = 0; i < Otp.length(); i++) {
            otpBoxes.get(i).sendKeys(Character.toString(Otp.charAt(i)));
        }

    }
    public void EmptyValue(){
        String emptymail = prop.getProperty("EmptyMail");
        WebDriverWait   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailfield = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));
        emailfield.clear();
        emailfield.sendKeys(emptymail);
    }
    public String Error_Message(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement errormag =  wait.until(ExpectedConditions.visibilityOfElementLocated(Errormsg_usermail));

        return errormag.getText();
    }



}



