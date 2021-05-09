package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "first-name")
    WebElement firstName;

    @FindBy(id= "last-name")
    WebElement LastName;

    @FindBy(id= "postal-code")
    WebElement postalCode;

    @FindBy(id= "continue")
    WebElement continueButton;

    @FindBy(id= "finish")
    WebElement finishButton;

    @FindBy(id= "back-to-products")
    WebElement backToHome;




    public void checkOut(String first_name, String Last_name, String postal_code)
    {
        firstName.sendKeys(first_name);
        LastName.sendKeys(Last_name);
        postalCode.sendKeys(postal_code);
        continueButton.click();
        finishButton.click();
        backToHome.click();

    }
}
