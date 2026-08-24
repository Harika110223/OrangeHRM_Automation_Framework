package tests;

import base.BaseClass;
import dataprovider.LogintestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ExcelLoginTest extends BaseClass {
    @Test(dataProvider="loginExcelData",dataProviderClass = LogintestData.class)
    public void VerifyLoginWithExcelData(String UserName,String Password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(UserName);
        loginPage.enterPassword(Password);
        loginPage.loginButton();
       // boolean IsDashboardEnabled = loginPage.IsDashboardEnabled();
       // System.out.println("Excel account:" +UserName+ "/Logged In Successfully?" +IsDashboardEnabled);
        //Assert.assertTrue(IsDashboardEnabled, "Login failed for credentials found in Excel row!");
    }
    }


