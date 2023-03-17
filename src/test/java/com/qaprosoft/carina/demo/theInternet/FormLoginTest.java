package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.theInternet.FormLoginPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.text.Normalizer;

public class FormLoginTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeSuite
    public void SetPage(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), "https://the-internet.herokuapp.com/login", true);
    }

    @Test
    public void testOpenPage() {
        FormLoginPage formLoginPage = new FormLoginPage(getDriver());
        formLoginPage.open();
        formLoginPage.assertPageOpened();
    }

    @Test
    public void testBadLogin() {
        FormLoginPage formLoginPage = new FormLoginPage(getDriver());
        formLoginPage.open();
        formLoginPage.badLogin();
        Assert.assertTrue(formLoginPage.getLoginMessage().getText().contains("Your username is invalid!"),"Problem with error message");
    }

    @Test
    public void testCorrectLogin() {
        FormLoginPage formLoginPage = new FormLoginPage(getDriver());
        formLoginPage.open();
        formLoginPage.correctLogin();
        Assert.assertTrue(formLoginPage.getLoginMessage().getText().contains("You logged into a secure area!"), "Problem with login message");
    }
}
