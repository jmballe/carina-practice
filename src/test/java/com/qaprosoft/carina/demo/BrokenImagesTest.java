package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.BrokenImagesPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrokenImagesTest implements IAbstractTest {
    BrokenImagesPage brokenImgPage = null;

    @BeforeSuite
    public void startDriver() {
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/broken_images" , true);
        brokenImgPage = new BrokenImagesPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        brokenImgPage.open();
        Assert.assertTrue(brokenImgPage.isPageOpened(), "Page is not opened.");
    }

    @Test
    public void testCountImages() {
        brokenImgPage.open();
        Assert.assertEquals(brokenImgPage.countElements(),3,"The number of images is incorrect.");
    }

    @Test
    public void testBrokenImages() {
        brokenImgPage.open();
        Assert.assertTrue(brokenImgPage.checkImages().size() > 0, "There are no broken images." );
    }
}
