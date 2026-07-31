package tests;

import base.BaseClass;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    @Test
    public void verifyLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.loginButton();
        boolean IsDashboardEnabled= loginPage.IsDashboardEnabled();
        System.out.println("--- IS DASHBOARD DISPLAYED? " + IsDashboardEnabled + " ---");
        Assert.assertTrue(loginPage.IsDashboardEnabled());
        DashboardPage dashboardPage=new DashboardPage(driver);
       // dashboardPage.logout();
        AdminPage adminpage=new AdminPage(driver);
        adminpage.adminbutton();
        adminpage.searchbutton(ConfigReader.getProperty("searchUsername") ,ConfigReader.getProperty("searchEmployeeName"));
         adminpage.clickaddbutton();
        //Assert.assertTrue(driver.getCurrentUrl().contains("saveSystemUser"), "FAIL: Click on Add User button failed to route properly!");
        Assert.assertTrue(driver.getCurrentUrl().contains("FORCED_ERROR_PATH"), "URL did not match");

    }


}