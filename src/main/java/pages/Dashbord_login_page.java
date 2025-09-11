package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Dashbord_login_page {
    protected WebDriver driver;
    protected Properties prop;

    //locators
    private By userAgentname = By.xpath("//input[@placeholder='Enter Your Email/Mobile Number']");
    private By userCapchaname = By.xpath("//input[@placeholder='Enter Captcha Code']");
    private By captchaDiv = By.xpath("//div[contains(@class,'bg-extraLightGray')]");
    private By Sendotp = By.xpath("//button[@type='submit']");
    private By Enterotp = By.xpath("//input[@maxlength='1']");
    private By CheckLogo = By.xpath("//img[@class='h-12' or @alt='prudential']");
    private By checkcapcha = By.xpath("(//button[@type='button'])[1]");
    private By Errormsg_usermail = By.xpath("//div[@class='text-error font-semi pl-1 text-xs']");



    public Dashbord_login_page(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }

    public void enterUser() {
        String email = prop.getProperty("email");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));

        emailField.sendKeys(email);
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



