@Smoke
Feature: Add products to cart

  Scenario: Add a single product to the cart and verify it appears correctly
    Given the user navigated to the "Products" page
    When the user adds 1 product to the cart
    Then the cart should display product name, price, quantity,and total for that item

