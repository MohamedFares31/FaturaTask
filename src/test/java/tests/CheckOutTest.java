package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class CheckOutTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    ShoppingPage shoppingPage;
    CheckOutPage checkOutPage;

    @DataProvider(name = "Checkout")
    public Object[][] userData() throws IOException {
        ExcelReader ER =new ExcelReader();
        return ER.getCheckOutData();
    }

    @Test(dataProvider = "Checkout")
    public void CheckOutTest(String user,String pass,String first_Name,String last_Name, String post_code){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        shoppingPage = new ShoppingPage(driver);
        checkOutPage = new CheckOutPage(driver);
        loginPage.login(user,pass);
        Assert.assertEquals(homePage.getLogInMassege(),"PRODUCTS");
        homePage.clickAddButton();
        homePage.clickShopping();
        Assert.assertEquals(shoppingPage.getproductSavedName(), homePage.getprodectname());
        shoppingPage.clcikCheckOutButton();
        checkOutPage.checkOut(first_Name,last_Name,post_code);
        homePage.logOut();
    }

}
