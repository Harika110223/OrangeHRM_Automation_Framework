package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class AdminPage {
    private WebDriver driver;

     public AdminPage(WebDriver driver) {
         this.driver = driver;
     }
         private By adminBtn=By.xpath("//span[text()='Admin']");
        private By usernameField=By.xpath("//label['text=Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
private By userRoleDropdown=By.xpath(("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']"));
private By employeeNameinput=By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
private By status=By.xpath(("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']"));
private By searchBtn=By.cssSelector("button[type='submit']");
private By resetBtn=By.xpath("//button[text()=' Reset ']");
    private By addButton = By.xpath("//button[contains(.,'Add')]");
    private By recordsCountText = By.xpath("//span[contains(text(),'Records Found')]");
    private By addbuttonuserRoleDropdown = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']");
    private By userRoleAdminOption=By.xpath("//*[text()='Admin']");

public void adminbutton(){
    WaitUtility.waitForClickable(driver,adminBtn,20);
    driver.findElement(adminBtn).click();
}
    public void searchbutton(String username,String employee){
        WaitUtility.waitForVisibility(driver,searchBtn,20);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(employeeNameinput).sendKeys(employee);
        WaitUtility.waitForClickable(driver,searchBtn,10);
        driver.findElement(searchBtn).click();
    }
    public void clickaddbutton(){
    WaitUtility.waitForClickable(driver,addButton,10);
    driver.findElement(addButton).click();
    }
    public String getRecordsfoundText(){
        WaitUtility.waitForVisibility(driver,recordsCountText,10);
        return driver.findElement(recordsCountText).getText();
    }
}
