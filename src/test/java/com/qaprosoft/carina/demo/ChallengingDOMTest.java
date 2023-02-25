package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.demo.gui.pages.ChallengingDOMPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ChallengingDOMTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    ChallengingDOMPage challengingDOMPage = null;

    @BeforeSuite
    public void startDriver(){
        challengingDOMPage = new ChallengingDOMPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE IN DRIVER");
        challengingDOMPage.open();
        Assert.assertTrue(challengingDOMPage.isPageOpened(), "Page did not opened.");
    }

    @Test
    public void testGetCanvasText() throws InterruptedException {
        LOGGER.info("TESTING GETTING CANVAS OUTPUT");
        challengingDOMPage.open();
        challengingDOMPage.getCanvasScriptText();
        Thread.sleep(5000);
    }
}
