package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends AbstractPage {
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[1]")
    private ExtendedWebElement firstCheckBox;
    @FindBy(xpath = "//input[2]")
    private ExtendedWebElement secondCheckBox;

    public ExtendedWebElement getFirstCheckBox() {
        assertElementPresent(firstCheckBox);
        return firstCheckBox;
    }

    public ExtendedWebElement getSecondCheckBox() {
        assertElementPresent(secondCheckBox);
        return secondCheckBox;
    }

    public void clickFirstCheckbox(){
        firstCheckBox.click();
    }

    public void clickSecondCheckbox(){
        secondCheckBox.click();
    }
}
