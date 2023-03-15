package com.qaprosoft.carina.demo.gui.pages.theInternet;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends AbstractPage {
    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "p")
    private ExtendedWebElement CorrectLoginResponse;


    public String generateAuthentificatedURLString(String user,String pass){
        return "https://" + user + ":" + pass + "@" + "the-internet.herokuapp.com/basic_auth";
    }

    public String getCorrectLoginText(){
        return CorrectLoginResponse.getText();
    }

}
