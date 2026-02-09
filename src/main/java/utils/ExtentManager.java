package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public static ExtentReports createInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(
                "test-output/ExtentReport.html");
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");
            
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }
    
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }
    
    public static ExtentTest getTest() {
        return test.get();
    }
}