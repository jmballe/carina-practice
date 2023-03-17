package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DragAndDropPage extends AbstractPage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    private ExtendedWebElement boxA;
    @FindBy(id = "column-b")
    private ExtendedWebElement boxB;

    @FindBy(xpath = "//div[@id='column-a']/header")
    private ExtendedWebElement boxAHeader;
    @FindBy(xpath = "//div[@id='column-b']/header")
    private ExtendedWebElement boxBHeader;


    public ExtendedWebElement getBoxA() {
        assertElementPresent(boxA);
        return boxA;
    }

    public ExtendedWebElement getBoxB() {
        assertElementPresent(boxB);
        return boxB;
    }

    public ExtendedWebElement getBoxAHeader() {
        assertElementPresent(boxAHeader);
        return boxAHeader;
    }

    public ExtendedWebElement getBoxBHeader() {
        assertElementPresent(boxBHeader);
        return boxBHeader;
    }

    public void moveAToB(){
        Actions builder = new Actions(driver);
        builder
                .dragAndDropBy(boxA.getElement(), boxB.getLocation().getX(),boxB.getLocation().getY())
                .perform();
    }

    public void move(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n"
                + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", boxA.getElement(), boxB.getElement());
    }

    public void mover(){

    }
}
