package com.qaprosoft.carina.demo.gui.pages.nerdWallet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModalPage extends AbstractPage {
    public LoginModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[span[contains(text(),'Email address')]]/input")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//label[span[contains(text(),'Password')]]/div/input")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private ExtendedWebElement checkboxKeepLogged;

    @FindBy(xpath = "//button[@aria-label = 'continue button']")
    private ExtendedWebElement continueButton;

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public ExtendedWebElement getCheckboxKeepLogged() {
        return checkboxKeepLogged;
    }

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    public void inputEmail(){
        emailInput.type("xcufmkot@signupaddress.com");
    }

    public void inputPassword(){
        passwordInput.type("testPass12345");
    }

    public void keepLogged(){
        checkboxKeepLogged.check();
    }

    public void clickContinue(){
        continueButton.click();
    }
}
