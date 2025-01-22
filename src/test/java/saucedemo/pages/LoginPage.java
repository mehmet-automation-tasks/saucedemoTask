package saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import saucedemo.utilities.ConfigurationReader;
import saucedemo.utilities.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends CommonPageElements{

    @FindBy(id = "user-name")
    public WebElement usernameTxtbox;

    @FindBy(id = "password")
    public WebElement passwordTxtbox;

    @FindBy(id = "login-button")
    public WebElement loginBtn;


    public void loginWithValidCredentials(String username){
        List<String> validUsernames = new ArrayList<>(Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"));
        if(validUsernames.contains(username.toLowerCase())){
            usernameTxtbox.sendKeys(username);
            passwordTxtbox.sendKeys(ConfigurationReader.get("password"));
            loginBtn.click();
            Assert.assertEquals("Swag Labs", driver.getTitle());
            Log.info("User logged in successfully with \""+username+"\" role");
        }else {
            Log.error("Invalid username");
        }
    }


}
