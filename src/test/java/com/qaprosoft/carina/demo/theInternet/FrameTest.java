package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.FramesPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class FrameTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    FramesPage framesPage = null;

    @BeforeSuite
    public void startDriver(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/nested_frames" , true);
        framesPage = new FramesPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE");
        framesPage.open();
        Assert.assertTrue(framesPage.isPageOpened(), "Page did not open.");
    }

    @Test
    public void testCheckIfFrameIsSelectedBottom() {
        framesPage.open();
        framesPage.switchToBottomFrame();
        Assert.assertEquals(framesPage.getFrameContent(), "BOTTOM", "Wrong frame");
    }
    @Test
    public void testCheckIfFrameSelectedLeft() {
        framesPage.open();
        framesPage.switchToLeftFrame();
        Assert.assertEquals(framesPage.getFrameContent(), "LEFT", "Wrong frame");
    }
}
