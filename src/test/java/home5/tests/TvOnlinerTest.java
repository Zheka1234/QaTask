package home5.tests;

import home5.driver.Browser;
import home5.pages.TvPages;
import home5.utility.SaveScreenShots;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TvOnlinerTest {

    private static Logger log = Logger.getLogger(TvOnlinerTest.class);

    TvPages tvHomePages;

    @BeforeMethod
    public void openCatalogOnliner() {
        Browser.getDriver().get("https://www.onliner.by");
        tvHomePages = new TvPages();
    }

    @Test
    public void testLgLabelsOnThePage() throws InterruptedException, IOException {
        log.info("testLgLabelsOnThePage start");
        tvHomePages.openTvPage();
        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,700)");
        tvHomePages.openTvPageLg();
        synchronized (Browser.getDriver()) {
            Browser.getDriver().wait(4000);
        }
        List<WebElement> elements = tvHomePages.getLgModelLabelElements();
        SaveScreenShots.saveScreenShot();
        for (WebElement element : elements) {
            String text = element.getText();
            log.warn("The model does not match the filter Lg" + element);
            System.out.println(text);
            assertTrue(text.contains("LG"));
        }
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.close();
    }
}
