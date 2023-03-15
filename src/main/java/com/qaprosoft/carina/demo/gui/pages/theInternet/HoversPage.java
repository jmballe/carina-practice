package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HoversPage extends AbstractPage {

    public HoversPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "(//div[@class='figure'])[1]")
    private ExtendedWebElement firstFigure;

    @FindBy(xpath = "(//div[@class='figure'])[2]")
    private ExtendedWebElement secondFigure;

    @FindBy(xpath = "(//div[@class='figure'])[3]")
    private ExtendedWebElement thirdFigure;

    @FindBy(xpath = "(//div[@class='figcaption'])[1]")
    private ExtendedWebElement firstCaption;

    @FindBy(xpath = "(//div[@class='figcaption'])[2]")
    private ExtendedWebElement secondCaption;

    @FindBy(xpath = "(//div[@class='figcaption'])[3]")
    private ExtendedWebElement thirdCaption;

    @FindBy(xpath = "(//div[@class='figcaption']/a)[1]")
    private ExtendedWebElement firstElementHiddenLink;

    public void hoverFirstFigure(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstFigure.getElement()).perform();
    }

    public void hoverSecondFigure(){
        Actions actions = new Actions(driver);
        actions.moveToElement(secondFigure.getElement()).perform();
    }

    public void hoverThirdFigure(){
        Actions actions = new Actions(driver);
        actions.moveToElement(thirdFigure.getElement()).perform();
    }

    public ExtendedWebElement getFirstCaption(){
        return firstCaption;
    }

    public ExtendedWebElement getSecondCaption(){
        return secondCaption;
    }

    public ExtendedWebElement getThirdCaption(){
        return thirdCaption;
    }
}
