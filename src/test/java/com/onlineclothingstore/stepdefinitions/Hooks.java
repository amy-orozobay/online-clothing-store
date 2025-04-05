package com.onlineclothingstore.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.onlineclothingstore.utils.Driver;

public class Hooks {

    @Before
    public void setUp() {
        Driver.initialize(); // Create WebDriver
    }

    @After
    public void tearDown() {
        Driver.quitDriver(); // Quit WebDriver
    }
}
