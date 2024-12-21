package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();

    public static void initReport() {
        // Initialize the Spark Reporter
        sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("API Automation Report");

        // Initialize ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put(Thread.currentThread().getId(), test); // Store test instance by thread ID
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
