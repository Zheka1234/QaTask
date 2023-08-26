package home5.test;

import home5.pages.imp.AutoSalesPage;
import home5.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AutoSalesTest {

    AutoSalesPage autoSalesPage;


    @BeforeMethod
    public void setUp() {
        Browser.getDriver().get("https://www.onliner.by");
        autoSalesPage = new AutoSalesPage();
    }

    @Test
    public void testNewsItemPresent() {
        assertTrue(autoSalesPage.isAutoItemMenuPresent());
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }
}
