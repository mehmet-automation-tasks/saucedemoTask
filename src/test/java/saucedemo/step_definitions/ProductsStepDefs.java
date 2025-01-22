package saucedemo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.utilities.CommonSteps;
import saucedemo.utilities.ConfigurationReader;
import saucedemo.utilities.Log;

public class ProductsStepDefs extends CommonSteps {

    private double highestPrice;

    @And("finds the highest price item")
    public void findsTheHighestPriceItem() {
        ConfigurationReader.set("highestProductPrice", productsPage.getTheMostExpensiveProductPrice());
        Log.info("The most expensive product's price is $"+ConfigurationReader.get("highestProductPrice"));
    }

    @And("adds the most expensive item to the cart")
    public void addsTheMostExpensiveItemToTheCart() {
        productsPage.clickOnAddToCartButtonOfTheMostExpensiveProduct();
        Log.info("The most expensive product has been added to the cart");
    }

    @When("the user goes to the cart")
    public void theUserGoesToTheCart() {
        productsPage.cartBtn.click();
        Log.info("User clicked on Cart button");
    }


}
