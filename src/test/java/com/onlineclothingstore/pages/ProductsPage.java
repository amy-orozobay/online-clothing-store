package com.onlineclothingstore.pages;


import com.onlineclothingstore.utils.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    BrowserHelper helper = new BrowserHelper();

    @FindBy(xpath = "//div[@class='single-products']")
    protected List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']")
    protected WebElement addedToCartConfirmation;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']//button")
    protected WebElement continueShoppingBtn;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']//p[1]")
    protected WebElement addedToCartMessage;

    public void addGivenProductToCart(int productNumber) {
        helper.removeAdIframes(driver);
        // 1. Remove BOTH the iframe AND its host container
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.querySelectorAll('iframe[id^=\"aswift_\"], div[id$=\"_host\"]')" +
                        ".forEach(el => el.remove());"
        );
        WebElement productNumberAddToCartBtn = driver.findElement(By.xpath("//a[@data-product-id='" + productNumber + "'][1]"));
        helper.scrollElementIntoView(driver, productNumberAddToCartBtn);
        helper.waitForElementToBeClickable(driver, productNumberAddToCartBtn);
        helper.tripleClickElement(productNumberAddToCartBtn, js);
//        helper.waitForVisibilityOfElement(driver, productNumberAddToCartBtn, 10).click();
    }

    public String getAddedToCartMessageText() {
        helper.waitForVisibilityOfElement(driver, addedToCartMessage, 10);
        return addedToCartMessage.getText();
    }

    public void clickContinueShoppingBtnAfterAddingToCart() {
        helper.waitForVisibilityOfElement(driver, continueShoppingBtn, 10).click();
    }

    public Map<String, String> getProductDetails(int productId, int quantity) {
        Map<String, String> productDetails = new HashMap<>();
        WebElement product = allProducts.get(productId - 1);
        WebElement name = product.findElement(By.xpath(".//p"));
        productDetails.put("productName", name.getText());
        WebElement price = product.findElement(By.xpath(".//h2"));
        productDetails.put("price", price.getText());
        productDetails.put("quantity", Integer.toString(quantity));
        int total = quantity * helper.getIntPriceFromElement(price);
        productDetails.put("total", Integer.toString(total));
        return productDetails;
    }
}
