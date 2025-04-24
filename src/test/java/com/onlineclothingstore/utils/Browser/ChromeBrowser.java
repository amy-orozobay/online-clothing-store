package com.onlineclothingstore.utils.Browser;

import com.onlineclothingstore.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--headless");
            options.addArguments("disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server='direct://");
            options.addArguments("--proxy-bypass-list=*");
        }
        return new ChromeDriver(options);
    }
}
