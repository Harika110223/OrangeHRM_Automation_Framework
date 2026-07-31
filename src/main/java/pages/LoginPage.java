package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtility;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    //Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
     By submitButton = By.cssSelector("button[type='submit']");
    By dashboardIsEnabled=By.xpath("//h6[text()='Dashboard']");



    //methods
    public void enterUsername(String username) {
        WaitUtility.waitForVisibility(driver,usernameField,20);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String Password) {
        WaitUtility.waitForVisibility(driver,passwordField,20);
        driver.findElement(passwordField).sendKeys(Password);
    }

    public void loginButton() {
        WaitUtility.waitForClickable(driver,submitButton,20);
driver.findElement(submitButton).click();
        //Actions actions=new Actions(driver);
        //actions.moveToElement(submitButton).click().perform();

    }
    public boolean IsDashboardEnabled() {
        WaitUtility.waitForVisibility(driver, dashboardIsEnabled, 20);

        return driver.findElement(dashboardIsEnabled).isDisplayed();
    }
        }

