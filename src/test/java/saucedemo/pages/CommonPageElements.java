package saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import saucedemo.utilities.Driver;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    public void logoutFromSauceDemo(){
        burgerMenuBtn.click();
        logoutLink.click();
    }



}
