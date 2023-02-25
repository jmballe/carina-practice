package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='example']/img")
    private List<ExtendedWebElement> imagesList;

    public int countElements(){
        return imagesList.size();
    }

    public List<Boolean> checkImages(){
        List<Boolean> brokenImages = new ArrayList<>();
        for (var i:
             imagesList) {
            try {
                //get URL of links with getAttribute()
                String linkText = i.getAttribute("src");
                URL link = new URL(linkText);
                HttpURLConnection con = (HttpURLConnection)link.openConnection();
                //have timeout
                con.setConnectTimeout(1000);
                // connection began
                con.connect();
                //getResponseCode() to obtain response code
                if(con.getResponseCode()== 200) {
                    LOGGER.info(linkText+" − "+ con.getResponseMessage());
                }
                if(con.getResponseCode()== 404) {
                    brokenImages.add(true);
                    LOGGER.info(linkText+" − "+con.getResponseMessage());
                }
            } catch (IOException e) {
                LOGGER.error(e.toString());
            }
        }
        return brokenImages;
    }


}
