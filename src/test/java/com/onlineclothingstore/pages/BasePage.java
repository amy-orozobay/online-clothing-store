package com.onlineclothingstore.pages;

import com.onlineclothingstore.utils.BrowserHelper;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    BrowserHelper helper = new BrowserHelper();

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[1]")
    protected WebElement homeBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[2]")
    protected WebElement productsBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[3]")
    protected WebElement cartBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
    protected WebElement signupLoginBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]")
    protected WebElement testCasesBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[6]")
    protected WebElement apiTestingBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[7]")
    protected WebElement videoTutorialsBtn;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[8]")
    protected WebElement contactUsBtn;
    @FindBy(xpath = "//a[@href='/delete_account']")
    protected WebElement deleteAccountLink;

    public void goToCartPage() {
        helper.waitForVisibilityOfElement(driver, cartBtn, 10).click();
    }

    public void goToSignupLoginPage() {
        helper.waitForVisibilityOfElement(driver, signupLoginBtn, 10).click();
    }

    public void goToProductsPage() {
        helper.waitForVisibilityOfElement(driver, productsBtn, 20).click();
    }


    //visible only when signed in
public void clickDeleteAccountLink() {
    // hide all adds which interfering click
    ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll(\"iframe, div[id^='aswift'], ins.adsbygoogle\").forEach(el => el.style.display = 'none');"
    );

    // wait for visibility
    WebElement link = helper.waitForVisibilityOfElement(driver, deleteAccountLink, 10);

    // scroll to link
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", link);

    // click through JS, just in case
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
}


}
