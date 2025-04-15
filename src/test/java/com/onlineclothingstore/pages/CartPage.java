package com.onlineclothingstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr")
    protected List<WebElement> productsInCartList;

    public Map<String, String> getCartItemDetails(int itemNumber) {
        WebElement productName = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_description']//h4"));
        WebElement price = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_price']"));
        WebElement quantity = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_quantity']"));
        WebElement total = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_total']"));
        Map<String, String> cartItemDetails = new HashMap<>();
        cartItemDetails.put("productName", productName.getText());
        cartItemDetails.put("price", price.getText());
        cartItemDetails.put("quantity", quantity.getText());
        cartItemDetails.put("total", total.getText());
        return cartItemDetails;
    }
}
