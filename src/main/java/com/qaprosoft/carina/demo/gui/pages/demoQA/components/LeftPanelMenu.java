package com.qaprosoft.carina.demo.gui.pages.demoQA.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.demoQA.DroppablePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LeftPanelMenu extends AbstractUIObject {
    public LeftPanelMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//div[@class='header-text'][contains(text(),'Interactions')]")
    private ExtendedWebElement Interactions;

    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    private ExtendedWebElement droppable;

    public DroppablePage clickDroppable(){
        droppable.click();
        return new DroppablePage(driver);
    }

}
