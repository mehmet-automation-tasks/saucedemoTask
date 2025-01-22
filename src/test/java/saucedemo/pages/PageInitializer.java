package saucedemo.pages;

import saucedemo.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static CartPage cartPage;

    public static void initialize(){
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
    }
}
