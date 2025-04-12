@Smoke
Feature: Add products to cart

  Scenario: Add a single product to the cart and verify it appears correctly
    Given the user navigated to the "Products" page
    When the user adds "" products to the cart
    Then the user should be able to access the cart via cart icon and cart page URL
    Then the cart should display product name, quantity, price, and total for each item