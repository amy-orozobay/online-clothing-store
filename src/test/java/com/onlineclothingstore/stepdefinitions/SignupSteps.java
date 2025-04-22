package com.onlineclothingstore.stepdefinitions;

import com.onlineclothingstore.pages.BasePage;
import com.onlineclothingstore.pages.SignupDetailsPage;
import com.onlineclothingstore.pages.SignupLoginPage;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class SignupSteps {

    WebDriver driver = Driver.getDriver();
    SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
    SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);



    @Given("I am clicking on the {string} button")
    public void i_am_clicking_on_the_button(String buttonText) {
        signupLoginPage.goToSignupLoginPage();
    }


    @When("I enter the name {string} and email {string}")
    public void i_enter_the_name_and_email(String name, String email) {
        signupLoginPage.enterSignupNameAndEmail(name, email);
    }

    @And("I am clicking the {string} button")
    public void i_am_clicking_the_button(String buttonText) {
        if (buttonText.equalsIgnoreCase("Signup")) {
            signupLoginPage.clickSignupButton();
        } else if (buttonText.equalsIgnoreCase("Create Account")) {
            // implement on the page class if needed
        } else if (buttonText.equalsIgnoreCase("Continue")) {
            // implement if necessary
        } else if (buttonText.equalsIgnoreCase("Delete Account")) {
            // implement if necessary
        }
    }


@Then("I should see the {string} page")
public void i_should_see_the_page(String expectedHeader) {
    switch (expectedHeader) {
        case "New User Signup!":
            assertTrue(signupLoginPage.isSignupHeaderVisible(), "'New User Signup!' header not visible");
            break;
        case "Enter Account Information":
            assertTrue(signupLoginPage.isAccountInfoHeaderVisible(), "'Enter Account Information' header not visible");
            break;
        default:
            fail("Unknown header: " + expectedHeader);
    }
}


    @When("I fill out the signup form with the following data:")
    public void i_fill_out_the_signup_form_with_the_following_data(Map<String, String> data) {
        // name, email, password, address, country, state, city, zip, mobile
        signupDetailsPage.selectGender(data.get("Gender"));
        signupDetailsPage.fillSignupForm(data);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        // пример: проверка "Account Created!"
        // Можно добавить метод в соответствующую страницу (например: AccountCreatedPage)
    }

    @Then("I should see a validation message {string} for the {string} input")
    public void i_should_see_a_validation_message_for_the_input(String expectedMessage, String field) {
        String actualMessage = "";
        if (field.equalsIgnoreCase("email")) {
            actualMessage = signupLoginPage.getSignupEmailInput().getAttribute("validationMessage");
        } else if (field.equalsIgnoreCase("name")) {
            actualMessage = signupLoginPage.getSignupNameInput().getAttribute("validationMessage");
        }
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

