package com.onlineclothingstore.stepdefinitions;

import com.onlineclothingstore.utils.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public Hooks() {
    }

    @Before
    public void the_user_is_on_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {
        Driver.takeScreenshot(scenario);
        Driver.closeDriver();
    }
}
