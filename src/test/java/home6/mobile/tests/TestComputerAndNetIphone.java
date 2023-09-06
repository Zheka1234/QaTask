package home6.mobile.tests;

import com.codeborne.selenide.Configuration;
import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.Test;

public class TestComputerAndNetIphone {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browserSize = "414x736";
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @Test
    public void testComputerAndNet()  {
        this.catalogPage.openCatalogPage();
        this.catalogPage.openComputerAndNet();
        this.catalogPage.openComputerAndNetCatalog();
    }
}
