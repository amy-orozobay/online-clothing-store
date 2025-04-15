package com.onlineclothingstore.stepdefinitions;

import com.onlineclothingstore.pages.CartPage;
import com.onlineclothingstore.pages.ProductsPage;
import com.onlineclothingstore.pages.SignupLoginPage;
import com.onlineclothingstore.utils.BrowserHelper;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProductsToCartSteps {
    WebDriver driver = Driver.getDriver();

    private final ProductsPage productsPage = new ProductsPage(driver);
    private final SignupLoginPage signupLoginPagePage = new SignupLoginPage(driver);
    private final CartPage cartPage = new CartPage(driver);
    BrowserHelper helper = new BrowserHelper();
    private Map<String, String> expectedDetails;

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

    @When("the user adds 1 product to the cart")
    public void the_user_adds_products_to_the_cart() {
        expectedDetails = productsPage.getProductDetails(1, 1);
        productsPage.addGivenProductToCart(1);
        //validate pop up is visible
        assertTrue(productsPage.getAddedToCartMessageText().contains("added to cart"), "Added to cart confirmation message mismatch");
        productsPage.clickContinueShoppingBtnAfterAddingToCart();
    }

    @Then("the cart should display product name, price, quantity,and total for that item")
    public void the_cart_should_display_product_name_price_quantity_and_total_for_that_item() {
        cartPage.goToCartPage();
        assertTrue(driver.getTitle().contains("Checkout"), "Cart Page title mismatch");
        Map<String, String> actualDetails = cartPage.getCartItemDetails(1);
        //validate expected and actual details
        assertEquals(expectedDetails.get("productName"), actualDetails.get("productName"), "Product Name mismatch");
        assertEquals(expectedDetails.get("price"), actualDetails.get("price"), "Price mismatch");
        assertEquals(expectedDetails.get("quantity"), actualDetails.get("quantity"), "Quantity mismatch");
        assertEquals(expectedDetails.get("total"), helper.getPriceFromString(actualDetails.get("total")), "Total price mismatch");
    }

}
