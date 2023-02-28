package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

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


    public String getTopButtonId(){
        return topButton.getAttribute("id");
    }

    public String getMiddleButtonId(){
        return middleButton.getAttribute("id");
    }
    public String getBottomButtonId(){
        return bottomButton.getAttribute("id");
    }

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

    public List<ExtendedWebElement> getTableHeaders(){
        return table.findExtendedWebElements(By.cssSelector("thead tr th"));
    }

    public List<String> getColumnN(int n){
        if (n < 6 && n >= 0){
            List<String> column = new ArrayList<>();
            for(int i = 1;i <= 10;i++){
                column.add(table.findExtendedWebElement(By.xpath("//tbody/tr[" + i + "]/td[" + (n+1) +"]")).getText());
            }
            return column;
        } else {
            return new ArrayList<String>();
        }
    }

}
