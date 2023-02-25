package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AddRemovePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public AddRemovePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Add Element']")
    private ExtendedWebElement addElementBtn;

    @FindBy(xpath = "//button[text()='Delete']")
    private ExtendedWebElement deleteElementBtn;

    @FindBy(id = "elements")
    private ExtendedWebElement btnsContainer;

    public void clickAddElementButton(){
        LOGGER.info("Click add button.");
        addElementBtn.click();
    }
    public int countElements(){
        return btnsContainer.findExtendedWebElements(By.tagName("button")).size();
    }
    public void clickDeleteFirstElemBtn(){
        LOGGER.info("Click first element delete button.");
        deleteElementBtn.click();
    }
}
