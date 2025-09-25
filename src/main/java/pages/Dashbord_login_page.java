package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.time.Duration;

public class Dashbord_login_page {
    protected WebDriver driver;
    protected Properties prop;
    protected WebDriverWait wait;

    // locators
    private By userAgentname = By.xpath("//input[@placeholder='Email or Phone Number' or @name='emailOrMobile']");
    private By password = By.xpath("//input[@placeholder='Enter password' or @name='password']");
    private By userCapchaname = By.xpath("//input[@placeholder='Enter captcha code' or @name='captchaCode']");
    private By captchaDiv = By.xpath("//div[contains(@class,'bg-extraLightGray mt-1 w-24 rounded-md p-2')]");
    private By Sendotp = By.xpath("//button[@type='submit' or normalize-space(text())='Get OTP']");
    private By Enterotp = By.xpath("//input[@maxlength='1']");
    private By CheckLogo = By.xpath("//img[@class='h-12' or @alt='prudential']");
    private By checkcapcha = By.xpath("(//button[@type='button'])[1]");
    private By Verify_OTP = By.xpath("//button[@type='button' or normalize-space(text())='Verify']");
    private By Errormsg_usermail = By.xpath("//div[@class='text-error font-semi pl-1 text-xs']");
    private By CheckBox_im_not_robot = By.xpath("//input[@name='robotCheck']");
    private By Check_Terms_and_conditions = By.xpath("//input[@name='termsCheck']");
    private By sellpolicy = By.xpath("//a[@href='/dashboard/auth/sell-now' and span[text()='Get A Quote']]\n");
    private By sellBUTTON = By.xpath("(//button[normalize-space(text())='Sell Now'])[1] ");
    private By SellExpolatory_policy = By.xpath("//button[normalize-space()='Start now']");
    private By ProposerName = By.cssSelector("#p_name");

    // constructor
    public Dashbord_login_page(WebDriver driver, Properties prop, WebDriverWait wait) {
        this.driver = driver;
        this.prop = prop;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click_sellpolicy() {
        WebElement sellpolicy_element = wait.until(ExpectedConditions.elementToBeClickable(sellpolicy));
        sellpolicy_element.click();
    }
    public void click_Expolatory_sellpolicy(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sellpolicy_element = wait.until(ExpectedConditions.elementToBeClickable(SellExpolatory_policy));

        sellpolicy_element.click();

    }

    public void click_sellbUTTON() {
        WebElement sellbutton_element = wait.until(ExpectedConditions.elementToBeClickable(sellBUTTON));
        sellbutton_element.click();
    }

    public void enterUser() {
        String email = prop.getProperty("email");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));
        emailField.sendKeys(email);
    }

    public void enterPassword() {
        String pass = prop.getProperty("password");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordField.sendKeys(pass);
    }

    public boolean CheckLogoDis() {
        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLogo));
            return logo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterCapcha() {
        String capchaText = wait.until(ExpectedConditions.visibilityOfElementLocated(captchaDiv)).getText();
        WebElement captchaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(userCapchaname));
        captchaInput.sendKeys(capchaText);
    }

    public void Check_box_RBOT() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(CheckBox_im_not_robot));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public void Check_Terms_and_condition() {
        WebElement checkbox_termsAND_Condition = wait.until(ExpectedConditions.elementToBeClickable(Check_Terms_and_conditions));
        if (!checkbox_termsAND_Condition.isSelected()) {
            checkbox_termsAND_Condition.click();
        }
    }

    public void submitOTP() {
        wait.until(ExpectedConditions.elementToBeClickable(Sendotp)).click();
    }

    public void EnterOtp() {
        String Otp = prop.getProperty("otp");
        List<WebElement> otpBoxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Enterotp));
        for (int i = 0; i < Otp.length() && i < otpBoxes.size(); i++) {
            otpBoxes.get(i).sendKeys(Character.toString(Otp.charAt(i)));
        }
    }
    public void VerifyOtp() {
        wait.until(ExpectedConditions.elementToBeClickable(Verify_OTP)).click();
    }



    public boolean CheckCaptcha() {
        WebElement capchaRfresh = wait.until(ExpectedConditions.elementToBeClickable(checkcapcha));
        return capchaRfresh.isEnabled();
    }

    public void WrongOpt() {
        String Otp = prop.getProperty("Wrongpin");
        List<WebElement> otpBoxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Enterotp));
        for (int i = 0; i < Otp.length() && i < otpBoxes.size(); i++) {
            otpBoxes.get(i).sendKeys(Character.toString(Otp.charAt(i)));
        }
    }

    public void EmptyValue() {
        String emptymail = prop.getProperty("EmptyMail");
        WebElement emailfield = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));
        emailfield.clear();
        emailfield.sendKeys(emptymail);
    }

    public String Error_Message() {
        WebElement errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Errormsg_usermail));
        return errormsg.getText();
    }

    public void fake_Joourny_details() {
        WebElement individual = wait.until(ExpectedConditions.visibilityOfElementLocated(ProposerName));
        individual.click();
    }
}
