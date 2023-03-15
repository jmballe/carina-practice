package com.qaprosoft.carina.demo.gui.pages.needWallet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='My NerdWallet Menu']")
    private ExtendedWebElement myNerdWalletButton;

    @FindBy(xpath = "(//button[@aria-label='email'])[1]")
    private ExtendedWebElement emailSignUpButton;

    @FindBy(xpath = "//label[span[contains(text(),'First name')]]/input")
    private ExtendedWebElement firstNameBox;

    @FindBy(xpath = "//label[span[contains(text(),'Last name')]]/input")
    private ExtendedWebElement lastNameBox;

    @FindBy(xpath = "//label[span[contains(text(),'Email')]]/input")
    private ExtendedWebElement emailBox;

    @FindBy(xpath = "//label[span[contains(text(),'Password')]]/div/input")
    private ExtendedWebElement passwordBox;

    @FindBy(xpath = "//button[@aria-label='continue button']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private ExtendedWebElement loginButton;

    public void myNerdWalletButtonClick(){
        myNerdWalletButton.click();
    }

    public ExtendedWebElement getEmailSignUpButton(){
        return emailSignUpButton;
    }

    public void EmailLoginButtonClick(){
        emailSignUpButton.click();
    }

    public ExtendedWebElement getFirstNameBox() {
        return firstNameBox;
    }

    public void setFirstName(String name){
        firstNameBox.type(name);
    }
}
