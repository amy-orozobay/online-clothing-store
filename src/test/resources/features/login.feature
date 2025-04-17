@Smoke
Feature: Login Functionality

  Background:
    Given I click on the "Signup / Login" button
    Then I should see "Login to your account" is visible


  Scenario: TC01 - Log in with valid credentials as a real user
    When I enter the email "trump@gmail.com" and password "donTrump123"
    And I click the "login" button
    Then I should see "Donald" on the home page

  Scenario: TC02 - Log in with invalid email and valid password
    When I enter the email "trum@gmail.com" and password "donTrump123"
    And I click the "login" button
    Then I should see an error message "Your email or password is incorrect!"

  Scenario: TC03 - Log in with valid email and invalid password
    When I enter the email "trump@gmail.com" and password "dontrump123"
    And I click the "login" button
    Then I should see an error message "Your email or password is incorrect!"

  Scenario: TC04 - Log in with valid email and empty password input field
    When I enter the email "trump@gmail.com" and leave the password field empty
    And I click the "login" button
    Then I should see a validation message "Fill out this field" on the password input field

  Scenario: TC05 - Log in with empty email input field and valid password
    When I leave the email field empty and enter the password "donTrump123"
    And I click the "login" button
    Then I should see a validation message "Fill out this field" on the email input field
