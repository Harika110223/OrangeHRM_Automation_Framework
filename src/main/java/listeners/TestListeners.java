package listeners;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotUtility;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test started:" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test success:" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        try {
            // Get the active driver instance from the running test class instance
            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseClass) currentClass).getDriver();
            if (driver != null) {
                // Call our utility to grab the screenshot automatically
                ScreenshotUtility.captureScreenshot(driver, result.getName());
            }
        } catch (Exception e) {
            System.out.println("⚠️ Could not fetch driver instance to take screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Test Suite Execution Completed!");
    }
}
