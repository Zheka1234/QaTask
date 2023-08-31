package home5.tests;

import home5.driver.Browser;
import home5.pages.TvPages;
import home5.utility.SaveScreenShots;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TvOnlinerTest {

    TvPages tvHomePages;

    @BeforeMethod
    public void openCatalogOnliner() {
        Browser.getDriver().get("https://www.onliner.by");
        tvHomePages = new TvPages();
    }

    @Test
    public void testLgLabelsOnThePage() throws InterruptedException, IOException {
        tvHomePages.openTvPage();
        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,700)");
        tvHomePages.openTvPageLg();
        Thread.sleep(4000);
        List<WebElement> elements = tvHomePages.getLgModelLabelElements();
        SaveScreenShots.saveScreenShot();

        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
            assertTrue(text.contains("LG"));
        }
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.close();
    }
}
