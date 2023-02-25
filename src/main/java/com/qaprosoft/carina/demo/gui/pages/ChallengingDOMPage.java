package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ChallengingDOMPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ChallengingDOMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".button:first-child")
    private ExtendedWebElement topButton;
    @FindBy(className = "alert")
    private ExtendedWebElement middleButton;
    @FindBy(className = "success")
    private ExtendedWebElement bottomButton;
    @FindBy(tagName = "table")
    private ExtendedWebElement table;
    @FindBy(id = "canvas")
    private ExtendedWebElement canvas;

    @FindBy(xpath = "//div/script")
    private ExtendedWebElement canvasDrawingScript;

    public void clickTopButton(){
        LOGGER.info("Click top button.");
        topButton.click();
    }
    public void clickMiddleButton(){
        LOGGER.info("Click top button.");
        middleButton.click();
    }
    public void clickBottomButton(){
        LOGGER.info("Click top button.");
        bottomButton.click();
    }

    public String getCanvasScriptText(){
        String inner = canvasDrawingScript.getAttribute("innerHTML");
        String drawNumber = inner.substring(145,154).replaceAll("[a-z']+","").strip();
        LOGGER.info("Number in canvas: " + drawNumber);
        return drawNumber;
    }



}
