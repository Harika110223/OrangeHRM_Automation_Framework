package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import config.ConfigReader;

import java.io.IOException;

public class BaseClass {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return this.driver;
    }
        @BeforeMethod
    public void setup() throws IOException {
        new ConfigReader();//load config properties
        ChromeOptions options=new ChromeOptions();
        options.addArguments("---guest");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

    }
    @AfterMethod
public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}