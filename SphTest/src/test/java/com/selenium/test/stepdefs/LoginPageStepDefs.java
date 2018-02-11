package com.selenium.test.stepdefs;

import com.selenium.test.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;

import static com.selenium.test.pages.LoginPage.*;


public class LoginPageStepDefs {

    @Autowired
    public LoginPage loginPage;

    @Given("^I open 'straites'$")
    public void iOpenStraites() throws Throwable {
        loginPage.getURL("/singapore");
        loginPage.waitForPageLoaded(100);
        loginPage.dismisspopup();
        loginPage.assertElementPresent(LOGIN_BUTTON);

    }

    @Then("^click on login button$")
    public void clickOnLoginButton() throws Throwable {
        LOGIN_BUTTON.click();
        loginPage.assertElementPresent(LOGIN_INPUTBOX);

    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String username, String password) throws Throwable {
            loginPage.login(username, password);
            loginPage.waitForPageLoaded(10);

        }


        @Then("^Verify the user has been logged in$")
        public void verifyTheUserHasBeenLoggedIn () throws Throwable {
            loginPage.assertElementPresent(LOGOUT);
            loginPage.waitForPageLoaded(10);

        }

        @Then("^Verify that the main article has a picture/video$")
        public void verifyThatTheMainArticleHasAPictureVideo () throws Throwable {

            loginPage.verifyImagePresent(HOME_PAGE_IMAGE);

        }

        @And("^User  Click on the main article$")
        public void userClickOnTheMainArticle () throws Throwable {
            HEADLINE.click();
            loginPage.waitForPageLoaded(10);
        }

        @Then("^Verify page has been navigated to the main article, and the picture/video is present in the article$")
        public void verifyPageHasBeenNavigatedToTheMainArticleAndThePictureVideoIsPresentInTheArticle () throws
        Throwable {
            loginPage.assertElementPresent(DETAILPAGE);
            loginPage.verifyImagePresent(DETAIL_PAGE_IMAGE);
        }
    }
