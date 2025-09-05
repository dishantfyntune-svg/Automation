package com.quickquote2.Saver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.ExtentManager;

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
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
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
        if (extent != null) {
            extent.flush();
        }
    }
}
