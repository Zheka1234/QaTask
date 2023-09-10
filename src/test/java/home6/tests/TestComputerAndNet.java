package home6.tests;

import home6.pages.CatalogPage;
import org.testng.annotations.Test;

public class TestComputerAndNet {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    private CatalogPage catalogPage = new CatalogPage();

    @Test
    public void testComputerAndNet(){
        this.catalogPage.openCatalogPage();
        this.catalogPage.openComputerAndNet();
        this.catalogPage.openComputerAndNetCatalog();
    }



}
