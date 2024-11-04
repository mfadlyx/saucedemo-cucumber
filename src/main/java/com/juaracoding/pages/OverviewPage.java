package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

    private WebDriver driver;

    public OverviewPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']")
    private WebElement txtItemSauceLabsBikeLight;
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    private WebElement txtItemSauceLabsFleeceJacket;
    @FindBy(xpath = "//div[@class= 'cart_quantity']")
    private WebElement txtQuantity;
    @FindBy(xpath = "//button[@id= 'finish']")
    private WebElement btnFinish;

    public String getTxtItemSauceLabsBikeLight(){
        return txtItemSauceLabsBikeLight.getText();
    }

    public String getTxtItemSauceLabsFleeceJacket(){
        return txtItemSauceLabsFleeceJacket.getText();
    }
    public String getTxtQuantity(){
        return txtQuantity.getText();
    }

    public void setBtnFinish(){
        btnFinish.click();
    }

}
