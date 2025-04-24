package com.onlineclothingstore.utils.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser implements Browser {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
