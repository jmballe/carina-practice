package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AddRemovePage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddRemoveTest implements IAbstractTest {
    AddRemovePage addRemovePage = null;

    @BeforeSuite
    public void startDriver(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/add_remove_elements/" , true);
        addRemovePage = new AddRemovePage(getDriver());
    }

    @Test
    public void testOpenPage() {
        //Open https://the-internet.herokuapp.com/add_remove_elements/ page.
        addRemovePage.open();
        Assert.assertTrue(addRemovePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    public void testAddFirstElement(){
        addRemovePage.open();
        addRemovePage.clickAddElementButton();
        Assert.assertEquals(addRemovePage.countElements(),1, "The count was not the expected one.");
    }

    @Test
    public void testDeleteFirstElement(){
        addRemovePage.open();
        addRemovePage.clickAddElementButton();
        addRemovePage.clickDeleteFirstElemBtn();
        Assert.assertEquals(addRemovePage.countElements(), 0, "The count was not the expected one.");
    }

}
