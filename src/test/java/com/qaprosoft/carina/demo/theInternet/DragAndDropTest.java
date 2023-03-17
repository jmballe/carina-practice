package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.theInternet.DragAndDropPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class DragAndDropTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    DragAndDropPage dragAndDropPage = null;

    @BeforeSuite
    public void configurePage(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), "https://the-internet.herokuapp.com/drag_and_drop", true);
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("Testing Opening page");
        dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.open();
        dragAndDropPage.assertPageOpened();
    }

    @Test
    public void testMoveBoxes(){
        LOGGER.info("Testing moving box A content to Box B");
        dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.open();
        dragAndDropPage.move();
        Assert.assertEquals(dragAndDropPage.getBoxAHeader().getText(), "B", "Source couldnt be dropped to target.");
    }

    @Test
    public void testMoveBoxes2Times() {
        LOGGER.info("Testing moving box A content to B, 2 times");
        dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.open();
        dragAndDropPage.move();
        dragAndDropPage.move();
        Assert.assertEquals(dragAndDropPage.getBoxAHeader().getText(), "A", "Source couldnt be dropped to target.");
    }
}
