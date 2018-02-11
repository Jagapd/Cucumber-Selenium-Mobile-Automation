package com.selenium.test.pages;

import com.selenium.framework.base.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class LoginPage extends SeleniumBase {


    @FindBy(xpath = "//li[@class='nav-login']//a[@href='#']")
    public static WebElement LOGIN_BUTTON;

    @FindBy(id = "close-button")
    public WebElement DISMISS_POPUP;

    @FindBy(xpath = "//iframe[contains(@name,'_expand_iframe_')]")
    public WebElement FRAME_ID;

    @FindBy(id = "j_username")
    public static WebElement LOGIN_INPUTBOX;

    @FindBy(id = "j_password")
    public WebElement PASSWORD_INPUTBOX;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/button")
    public WebElement SUBMIT_BUTTON;

    @FindBy(xpath = "//li[@class='nav-logout']/a")
    public static WebElement LOGOUT;

    @FindBy(xpath = "//*[contains(@class,'70 background-feature big-headline')]//div[contains(@class,'views-row-odd views-row-first views')]//a[@class='block-link']")
    public static WebElement HEADLINE;

    @FindBy(xpath = "//h1[@class='headline node-title']")
    public static WebElement DETAILPAGE;

    @FindBy(xpath = "//*[contains(@class,'70 background-feature big-headline')]//div[contains(@id,'file')]//img")
    public static WebElement HOME_PAGE_IMAGE;

    @FindBy(xpath = "//picture[@class='img-responsive']//img[@class='img-responsive']")
    public static WebElement DETAIL_PAGE_IMAGE;

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public void dismisspopup() {
        getDriver().switchTo().frame(FRAME_ID);
        DISMISS_POPUP.click();
        getDriver().switchTo().defaultContent();
    }

    public void login(String username, String password) {
        LOGIN_INPUTBOX.clear();
        LOGIN_INPUTBOX.sendKeys(username);
        PASSWORD_INPUTBOX.clear();
        PASSWORD_INPUTBOX.sendKeys(password);
        SUBMIT_BUTTON.submit();

    }

    public void verifyImagePresent(WebElement element) {
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (!ImagePresent) {
            System.out.println("Image not displayed.");
            Assert.fail("Write your custom error message");
        } else {
            System.out.println("Image displayed.");
        }
    }
}
