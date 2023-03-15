package com.qaprosoft.carina.demo.nerdWallet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.needWallet.HomePage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebPageTest implements IAbstractTest {
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
    public void testClickLoginButton() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        Assert.assertTrue(homePage.getEmailSignUpButton().isVisible(), "Email login button should be visible");
    }

    @Test
    public void testClickEmailLoginButton() {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        homePage.EmailLoginButtonClick();
        Assert.assertTrue(homePage.getFirstNameBox().isVisible(), "First name box should be visible");
    }

    @Test
    public void testInsertFirstNameInBox() throws InterruptedException {
        homePage = new HomePage(getDriver());
        homePage.open();
        homePage.myNerdWalletButtonClick();
        homePage.EmailLoginButtonClick();
        homePage.setFirstName("Tim");
        Thread.sleep(2000);
    }
}
