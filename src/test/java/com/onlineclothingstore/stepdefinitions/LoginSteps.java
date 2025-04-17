package com.onlineclothingstore.stepdefinitions;

import com.onlineclothingstore.ui.pages.LoginPage;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        // driver initialization happening in Driver.getDriver()
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        // navigate to URL
        WebDriver driver = Driver.getDriver();
        driver.get(url);
    }

    @Then("I should see the home page is visible")
    public void i_should_see_the_home_page_is_visible() {
        // entry link visibility validation
        WebDriver driver = Driver.getDriver();
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        assertTrue(loginLink.isDisplayed(), "Home page is not visible");
    }

    @Then("I click on the {string} button")
    public void i_click_on_the_button(String buttonLabel) {
        // Entry button cklick
        loginPage.clickLoginButton();
    }

    @Then("I should see {string} is visible")
    public void i_should_see_is_visible(String expectedText) {
        // Title visibility validation
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + expectedText + "']")));
        assertTrue(heading.isDisplayed(), "Element with text '" + expectedText + "' is not visible");
    }

    @When("I enter the email {string} and password {string}")
    public void i_enter_the_email_and_password(String email, String password) {
        // enter email and password
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("I should see {string} on the home page")
    public void i_should_see_on_the_home_page(String text) {
        // validation, that text is visible on the main page
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='" + text + "']")));
        assertTrue(element.isDisplayed(), "The text '" + text + "' is not visible on the home page");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        // Error message validation
        String actualMessage = loginPage.getErrorMessage();
        assertTrue(actualMessage.contains(expectedErrorMessage), "Expected error message was not displayed");
    }
}

