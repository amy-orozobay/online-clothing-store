@Smoke @API
Feature: Login API Functionality

  Background:
    Given the base API URL is set

  Scenario: TC01 - Log in with valid credentials
    When I send a POST request to "/api/login" with email "trump@gmail.com" and password "donTrump123"
    Then the response status code should be 200
    And the response should contain the username "Donald"

  Scenario: TC02 - Log in with invalid email and valid password
    When I send a POST request to "/api/login" with email "trum@gmail.com" and password "donTrump123"
    Then the response status code should be 401
    And the response should contain error message "Your email or password is incorrect!"

  Scenario: TC03 - Log in with valid email and invalid password
    When I send a POST request to "/api/login" with email "trump@gmail.com" and password "dontrump123"
    Then the response status code should be 401
    And the response should contain error message "Your email or password is incorrect!"

  Scenario: TC04 - Log in with valid email and empty password
    When I send a POST request to "/api/login" with email "trump@gmail.com" and password ""
    Then the response status code should be 400
    And the response should contain validation message "Password is required"

  Scenario: TC05 - Log in with empty email and valid password
    When I send a POST request to "/api/login" with email "" and password "donTrump123"
    Then the response status code should be 400
    And the response should contain validation message "Email is required"
