package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utlis.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder= 'Username']")
    private WebElement username;
    @FindBy(xpath = "//input[@placeholder= 'Password']")
    private WebElement password;
    @FindBy(xpath = "//input[@type= 'submit']")
    private WebElement btnLogin;
    @FindBy(xpath = "//h3[@data-test= 'error']")
    private WebElement txtInvalid;
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement imgCompanyBranding;

    public void loginUser(String username, String password) {
        if (this.username.getText() != null || this.password.getText() != null) {
            Utils.delay(2);
            this.username.clear();
            this.password.clear();
        }
            this.username.sendKeys(username);
            this.password.sendKeys(password);
            Utils.delay(2);
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

    public String getTxtInvalid(){
        return txtInvalid.getText();
    }

    public Boolean getImgCompanyBranding(){
        return imgCompanyBranding.isDisplayed();
    }

}
