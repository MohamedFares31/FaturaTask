package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddRemoveToCardTest extends TestBase{


    LoginPage loginPage;
    HomePage homePageobj;
    ShoppingPage shoppingPage;


    @DataProvider(name = "login")
    public Object[][] userData() throws IOException {
        ExcelReader ER =new ExcelReader();
        return ER.getExcelData();
    }

    @Test(priority = 2,dataProvider = "login")
    public void AddToCard(String user, String pass)
    {
        loginPage =new LoginPage(driver);
        homePageobj =new HomePage(driver);
        shoppingPage= new ShoppingPage(driver);
        loginPage.login(user,pass);
        Assert.assertEquals(homePageobj.getLogInMassege(),"PRODUCTS");
        homePageobj.clickAddButton();
        homePageobj.clickShopping();
        Assert.assertEquals(shoppingPage.getproductSavedName(), homePageobj.getprodectname());
        homePageobj.logOut();
    }

    @Test(priority = 3,dataProvider = "login")
    public void RemoveFromCard(String user, String pass)
    {
        loginPage =new LoginPage(driver);
        homePageobj =new HomePage(driver);
        shoppingPage= new ShoppingPage(driver);
        loginPage.login(user,pass);
        Assert.assertEquals(homePageobj.getLogInMassege(),"PRODUCTS");
        homePageobj.clickShopping();
        shoppingPage.clickRemoving();
        homePageobj.logOut();


    }
}
