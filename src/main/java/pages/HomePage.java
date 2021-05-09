package pages;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy (id= "react-burger-menu-btn")
	WebElement MenuButton;

	@FindBy (id = "logout_sidebar_link")
	WebElement LogoutButton;

	@FindBy(className = "title")
	 WebElement Title;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	 WebElement AddButton;

	@FindBy(className = "shopping_cart_link")
	WebElement shoppingButton;

	@FindBy(className = "inventory_item_name")
	WebElement prodectname;

	@FindBy(className = "product_sort_container")
	WebElement sortingMenu;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
	WebElement Sortingoption1;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
	WebElement Sortingoption2;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
	WebElement Sortingoption3;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
	WebElement Sortingoption4;


	public String getLogInMassege()  {

		return Title.getText();
	}
	public String getprodectname()  {

		return prodectname.getText();
	}

	public void logOut()  {
		MenuButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LogoutButton.click();
	}
	public void clickAddButton()
	{
		AddButton.click();

	}
	public void clickShopping()
	{
		shoppingButton.click();
	}
	public void Sorting()
	{
		sortingMenu.click();
		Sortingoption1.click();
		Sortingoption2.click();
		Sortingoption3.click();
		Sortingoption4.click();
	}
}
