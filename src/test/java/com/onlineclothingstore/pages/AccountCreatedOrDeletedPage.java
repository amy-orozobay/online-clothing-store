package com.onlineclothingstore.pages;

import com.onlineclothingstore.utils.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedOrDeletedPage extends BasePage {

    public AccountCreatedOrDeletedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    BrowserHelper helper = new BrowserHelper();

    public String getMessageText(String expectedMessage) {
        By messageLocator = By.xpath("//p[normalize-space()='" + expectedMessage + "']");
        WebElement messageElement = driver.findElement(messageLocator);
        helper.waitForVisibilityOfElement(driver, messageElement, 10);
        return messageElement.getText().trim();
    }


    public boolean isMessageDisplayed(String expectedMessage) {
        WebElement messageElement = driver.findElement(By.xpath("//p[normalize-space()='" + expectedMessage + "']"));
        helper.waitForVisibilityOfElement(driver, messageElement, 10);
        return messageElement.isDisplayed();
    }

}

