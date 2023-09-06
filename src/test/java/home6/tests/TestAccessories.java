package home6.tests;

import home6.pages.CatalogPage;
import org.testng.annotations.Test;

public class TestAccessories {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    private CatalogPage catalogPage = new CatalogPage();

    @Test
    public void testAccessories(){
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();

    }
}
