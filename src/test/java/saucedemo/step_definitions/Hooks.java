package saucedemo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import saucedemo.utilities.CommonSteps;
import saucedemo.utilities.Driver;
import saucedemo.utilities.Log;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Driver.getDriver();
        Log.startTestCase(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            // take screenshot and save it in /failed
            picture = CommonSteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        Log.endTestCase(scenario.getName());
    }






}

