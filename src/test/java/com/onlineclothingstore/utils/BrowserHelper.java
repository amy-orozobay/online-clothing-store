package com.onlineclothingstore.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserHelper {

    public WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public int getIntPriceFromElement(WebElement price) {
        String priceStr = price.getText();
        StringBuilder sb = new StringBuilder(priceStr);
        priceStr = sb.substring(priceStr.indexOf('.') + 2);
        return Integer.parseInt(priceStr);
    }

    public String getPriceFromString(String price) {
        StringBuilder sb = new StringBuilder(price);
        return sb.substring(price.indexOf('.') + 2);
    }

    public void scrollElementIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }

    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void tripleClickElement(WebElement element, JavascriptExecutor js) {
        try {
            // First try standard click
            element.click();
        } catch (ElementClickInterceptedException e) {
            // Second try: Force click via JavaScript
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            // Final try: Scroll into exact view and click
            js.executeScript(
                    "window.scrollTo(arguments[0].getBoundingClientRect().x, " +
                            "arguments[0].getBoundingClientRect().y - 100);",
                    element
            );
            element.click();
        }
    }

    public void removeAdIframes(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Remove all Google Ads iframes (common IDs: 'aswift_1', 'google_ads_iframe')
        js.executeScript(
                "document.querySelectorAll('iframe[id^=\"aswift_\"], iframe[id^=\"google_ads_iframe\"]')" +
                        ".forEach(iframe => iframe.remove());"
        );
    }
}
