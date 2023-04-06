package com.qaprosoft.carina.demo.demoQA;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.demoQA.DroppablePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DroppableTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testOpenPage() {
        DroppablePage droppablePage = new DroppablePage(getDriver());
        droppablePage.open();
        Assert.assertTrue(droppablePage.isPageOpened(), "Page did not open correctly");
    }

    @Test
    public void testDragAndDrop() {
        LOGGER.info("Testing dropping in zone.");
        DroppablePage droppablePage = new DroppablePage(getDriver());
        droppablePage.open();
        Assert.assertTrue(droppablePage.isPageOpened(), "Page did not open correctly");
        droppablePage.dropItemInZone();
        Assert.assertEquals(droppablePage.getDropZone().getText(),"Dropped!" , "Drag and drop failed.");
    }
}

