package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FormLoginPage extends AbstractPage {
    public FormLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private ExtendedWebElement usernameInput;
    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;
    @FindBy(tagName = "button")
    private ExtendedWebElement loginButton;

    @FindBy(id = "flash")
    private ExtendedWebElement loginMessage;

    public ExtendedWebElement getUsernameInput() {
        return usernameInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public ExtendedWebElement getLoginMessage() {
        return loginMessage;
    }

    public void correctLogin(){
        getUsernameInput().type("tomsmith");
        getPasswordInput().type("SuperSecretPassword!");
        getLoginButton().click();
    }

    public void badLogin(){
        getUsernameInput().type("qweqw");
        getPasswordInput().type("asdas");
        getLoginButton().click();
    }
}
