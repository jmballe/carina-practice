package com.qaprosoft.carina.demo.gui.pages.nerdWallet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

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

    public ExtendedWebElement getFirstNameBox() {
        return firstNameBox;
    }

    public void setFirstName(String name){
        firstNameBox.type(name);
    }
}
