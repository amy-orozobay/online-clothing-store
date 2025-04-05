package com.onlineclothingstore.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static WebDriver driver;

    public static void initialize() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");  // get name of browser from config file

            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
