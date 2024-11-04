package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']")
    private WebElement txtItemSauceLabsBikeLight;
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    private WebElement txtItemSauceLabsFleeceJacket;
    @FindBy(xpath = "//button[@class= 'btn btn_action btn_medium checkout_button ']")
    private WebElement btnCheckout;

    public String getTxtItemSauceLabsBikeLight(){
        return txtItemSauceLabsBikeLight.getText();
    }

    public String getTxtItemSauceLabsFleeceJacket(){
        return txtItemSauceLabsFleeceJacket.getText();
    }

    public void setBtnCheckout(){
        btnCheckout.click();
    }
}
