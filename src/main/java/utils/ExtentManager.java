package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            // Save report inside "reports" folder
            String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("QuickQuote Automation Tests");
            reporter.config().setTheme(Theme.STANDARD); // or Theme.DARK

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Add environment details (good for industry-level reporting)
            extent.setSystemInfo("Tester", "Dishant");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
