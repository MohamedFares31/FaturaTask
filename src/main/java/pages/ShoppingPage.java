package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingPage extends PageBase{

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className= "inventory_item_name")
    WebElement productSavedName;

    @FindBy(xpath= "//*[@id=\"remove-sauce-labs-backpack\"]")
    WebElement removeButton;

    @FindBy(id= "checkout")
    WebElement CheckOutButton;

    public String getproductSavedName()  {

        return productSavedName.getText();
    }
    public void clickRemoving()
    {
        removeButton.click();
    }
    public void clcikCheckOutButton()
    {
        CheckOutButton.click();
    }

}
