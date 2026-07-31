package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class ScreenshotUtility {
    public static String captureScreenshot(WebDriver driver, String testName){
        //Cast WebDriver to TakesScreenshot
        TakesScreenshot ts=(TakesScreenshot) driver;
        //saving into temp
        File Srcfile=ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(destinationPath);
        try {
            // 4. Copy the file to the screenshots directory
            FileUtils.copyFile(Srcfile, destination);
            System.out.println("📸 Screenshot saved successfully at: " + destinationPath);
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }

        return destinationPath; // Returns path to embed in ExtentReports later
    }
}

