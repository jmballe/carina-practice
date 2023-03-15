package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.theInternet.HoversPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class HoversTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    HoversPage hoversPage = null;

    @BeforeSuite
    public void starDriver(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/hovers" , true);
        hoversPage = new HoversPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE");
        hoversPage.open();
        Assert.assertTrue(hoversPage.isPageOpened(), "Page did not open correctly.");
    }

    @Test
    public void testCheckHoverableFirstElement() {
        LOGGER.info("TESTING HOVER-ABLE ELEMENT IS NOT CLICKABLE WHILE NOT SHOWING.");
        hoversPage.open();
        Assert.assertFalse(hoversPage.getFirstCaption().isVisible(), "Element must not be clickable.");
    }

    @Test
    public void testCheckHoverableFirstElementClickable() throws InterruptedException {
        LOGGER.info("TESTING HOVER-ABLE ELEMENT IS CLICKABLE WHILE HOVER ACTIVE");
        hoversPage.open();
        getDriver().manage().window().maximize();
        hoversPage.hoverFirstFigure();
        Assert.assertTrue(hoversPage.getFirstCaption().isVisible(), "Link must be clickable.");
    }

}
