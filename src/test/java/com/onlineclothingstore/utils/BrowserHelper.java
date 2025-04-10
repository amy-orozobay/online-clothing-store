package com.onlineclothingstore.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserHelper {
    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    //wait until the element is visible
    public WebElement waitForVisibilityOfElement(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
