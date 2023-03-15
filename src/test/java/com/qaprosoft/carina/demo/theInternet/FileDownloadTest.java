package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.theInternet.FileDownloadPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;

public class FileDownloadTest implements IAbstractTest {
    FileDownloadPage fileDownloadPage = null;

    @BeforeSuite
    public void startDriver() {
        R.CONFIG.put(Configuration.Parameter.URL.getKey(), "https://the-internet.herokuapp.com/download"
                , true);
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        fileDownloadPage = new FileDownloadPage(getDriver("chrome",options));
    }

    @Test
    public void testOpenPage() {
        fileDownloadPage.open();
        Assert.assertTrue(fileDownloadPage.isPageOpened(), "Page did not open.");
    }

}
