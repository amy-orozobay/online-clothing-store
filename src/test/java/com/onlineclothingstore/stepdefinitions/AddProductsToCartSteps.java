package com.onlineclothingstore.stepdefinitions;

import com.onlineclothingstore.pages.ProductsPage;
import com.onlineclothingstore.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductsToCartSteps {
    WebDriver driver = Driver.getDriver();

    private ProductsPage productsPage = new ProductsPage(driver);

    @Given("the user navigated to the {string} page")
    public void the_user_navigated_to_the_page(String pageName) {
        if (pageName.equalsIgnoreCase("Products")) {
            productsPage.goToProductsPage();
            //validate we are in products page
            String currentTitle = driver.getTitle();
            assertEquals("Automation Exercise - All Products", currentTitle, "Title mismatch");
        }
    }

    @When("the user adds {string} products to the cart")
    public void the_user_adds_products_to_the_cart(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able to access the cart via cart icon and cart page URL")
    public void the_user_should_be_able_to_access_the_cart_via_cart_icon_and_cart_page_url() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the cart should display product name, quantity, price, and total for each item")
    public void the_cart_should_display_product_name_quantity_price_and_total_for_each_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
