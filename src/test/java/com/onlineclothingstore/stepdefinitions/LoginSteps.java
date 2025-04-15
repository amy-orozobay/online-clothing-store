//package com.onlineclothingstore.stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import com.onlineclothingstore.utils.Driver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class LoginSteps {
//
//    @Given("I launch the browser")
//    public void i_launch_the_browser() {
//        // The browser is initialized in the Driver.getDriver() method
//        // No need to initialize it here again
//    }
//
//    @When("I navigate to {string}")
//    public void i_navigate_to(String url) {
//        // Navigate to the URL provided in the feature file
//        Driver.getDriver().get(url);
//    }
//
//    @Then("I should see the home page is visible")
//    public void i_should_see_the_home_page_is_visible() {
//        WebElement loginLink = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
//
//        // Check if the element is displayed
//        assertTrue(loginLink.isDisplayed(), "Home page is not visible");
//    }
//
//    @Then("I click on the {string} button")
//    public void i_click_on_the_button(String buttonLabel) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']")));
//
//        loginLink.click();
//    }
//
//    @Then("I should see {string} is visible")
//    public void i_should_see_is_visible(String expectedText) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + expectedText + "']")));
//
//        // Verify that the element is displayed
//        assertTrue(heading.isDisplayed(), "Element with text '" + expectedText + "' is not visible");
//    }
//
//    @When("I enter the email {string} and password {string}")
//    public void i_enter_the_email_and_password(String email, String password) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='login-email']")));
//        WebElement passwordField = Driver.getDriver().findElement(By.cssSelector("[data-qa='login-password']"));
//
//        // Enter the email and password values
//        emailField.sendKeys(email);
//        passwordField.sendKeys(password);
//    }
//
//    @Then("I should see {string} on the home page")
//    public void i_should_see_on_the_home_page(String text) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='" + text + "']")));
//
//        // Verify if the element is displayed on the page
//        assertTrue(element.isDisplayed(), "The text '" + text + "' is not visible on the home page");
//    }
//
//    @Then("I should see an error message {string}")
//    public void i_should_see_an_error_message(String expectedErrorMessage) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'incorrect')]")));
//
//        // Validate error message is as expected
//        assertTrue(errorMessageElement.getText().contains(expectedErrorMessage), "Expected error message was not displayed");
//    }
//
//    @When("I click the {string} button")
//    public void i_click_the_button(String buttonLabel) {
//        // Wait for the button to be clickable using the data-qa attribute
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//
//        // Use the data-qa attribute to locate the button exactly
//        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']")));
//
//        // Click on the button
//        button.click();
//    }
//
//
//
//
//    @When("I enter the email {string} and leave the password field empty")
//    public void i_enter_the_email_and_leave_the_password_field_empty(String email) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa='login-email']")));
//        // Enter the email value
//        emailField.sendKeys(email);
//    }
//
//    @Then("I should see a validation message {string} on the password input field")
//    public void i_should_see_a_validation_message_on_the_password_input_field(String expectedMessage) {
//        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@data-qa='login-password']"));
//        String actualMessage = passwordField.getAttribute("validationMessage");
//
//        assertEquals("Fill out this field", expectedMessage, actualMessage);
//    }
//
//    @When("I leave the email field empty and enter the password {string}")
//    public void i_leave_the_email_field_empty_and_enter_the_password(String password) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa='login-password']")));
//        // Enter the password value
//        passwordField.sendKeys(password);
//    }
//
//    @Then("I should see a validation message {string} on the email input field")
//    public void i_should_see_a_validation_message_on_the_email_input_field(String expectedMessage) {
//        WebElement emailField = Driver.getDriver().findElement(By.xpath("//*[@data-qa='login-email']"));
//        String actualMessage = emailField.getAttribute("validationMessage");
//
//        assertEquals("Fill out this field", expectedMessage, actualMessage);
//    }
//}

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
        // Инициализация браузера происходит в Driver.getDriver()
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        // Навигация на URL
        WebDriver driver = Driver.getDriver();
        driver.get(url);
    }

    @Then("I should see the home page is visible")
    public void i_should_see_the_home_page_is_visible() {
        // Проверка видимости ссылки на вход
        WebDriver driver = Driver.getDriver();
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        assertTrue(loginLink.isDisplayed(), "Home page is not visible");
    }

    @Then("I click on the {string} button")
    public void i_click_on_the_button(String buttonLabel) {
        // Кликаем по кнопке входа
        loginPage.clickLoginButton();
    }

    @Then("I should see {string} is visible")
    public void i_should_see_is_visible(String expectedText) {
        // Проверка видимости заголовка
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + expectedText + "']")));
        assertTrue(heading.isDisplayed(), "Element with text '" + expectedText + "' is not visible");
    }

    @When("I enter the email {string} and password {string}")
    public void i_enter_the_email_and_password(String email, String password) {
        // Вводим email и пароль
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("I should see {string} on the home page")
    public void i_should_see_on_the_home_page(String text) {
        // Проверка, что текст виден на главной странице
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='" + text + "']")));
        assertTrue(element.isDisplayed(), "The text '" + text + "' is not visible on the home page");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        // Проверка сообщения об ошибке
        String actualMessage = loginPage.getErrorMessage();
        assertTrue(actualMessage.contains(expectedErrorMessage), "Expected error message was not displayed");
    }
}

