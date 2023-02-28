package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.CheckboxesPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class CheckboxesTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    CheckboxesPage checkboxesPage = null;

    @BeforeSuite
    public void startDriver(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/checkboxes" , true);
        checkboxesPage = new CheckboxesPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE");
        checkboxesPage.open();
        Assert.assertTrue(checkboxesPage.isPageOpened(), "Page did not open correctly");
    }

    @Test
    public void testClickFirstCheckbox() {
        LOGGER.info("TESTING CLICKING FIRST CHECKBOX");
        checkboxesPage.open();
        checkboxesPage.clickFirstCheckbox();
        Assert.assertTrue(checkboxesPage.getFirstCheckBox().isChecked(),
                "The first checkbox must be checked after being clicked.");
    }

    @Test
    public void testClickSecondCheckbox() {
        LOGGER.info("TESTING CLICKING FIRST CHECKBOX");
        checkboxesPage.open();
        checkboxesPage.clickSecondCheckbox();
        Assert.assertFalse(checkboxesPage.getSecondCheckBox().isChecked(),
                "The second checkbox must not be checked after being clicked.");
    }
}
