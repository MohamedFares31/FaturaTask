package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class LogOutTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;

    @DataProvider(name = "login")
    public Object[][] userData() throws IOException {
        ExcelReader ER =new ExcelReader();
        return ER.getExcelData();
    }

    @Test(dataProvider = "login")
    public void logout(String user, String pass)
    {
        homePage=new HomePage(driver);
        loginPage =new LoginPage(driver);
        loginPage.login(user,pass);
        Assert.assertEquals(homePage.getLogInMassege(),"PRODUCTS");
        homePage.logOut();
    }
}
