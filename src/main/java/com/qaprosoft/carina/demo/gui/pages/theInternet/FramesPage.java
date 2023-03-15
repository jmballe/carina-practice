package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FramesPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name= "frame-top")
    private ExtendedWebElement frameTop;

    @FindBy(name = "frame-left")
    private ExtendedWebElement frameLeft;
    @FindBy(name = "frame-middle")
    private ExtendedWebElement frameMiddle;
    @FindBy(name = "frame-right")
    private ExtendedWebElement frameRight;
    @FindBy(name = "frame-bottom")
    private ExtendedWebElement frameBottom;

    private void switchToTopFrame(){
        assertElementPresent(frameTop);
        driver.switchTo().frame(frameTop.getElement());
    }

    public void switchToBottomFrame(){
        assertElementPresent(frameBottom);
        driver.switchTo().frame(frameBottom.getElement());
    }
    public void switchToLeftFrame(){
        LOGGER.info("Switching to left frame");
        switchToTopFrame();
        assertElementPresent(frameLeft);
        driver.switchTo().frame(frameLeft.getElement());
    }
    public void switchToRightFrame(){
        assertElementPresent(frameRight);
        driver.switchTo().frame(frameRight.getElement());
    }
    public void switchToMiddleFrame(){
        assertElementPresent(frameMiddle);
        driver.switchTo().frame(frameMiddle.getElement());
    }

    public String getFrameContent(){
        return driver.findElement(By.tagName("body")).getText();
    }



}
