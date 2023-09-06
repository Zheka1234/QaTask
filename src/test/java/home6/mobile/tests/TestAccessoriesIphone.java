package home6.mobile.tests;

import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.Test;

public class TestAccessoriesIphone {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @Test
    public void testAccessories() {
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();

    }
}
