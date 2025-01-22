package saucedemo.step_definitions;

import io.cucumber.java.en.And;
import saucedemo.pages.LoginPage;
import saucedemo.utilities.CommonSteps;
import saucedemo.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.utilities.Log;

public class LoginStepDefs extends CommonSteps {

    @Given("the user goes to saucedemo website")
    public void theUserGoesToSaucedemoWebsite() {
        driver.get(ConfigurationReader.get("url"));
        Log.info("Navigated to "+ConfigurationReader.get("url")+ " website");
    }

    @When("the user logs in with {string} credentials")
    public void theUserLogsInWithCredentials(String username) {
        loginPage.loginWithValidCredentials(username);
    }


}
