package Saver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.ExtentManager;

public class base {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    protected Properties prop;

    @BeforeSuite
    public void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        extent = ExtentManager.getReporter();
        extent.attachReporter(spark);

        try {
            prop = new Properties();
            FileInputStream files = new FileInputStream("src/resources/property/config.properties");
            prop.load(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setup(java.lang.reflect.Method method) {
        // Create new ExtentTest per test method
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);

        String browser = prop.getProperty("browser");
        System.out.println("browser "+browser);
        if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("autofill.profile_enabled", false);  // disable autofill
            prefs.put("autofill.credit_card_enabled", false); // disable card save popup

            options.setExperimentalOption("prefs", prefs);

            // Disable Chrome's password manager dialogs
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            driver = new EdgeDriver(options);
        }else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }



    public void pressEnterKey() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SwitchToNewWindow() {
        try {
            String currentWindowHandle = driver.getWindowHandle();
            System.out.println(currentWindowHandle);
            Set<String> windowHandles = driver.getWindowHandles();

            for (String windowHandle : windowHandles) {
                if (!windowHandle.equalsIgnoreCase(currentWindowHandle)) { // switch to new window only if it's not the current window'
                    driver.switchTo().window(windowHandle);
                    System.out.println(windowHandle);
                    break;
                }
                System.out.println("new tab " + driver.getTitle());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while entering proposer name: " + e.getMessage());
        }
    }



    @AfterMethod
    public void getResult(ITestResult result) {
        ExtentTest extentTest = test.get();
        if (extentTest != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.fail("Test FAILED: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.pass("Test PASSED");
            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.skip("Test SKIPPED: " + result.getThrowable());
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }



    @AfterSuite
    public void tearDownExtent() {
        try {
            Thread.sleep(5000); // wait for report generation
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (extent != null) {
            extent.flush();
        }
    }
}
