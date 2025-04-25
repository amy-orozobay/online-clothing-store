package com.onlineclothingstore.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr")
    protected List<WebElement> productsInCartList;

    public List<String> getCartItemDetails(int itemNumber) {
        WebElement productName = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_description']//h4"));
        WebElement price = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_price']"));
        WebElement quantity = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_quantity']"));
        WebElement total = driver.findElement(By.xpath("//tr[@id='product-" + itemNumber + "']//td[@class='cart_total']"));
        List<String> cartItemDetails = new ArrayList<>();
        cartItemDetails.addFirst(productName.getText());
        cartItemDetails.add(1, price.getText());
        cartItemDetails.add(2, quantity.getText());
        String totalPrice = total.getText();
        cartItemDetails.add(3, totalPrice.substring(totalPrice.indexOf(".")+2));
        return cartItemDetails;
    }
}
