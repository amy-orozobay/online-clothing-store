package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Map;

public class SignupDetailsPage extends BasePage {

    public SignupDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    private WebElement mrRadio;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(id = "id_gender1") // Для "Mr."
    protected WebElement mrRadioButton;

    @FindBy(id = "id_gender2") // Для "Mrs."
    protected WebElement mrsRadioButton;


    // === METHODS ===
    public void fillSignupForm(Map<String, String> data) {
        helper.waitForVisibilityOfElement(driver, passwordInput, 10).sendKeys(data.get("Password"));
        helper.selectFromDropdownByValue(dayDropdown, data.get("Day"));
        helper.selectFromDropdownByValue(monthDropdown, data.get("Month"));
        helper.selectFromDropdownByValue(yearDropdown, data.get("Year"));
        firstNameInput.sendKeys(data.get("First name"));
        lastNameInput.sendKeys(data.get("Last name"));
        addressInput.sendKeys(data.get("Address"));
        helper.selectFromDropdownByVisibleText(countryDropdown, data.get("Country"));
        stateInput.sendKeys(data.get("State"));
        cityInput.sendKeys(data.get("City"));
        zipCodeInput.sendKeys(data.get("Zipcode"));
        mobileInput.sendKeys(data.get("Mobile"));
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Mr")) {
            mrRadioButton.click();
        } else if (gender.equalsIgnoreCase("Mrs")) {
            mrsRadioButton.click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }


    public void clickCreateAccount() {
        createAccountButton.click();
    }
}

