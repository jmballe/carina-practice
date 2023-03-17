package com.qaprosoft.carina.demo.gui.pages.nerdWallet;

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

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'Welcome, eric')]")
    private ExtendedWebElement welcomeMessage;

    public void myNerdWalletButtonClick(){
        myNerdWalletButton.click();
    }

    public ExtendedWebElement getEmailSignUpButton(){
        return emailSignUpButton;
    }

    public ExtendedWebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public SignUpPage EmailSignUpButtonClick(){
        emailSignUpButton.click();
        return new SignUpPage(driver);
    }

    public LoginModalPage loginButtonClick(){
        loginButton.click();
        return new LoginModalPage(driver);
    }


}
