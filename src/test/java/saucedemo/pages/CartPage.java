package saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends CommonPageElements{

    @FindBy(css = "[class='inventory_item_price']")
    public WebElement productPrice;

    @FindBy(name = "remove-sauce-labs-fleece-jacket")
    public WebElement removeBtn;

}
