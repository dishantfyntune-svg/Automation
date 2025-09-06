package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Dashbord_login_page { 
	protected WebDriver driver ;
    protected Properties prop;

	//locators 
	
	
		private		By userAgentname =By.xpath("//input[@placeholder='Enter Your Email/Mobile Number']");

		private By userCapchaname= By.xpath("//input[@placeholder='Enter Captcha Code']");
	    private By captchaDiv = By.xpath("//div[contains(@class,'bg-extraLightGray')]");
	    private By Sendotp = By.xpath("//button[@type='submit']");
	    private By Enterotp =By.xpath("//input[@maxlength='1']");

		
	    
	    public Dashbord_login_page(WebDriver driver, Properties prop) {
	    	this.driver = driver;
	    	this.prop =prop;
	    }
	
	    public void enterUser() {
	    	String email = prop.getProperty("email");
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(userAgentname));

            emailField.sendKeys(email);
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
	    	WebElement EnterOtpfield =wait.until(ExpectedConditions.visibilityOfElementLocated(Enterotp));
	    	List<WebElement> otpBoxes = driver.findElements(By.xpath("//input[@maxlength='1']"));
	    	for(int i = 0 ;i < Otp.length(); i++) {
	    		otpBoxes.get(i).sendKeys(Character.toString(Otp.charAt(i)));
	    	}
			
		}
	}
