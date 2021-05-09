package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String BrowserName)
    {
        if(BrowserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
            driver =  new ChromeDriver();
        }
        else if(BrowserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
            driver =  new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @AfterClass
    public void stopDriver()
    {
        driver.quit();
    }

}
