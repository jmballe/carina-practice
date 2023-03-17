package com.qaprosoft.carina.demo.nerdWallet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.nerdWallet.HomePage;
import com.qaprosoft.carina.demo.gui.pages.nerdWallet.LoginModalPage;
import com.qaprosoft.carina.demo.gui.pages.nerdWallet.SignUpPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class WebPageTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    HomePage homePage = null;

    @BeforeSuite
    public void changePageConfig(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://www.nerdwallet.com/" , true);
    }

    @Test
    public void testOpenPage() {
        homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page did not open correctly");
    }

    @Test
    public void testClickSignUpButton() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        Assert.assertTrue(homePage.getEmailSignUpButton().isVisible(), "Email login button should be visible");
    }

    @Test
    public void testClickEmailSignUpButton() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        SignUpPage signUpPage = homePage.EmailSignUpButtonClick();
        Assert.assertTrue(signUpPage.getFirstNameBox().isVisible(), "First name box should be visible");
    }

    @Test
    public void testLogin() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        LoginModalPage loginModalPage = homePage.loginButtonClick();
        loginModalPage.inputEmail();
        loginModalPage.inputPassword();
        loginModalPage.clickContinue();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(homePage.getWelcomeMessage().isVisible(), "Welcome message should be visible.");
    }
}
