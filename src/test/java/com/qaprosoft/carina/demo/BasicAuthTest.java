package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAuthTest implements IAbstractTest {
    BasicAuthPage basicAuthPage = null;

    @BeforeSuite
    public void startDriver(){
        basicAuthPage = new BasicAuthPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        basicAuthPage.open();
        Assert.assertTrue(basicAuthPage.isPageOpened(), "Page did not open correctly.");
    }

    @Test
    public void testCorrectLogin() {
        basicAuthPage.open();
        getDriver().get(basicAuthPage.generateAuthentificatedURLString("admin", "admin"));
        Assert.assertEquals(basicAuthPage.getCorrectLoginText(),
                "Congratulations! You must have the proper credentials.");
    }
}
