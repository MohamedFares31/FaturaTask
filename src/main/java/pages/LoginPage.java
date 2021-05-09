package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id= "user-name")
    public WebElement Username;

    @FindBy(id= "password")
    public WebElement Password;

    @FindBy(id= "login-button")
    WebElement Login_button;

    @FindBy(xpath= "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement Errormessage;


    public  void login(String user, String pass)
    {
        Username.sendKeys(user);
        Password.sendKeys(pass);
        Login_button.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public String getErrorMassege()  {

        return Errormessage.getText();
    }


}
