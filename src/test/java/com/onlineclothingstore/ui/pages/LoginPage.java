package com.onlineclothingstore.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlineclothingstore.utils.Driver;

public class LoginPage {

    // for email
    @FindBy(css = "[data-qa='login-email']")
    private WebElement emailField;

    // for password
    @FindBy(css = "[data-qa='login-password']")
    private WebElement passwordField;

    // button for entry
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    // locator for error message
    @FindBy(xpath = "//*[contains(text(), 'incorrect')]")
    private WebElement errorMessage;

    // constructor, which initialize elements of the page
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // method for email
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    // method for password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // method for entry button
    public void clickLoginButton() {
        loginButton.click();
    }

    // method for getting error message
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
