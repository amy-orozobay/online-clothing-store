@Smoke
Feature: Signup Functionality

  Background:
    Given I click on the "Signup / Login" button
    Then I should see "New User Signup!" is visible

  Scenario: TC01 - Successfully create new user and after that delete it
    When I enter the name "Joe" and email "joe@biden.com"
    And I am clicking the "Signup" button
    Then I should see the "Enter Account Information" page
    When I fill out the signup form with the following data:
      | Name      | Joe Biden         |
      | Email     | joe@biden.com     |
      | Password  | JoeBiden123       |
      | Address   | 1600 Penn Ave     |
      | Country   | United States     |
      | State     | NY                |
      | City      | New York          |
      | ZipCode   | 55577             |
      | Mobile    | 1234567890        |
    And I click the "Create Account" button
    Then I should see the message "Account Created!"
    And I click the "Continue" button
    When I click the "Delete Account" button
    Then I should see the message "Account Deleted!"


  Scenario: TC02 - Try to create a new user with an empty email input field
    When I enter the name "Bill" and the email ""
    And I click the "Signup" button
    Then I should see a validation message "Fill out this field" for the email input

  Scenario: TC03 - Try to create a new user with an empty name input field
    When I enter the name "" and the email "bill@clinton.com"
    And I click the "Signup" button
    Then I should see a validation message "Fill out this field" for the name input

  Scenario: TC04 - Try to create a new user with an invalid email
    When I enter the name "Bill" and the email "bill#clinton.com"
    And I click the "Signup" button
    Then I should see a validation message "Please include an '@' in the email address"
