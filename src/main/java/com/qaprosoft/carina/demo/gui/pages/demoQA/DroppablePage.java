package com.qaprosoft.carina.demo.gui.pages.demoQA;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.demoQA.components.LeftPanelMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends AbstractPage {
    public DroppablePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://demoqa.com/droppable");
    }

    @FindBy(className = "left-pannel")
    private LeftPanelMenu leftPanel;
    @FindBy(id = "draggable")
    private ExtendedWebElement draggableItem;

    @FindBy(id = "droppable")
    private ExtendedWebElement dropZone;

    public ExtendedWebElement getDraggableItem() {
        return draggableItem;
    }

    public ExtendedWebElement getDropZone() {
        return dropZone;
    }

    public void dropItemInZone(){
        Actions builder = new Actions(driver);
        builder
                .dragAndDrop(getDraggableItem().getElement(),getDropZone().getElement())
                .perform();
    }
}
