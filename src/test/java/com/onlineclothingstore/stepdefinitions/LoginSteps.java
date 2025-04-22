package com.onlineclothingstore.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import com.onlineclothingstore.utils.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {


    @Then("I should see the home page is visible")
    public void i_should_see_the_home_page_is_visible() {
        WebElement loginLink = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));

        // Check if the element is displayed
        assertTrue(loginLink.isDisplayed(), "Home page is not visible");
    }

    @Then("I click on the {string} button")
    public void i_click_on_the_button(String buttonLabel) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']")));

        loginLink.click();
    }

//    @Then("I should see {string} is visible")
//    public void i_should_see_is_visible(String expectedText) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + expectedText + "']")));
//
//        // Verify that the element is displayed
//        assertTrue(heading.isDisplayed(), "Element with text '" + expectedText + "' is not visible");
//    }

    @When("I enter the email {string} and password {string}")
    public void i_enter_the_email_and_password(String email, String password) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='login-email']")));
        WebElement passwordField = Driver.getDriver().findElement(By.cssSelector("[data-qa='login-password']"));

        // Enter the email and password values
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    @Then("I should see {string} on the home page")
    public void i_should_see_on_the_home_page(String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='" + text + "']")));

        // Verify if the element is displayed on the page
        assertTrue(element.isDisplayed(), "The text '" + text + "' is not visible on the home page");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'incorrect')]")));

        // Validate error message is as expected
        assertTrue(errorMessageElement.getText().contains(expectedErrorMessage), "Expected error message was not displayed");
    }


@When("I click the {string} button")
public void i_click_the_button(String buttonLabel) {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    String dataQaValue = "";

    switch (buttonLabel.toLowerCase()) {
        case "login":
            dataQaValue = "login-button";
            break;
        case "create account":
            dataQaValue = "create-account";
            break;
        case "continue":
            dataQaValue = "continue-button";
            break;
        default:
            throw new IllegalArgumentException("Unknown button label: " + buttonLabel);
    }

    By buttonLocator = By.xpath("//button[@data-qa='" + dataQaValue + "']");
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

    try {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);
        button.click();
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", button);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}





    @When("I enter the email {string} and leave the password field empty")
    public void i_enter_the_email_and_leave_the_password_field_empty(String email) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa='login-email']")));
        // Enter the email value
        emailField.sendKeys(email);
    }

    @Then("I should see a validation message {string} on the password input field")
    public void i_should_see_a_validation_message_on_the_password_input_field(String expectedMessage) {
        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@data-qa='login-password']"));
        String actualMessage = passwordField.getAttribute("validationMessage");

        assertEquals("Fill out this field", expectedMessage, actualMessage);
    }

    @When("I leave the email field empty and enter the password {string}")
    public void i_leave_the_email_field_empty_and_enter_the_password(String password) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa='login-password']")));
        // Enter the password value
        passwordField.sendKeys(password);
    }

    @Then("I should see a validation message {string} on the email input field")
    public void i_should_see_a_validation_message_on_the_email_input_field(String expectedMessage) {
        WebElement emailField = Driver.getDriver().findElement(By.xpath("//*[@data-qa='login-email']"));
        String actualMessage = emailField.getAttribute("validationMessage");

        assertEquals("Fill out this field", expectedMessage, actualMessage);
    }
}
