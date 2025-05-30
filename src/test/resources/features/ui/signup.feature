@Smoke @UI
Feature: Signup Functionality

  Background:
    Given I click on the "Signup / Login" button

  Scenario: TC01 - Successfully create new user and after that delete it
    When I enter the name "Joe" and email "joe13@biden.com"
    And I click the "Signup" button
    Then I should see the "Enter Account Information" page
    When I fill out the signup form with the following data:
      | Gender    | Mr            |
      | First name | Joe          |
      | Last name  | Biden        |
      | Password  | JoeBiden123   |
      | Address   | 1600 Penn Ave |
      | Country   | United States |
      | State     | NY            |
      | City      | New York      |
      | Zipcode   | 55577         |
      | Mobile    | 1234567890    |
      | Day       | 15            |
      | Month     | 6             |
      | Year      | 1990          |
    And I click the "Create Account" button
    Then I should see the message "Congratulations! Your new account has been successfully created!"
    And I click the "Continue" button
    When I click the "Delete Account" button
    Then I should see the message "Your account has been permanently deleted!"



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
