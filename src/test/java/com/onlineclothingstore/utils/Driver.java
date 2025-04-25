package com.onlineclothingstore.utils;

import com.onlineclothingstore.utils.Browser.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    //Private constructor to prevent instantiation
    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser").toLowerCase();
            Browser browserStrategy = switch (browser) {
                case "firefox" -> new FirefoxBrowser();
                case "safari" -> new SafariBrowser();
                case "ie" -> new IEBrowser();
                default -> new ChromeBrowser();
            };

            driver = browserStrategy.createDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(600));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            //taking screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //adding screenshots reports
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
