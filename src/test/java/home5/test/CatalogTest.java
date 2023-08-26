package home5.test;

import home5.pages.imp.CatalogPage;
import home5.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CatalogTest {

    CatalogPage catalogPage;


    @BeforeMethod
    public void setUp() {
        Browser.getDriver().get("https://www.onliner.by");
        catalogPage = new CatalogPage();
    }

    @Test
    public void testNewsItemPresent() {
        assertTrue(catalogPage.isCatalogItemMenuPresent());
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }
}


