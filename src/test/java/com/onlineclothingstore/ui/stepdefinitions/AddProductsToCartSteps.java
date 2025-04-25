package com.onlineclothingstore.ui.stepdefinitions;

import com.onlineclothingstore.ui.pages.CartPage;
import com.onlineclothingstore.ui.pages.ProductsPage;
import com.onlineclothingstore.ui.pages.SignupLoginPage;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProductsToCartSteps {
    WebDriver driver = Driver.getDriver();

    private final ProductsPage productsPage = new ProductsPage(driver);
    private final SignupLoginPage signupLoginPagePage = new SignupLoginPage(driver);
    private final CartPage cartPage = new CartPage(driver);
    private Map<Integer, List<String>> expectedDetailsMap;

    @Given("the user navigated to the {string} page")
    public void the_user_navigated_to_the_page(String pageName) {
        String expectedTitle = "";
        if (pageName.equalsIgnoreCase("Products")) {
            productsPage.goToProductsPage();
            expectedTitle = "Automation Exercise - All Products";
        } else if (pageName.equalsIgnoreCase("Signup / Login")) {
            signupLoginPagePage.goToSignupLoginPage();
            expectedTitle = "Automation Exercise - Signup / Login";
        }
        //validate we are in the right page
        assertEquals(expectedTitle, driver.getTitle(), "Title mismatch");
    }

    @When("the user adds {int} products to the cart")
    public void the_user_adds_products_to_the_cart(int numOfProducts) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i <= numOfProducts; i++) {
            map.put(i, productsPage.getProductDetails(i, 1));
            productsPage.addGivenProductToCart(i);
            assertTrue(productsPage.getAddedToCartMessageText().contains("added to cart"), "Added to cart confirmation message mismatch for product " + i);
            productsPage.clickContinueShoppingBtnAfterAddingToCart();
        }
        expectedDetailsMap = map;
    }

    @Then("the cart should display correct products details for each of {int} items")
    public void the_cart_should_display_correct_products_details_for_each_of_items(int numOfProducts) {
        cartPage.goToCartPage();
        assertTrue(driver.getTitle().contains("Checkout"), "Cart Page title mismatch");
        Map<Integer, List<String>> actualDetailsMap = new HashMap<>();
        for (int i = 1; i <= numOfProducts; i++) {
            actualDetailsMap.put(i, cartPage.getCartItemDetails(i));
        }
        //validate expected and actual details
        for (int i = 1; i < numOfProducts; i++) {
            List<String> expectedProductDetailsList = expectedDetailsMap.get(i);
            List<String> actualProductsDetailsList = actualDetailsMap.get(i);
            assertEquals(expectedProductDetailsList.getFirst(), actualProductsDetailsList.getFirst(), "Product name mismatch for product " + i);
            assertEquals(expectedProductDetailsList.get(1), actualProductsDetailsList.get(1), "Price mismatch for product " + i);
            assertEquals(expectedProductDetailsList.get(2), actualProductsDetailsList.get(2), "Quantity mismatch for product " + i);
            assertEquals(expectedProductDetailsList.get(3), actualProductsDetailsList.get(3), "Total mismatch for product " + i);
        }
        expectedDetailsMap.clear();
    }

}
