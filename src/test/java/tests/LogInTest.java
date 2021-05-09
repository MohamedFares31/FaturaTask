package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;


public class LogInTest extends TestBase {

    LoginPage loginobj;
    HomePage homePageobj = new HomePage(driver);
    String massege;

    @DataProvider(name = "positive")
    public Object[][] userPositiveData() throws IOException {
        ExcelReader ER =new ExcelReader();
        return ER.getExcelDataSheet1();
    }

    @DataProvider(name = "negative")
    public Object[][] userNegativeData() throws IOException {
        ExcelReader ER =new ExcelReader();
        return ER.getExcelDataSheet2();
    }

    @Test(priority = 0,dataProvider = "positive")
    public void positiveLogin(String user, String pass)
    {
        loginobj = new LoginPage(driver);
        homePageobj= new HomePage(driver);
        loginobj.login(user, pass);
        massege = homePageobj.getLogInMassege();
        Assert.assertEquals(massege,"PRODUCTS");
        homePageobj.logOut();

    }

    @Test(priority = 1,dataProvider = "negative")
    public void negativeLogin(String user, String pass)
    {
        loginobj = new LoginPage(driver);
        homePageobj= new HomePage(driver);
        loginobj.login(user, pass);
        loginobj.Username.clear();
        loginobj.Password.clear();
        massege = loginobj.getErrorMassege();
        Assert.assertTrue(massege.contains("Epic sadface"));
    }
}
