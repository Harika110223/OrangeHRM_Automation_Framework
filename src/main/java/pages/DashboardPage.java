package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By userDropdown=By.className("oxd-userdropdown-tab");
    private By logoutButton=By.xpath("//a[text()='Logout']");


public void logout() {
    WaitUtility.waitForClickable(driver, userDropdown, 20);
    driver.findElement(userDropdown).click();

    WaitUtility.waitForClickable(driver, logoutButton, 20);
    driver.findElement(logoutButton).click();
}
}