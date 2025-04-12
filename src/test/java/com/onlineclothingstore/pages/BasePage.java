package com.onlineclothingstore.pages;

import com.onlineclothingstore.utils.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    //other pages extend this class
    //here also have menu elements that appear in each page
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    BrowserHelper helper = new BrowserHelper(driver);

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[1]")
    protected WebElement homeBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[2]")
    protected WebElement productsBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[3]")
    protected WebElement cartBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
    protected WebElement signUpLoginBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]")
    protected WebElement testCasesBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[6]")
    protected WebElement apiTestingBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[7]")
    protected WebElement videoTutorialsBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[8]")
    protected WebElement contactUsBtn;

    public void goToCartPage() {
        helper.waitForVisibilityOfElement(cartBtn, 10).click();
    }

    public void goToSignUpLoginPage() {
        helper.waitForVisibilityOfElement(signUpLoginBtn, 10).click();
    }

    public void goToProductsPage() {
        helper.waitForVisibilityOfElement(productsBtn, 10).click();
    }
}
