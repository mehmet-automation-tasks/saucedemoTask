package saucedemo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import saucedemo.utilities.CommonSteps;
import saucedemo.utilities.ConfigurationReader;
import saucedemo.utilities.Log;

public class CartStepDefs extends CommonSteps {

    @Then("the item should be seen in the cart")
    public void theItemShouldBeSeenInTheCart() {
        String expectedMaxProductPrice = ConfigurationReader.get("highestProductPrice");
        String actualMaxProductPrice = cartPage.productPrice.getText().substring(1);
        Assert.assertEquals(expectedMaxProductPrice, actualMaxProductPrice);
        Log.info("Actual max product price is matching with the expected max product price");
    }

    @And("the user removes the item from the cart")
    public void theUserRemovesTheItemFromTheCart() {
        cartPage.removeBtn.click();
        Log.info("Product has been removed from the cart");
    }

    @And("the user logs out from the website")
    public void theUserLogsOutFromTheWebsite() {
        cartPage.logoutFromSauceDemo();
        Log.info("User logged out successfully...");
    }
}
