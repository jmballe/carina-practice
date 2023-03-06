package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.ContextMenuPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ContextMenuTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    ContextMenuPage contextMenuPage = null;

    @BeforeSuite
    public void startDriver() {
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), "https://the-internet.herokuapp.com/context_menu", true);
        contextMenuPage = new ContextMenuPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE ");
        contextMenuPage.open();
    }

    @Test
    public void testAlertOpening() {
        LOGGER.info("TESTING ALERT OPENING AFTER RIGHT CLICK ");
        contextMenuPage.open();
        contextMenuPage.rightClickOnBox();
        Assert.assertTrue(contextMenuPage.isAlertPresent(), "Alert did not open.");
    }

    @Test
    public void testAcceptAlert() {
        LOGGER.info("TESTING ALERT CLOSING AFTER ACCEPTING. ");
        contextMenuPage.open();
        contextMenuPage.rightClickOnBox();
        contextMenuPage.acceptAlert();
        Assert.assertFalse(contextMenuPage.isAlertPresent(), "Alert must not be present.");
    }
}
