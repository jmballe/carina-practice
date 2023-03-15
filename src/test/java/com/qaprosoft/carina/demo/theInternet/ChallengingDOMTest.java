package com.qaprosoft.carina.demo.theInternet;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.pages.theInternet.ChallengingDOMPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ChallengingDOMTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    ChallengingDOMPage challengingDOMPage = null;

    @BeforeSuite
    public void startDriver(){
        R.CONFIG.put(Configuration.Parameter.URL.getKey(),"https://the-internet.herokuapp.com/challenging_dom" , true);
        challengingDOMPage = new ChallengingDOMPage(getDriver());
    }

    @Test
    public void testOpenPage() {
        LOGGER.info("TESTING OPENING PAGE IN DRIVER");
        challengingDOMPage.open();
        Assert.assertTrue(challengingDOMPage.isPageOpened(), "Page did not opened.");
    }

    @Test
    public void testGetCanvasText() {
        LOGGER.info("TESTING GETTING CANVAS OUTPUT");
        challengingDOMPage.open();
        challengingDOMPage.getCanvasScriptText();
    }

    @Test
    public void testTopButtonClick() {
        LOGGER.info("TESTING TOP BUTTON CLICK");
        challengingDOMPage.open();
        String originalId = challengingDOMPage.getTopButtonId();
        challengingDOMPage.clickTopButton();
        Assert.assertNotEquals(challengingDOMPage.getTopButtonId(), originalId, "Button id must change with each click.");
    }

    @Test
    public void testMiddleButtonClick() {
        LOGGER.info("TESTING MIDDLE BUTTON CLICK");
        challengingDOMPage.open();
        String originalId = challengingDOMPage.getMiddleButtonId();
        challengingDOMPage.clickMiddleButton();
        Assert.assertNotEquals(challengingDOMPage.getMiddleButtonId(), originalId, "Button id must change with each click.");
    }

    @Test
    public void testBottomButtonClick() {
        LOGGER.info("TESTING BOTTOM BUTTON CLICK");
        challengingDOMPage.open();
        String originalId = challengingDOMPage.getBottomButtonId();
        challengingDOMPage.clickBottomButton();
        Assert.assertNotEquals(challengingDOMPage.getBottomButtonId(), originalId,
                "Button id must change with each click.");
    }

    @Test
    public void testCanvasTextChange() {
        LOGGER.info("TESTING CANVAS TEXT CHANGE");
        challengingDOMPage.open();
        String originalCanvasText = challengingDOMPage.getCanvasScriptText();
        challengingDOMPage.clickTopButton();
        Assert.assertNotEquals(challengingDOMPage.getCanvasScriptText(),
                originalCanvasText, "The text must change after button click.");
    }

    @Test
    public void testTableHeaders() {
        LOGGER.info("TESTING TABLE HEADERS");
        challengingDOMPage.open();
        List<ExtendedWebElement> headers= challengingDOMPage.getTableHeaders();
        String[] headersLit = {"Lorem","Ipsum","Dolor","Sit","Amet","Diceret","Action"};
        for (int i = 0; i< headersLit.length;i++) {
            Assert.assertEquals(headers.get(i).getText(),headersLit[i] ,"Table Header not right");
        }
    }

    @Test
    public void testTableFirstColumn() {
        LOGGER.info("TESTING FIRST COLUMN");
        challengingDOMPage.open();
        List<String> firstColumn = List.of("Iuvaret0","Iuvaret1","Iuvaret2","Iuvaret3","Iuvaret4",
                "Iuvaret5","Iuvaret6","Iuvaret7","Iuvaret8","Iuvaret9");
        Assert.assertEquals(challengingDOMPage.getColumnN(0), firstColumn,"First column not correct.");
    }
}
