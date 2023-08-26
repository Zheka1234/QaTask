package home5.test;

import home5.pages.imp.FlatSalesPage;
import home5.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FlatTest {

    FlatSalesPage flatSales;


    @BeforeMethod
    public void setUp() {
        Browser.getDriver().get("https://www.onliner.by");
        flatSales = new FlatSalesPage();
    }

    @Test
    public void testNewsItemPresent() {
        assertTrue(flatSales.isFlatItemMenuPresent());
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }
}
