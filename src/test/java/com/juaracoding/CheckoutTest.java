package com.juaracoding;

import com.juaracoding.pages.*;
import com.juaracoding.utlis.Contants;
import com.juaracoding.utlis.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {

    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    private static HomePage homePage = new HomePage();

    private static CartPage cartPage = new CartPage();

    private static CheckoutPage checkoutPage = new CheckoutPage();

    private static OverviewPage overviewPage = new OverviewPage();

    private static FinishPage finishPage = new FinishPage();

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am logged in to the website with username {string} and password {string}")
    public void i_am_logged_in_to_the_website_with_username_and_password(String username, String password){
        driver.get(Contants.URL);
        loginPage.getImgCompanyBranding();
        Assert.assertEquals(driver.getCurrentUrl(), Contants.URL);
        loginPage.loginUser(username, password);
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in to the website with username "+username+" and password "+password);
    }

    @And("I am on the item page")
    public void i_am_on_the_product_page(){
        Assert.assertEquals(homePage.getTxtDashboard(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        extentTest.log(LogStatus.PASS, "I am on the item page");
    }

    @When("I add a items to the cart")
    public void i_add_a_items_to_the_cart(){
        homePage.setBtnAddToCartSauceLabsBikeLight();
        homePage.setBtnAddToCartSauceLabsFleeceJacket();
        Assert.assertEquals(homePage.getTxtShopCartBadge(),"2");
        Assert.assertEquals(homePage.getTxtRemoveYourCart(), "Remove");
        extentTest.log(LogStatus.PASS, "I add a items to the cart");
    }

    @And("I clicked on the cart to view the item and tried to checkout")
    public void i_click_on_the_cart_to_see_the_items(){
        homePage.setBtnToCartLink();
        Utils.delay(3);
        Assert.assertEquals(cartPage.getTxtItemSauceLabsBikeLight(), "Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getTxtItemSauceLabsFleeceJacket(), "Sauce Labs Fleece Jacket");
        cartPage.setBtnCheckout();
        extentTest.log(LogStatus.PASS, "I clicked on the cart to view the item and tried to checkout");
    }

    @And("I enter firstname {string}, lastname {string}, postalcode {string}")
    public void i_filled_out_the_form_provided(String firstName, String lastName, String postalCode){
        Assert.assertEquals(checkoutPage.getTxtCheckoutYourInformation(), "Checkout: Your Information");
        checkoutPage.userInformation(firstName, lastName, postalCode);
        extentTest.log(LogStatus.PASS, "I enter firstname "+firstName+", lastname "+lastName+", postalcode "+postalCode);
    }

    @And("I click the button continue")
    public void i_click_the_button_continue(){
        checkoutPage.setBtnContinue();
        extentTest.log(LogStatus.PASS, " I click the button continue");
    }

    @And("I click the button finish")
    public void i_click_the_button_finish(){
        Assert.assertEquals(overviewPage.getTxtItemSauceLabsBikeLight(), "Sauce Labs Bike Light");
        Assert.assertEquals(overviewPage.getTxtItemSauceLabsFleeceJacket(), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(overviewPage.getTxtQuantity(), "1");
        overviewPage.setBtnFinish();
        extentTest.log(LogStatus.PASS, "I click the button finish");
    }

    @Then("I see the complete page")
    public void i_see_the_complete_page(){
        Assert.assertEquals(finishPage.getTxtOrder(), "Thank you for your order!");
        extentTest.log(LogStatus.PASS, "I see the complete page");
    }

    @And("I don't fill in firstname {string}, lastname {string}, postalcode {string}")
    public void i_did_not_fill_out_the_form_provide(String firstName, String lastName, String postalCode){
        Utils.delay(2);
        checkoutPage.userInformation(firstName, lastName, postalCode);
        extentTest.log(LogStatus.PASS, "I don't fill in firstname "+firstName+", lastname "+lastName+", postalcode "+postalCode);
    }

    @And("I click the continue button")
    public void i_click_the_continue_button(){
        checkoutPage.setBtnContinue();
        extentTest.log(LogStatus.PASS, "I click the continue button");
    }

    @Then("Alert with message {string} will appear")
    public void alert_with_message_will_appear(String expectedErrorMessage){
        Assert.assertTrue(checkoutPage.getTxtErrorRequired().contains(expectedErrorMessage));
        extentTest.log(LogStatus.PASS, "Alert with message "+expectedErrorMessage+" will appear");
    }
}
