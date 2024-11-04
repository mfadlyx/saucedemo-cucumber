package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class= 'title']")
    private WebElement txtCheckoutYourInformation;
    @FindBy(xpath = "//input[@id= 'first-name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id= 'last-name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id= 'postal-code']")
    private WebElement postalCode;
    @FindBy(xpath = "//input[@type= 'submit']")
    private WebElement btnContinue;

    //erro required apabila tidak mengisi form
    @FindBy(xpath = "//h3[@data-test= 'error']")
    private WebElement txtErrorRequired;

    public void userInformation(String firstName, String lastname, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastname);
        this.postalCode.sendKeys(postalCode);
    }


    public String getTxtCheckoutYourInformation(){
        return txtCheckoutYourInformation.getText();
    }

    public void setBtnContinue(){
        btnContinue.click();
    }

    public String getTxtErrorRequired(){
        return txtErrorRequired.getText();
    }

}
