package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends AbstractPage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    private ExtendedWebElement clickableBox;


    public ExtendedWebElement getClickableBox() {
        assertElementPresent(clickableBox);
        return clickableBox;
    }

    public void rightClickOnBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(getClickableBox().getElement()).perform();
    }

    //Used acceptAlert from carina instead.
    public void acceptJsAlert(){
        driver.switchTo().alert().accept();
    }


    public void getTextAlert(){
        driver.switchTo().alert().getText();
    }
}
