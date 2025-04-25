package com.onlineclothingstore.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends BasePage {
    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    // === LOGIN SECTION ===
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement loginErrorMessage;


    // === SIGNUP SECTION ===
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupHeader;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement accountInfoHeader;


    // === METHODS ===
    public boolean isLoginHeaderVisible() {
        return helper.waitForVisibilityOfElement(driver, loginHeader, 10).isDisplayed();
    }

    public void login(String email, String password) {
        helper.waitForVisibilityOfElement(driver, loginEmailInput, 10).sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginErrorMessageVisible() {
        return helper.waitForVisibilityOfElement(driver, loginErrorMessage, 10).isDisplayed();
    }

    public boolean isSignupHeaderVisible() {
        return helper.waitForVisibilityOfElement(driver, signupHeader, 10).isDisplayed();
    }

    public boolean isAccountInfoHeaderVisible() {
        return helper.waitForVisibilityOfElement(driver, accountInfoHeader, 10).isDisplayed();
    }

    public void enterSignupNameAndEmail(String name, String email) {
        helper.waitForVisibilityOfElement(driver, signupNameInput, 10).sendKeys(name);
        signupEmailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        helper.waitForElementToBeClickable(driver, signupButton);
        signupButton.click();
    }

    public WebElement getSignupEmailInput() {
        return signupEmailInput;
    }

    public WebElement getSignupNameInput() {
        return signupNameInput;
    }

}
