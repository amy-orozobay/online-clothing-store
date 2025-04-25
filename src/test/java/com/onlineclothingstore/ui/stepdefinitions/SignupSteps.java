package com.onlineclothingstore.ui.stepdefinitions;

import com.onlineclothingstore.ui.pages.AccountCreatedOrDeletedPage;
import com.onlineclothingstore.ui.pages.SignupDetailsPage;
import com.onlineclothingstore.ui.pages.SignupLoginPage;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class SignupSteps {

    WebDriver driver = Driver.getDriver();
    SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
    SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);


    @When("I enter the name {string} and email {string}")
    public void i_enter_the_name_and_email(String name, String email) {
        signupLoginPage.enterSignupNameAndEmail(name, email);
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
    AccountCreatedOrDeletedPage page = new AccountCreatedOrDeletedPage(Driver.getDriver());
    String actualMessage = page.getMessageText(expectedMessage);

    assertEquals(expectedMessage, actualMessage, "Mismatch Message!");
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

