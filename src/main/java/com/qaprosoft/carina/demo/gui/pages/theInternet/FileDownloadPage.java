package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FileDownloadPage extends AbstractPage {
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"example\"]/a")
    private List<ExtendedWebElement> filesLinks;

    public ExtendedWebElement getFileN(int n){
        return filesLinks.get(n);
    }

    public void clickElementN(int n){
        getFileN(n).click();
    }
}
