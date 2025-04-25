@Smoke @UI
Feature: Add products to cart

  Background:
    Given the user navigated to the "Products" page

  Scenario Outline: Add products to the cart and verify details appear correctly
    When the user adds <numOfProducts> products to the cart
    Then the cart should display correct products details for each of <numOfProducts> items

    Examples:
      | numOfProducts |
      | 1             |
      | 3             |