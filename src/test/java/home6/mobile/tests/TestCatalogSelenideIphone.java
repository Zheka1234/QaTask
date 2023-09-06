package home6.mobile.tests;

import com.codeborne.selenide.Configuration;
import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.Test;

public class TestCatalogSelenideIphone {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browserSize = "414x736";
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @Test
    public void testCatalogSections() {
        this.catalogPage.openCatalogPage();
        this.catalogPage.checkSectionPresence("Электроника");
        this.catalogPage.checkSectionPresence("Компьютеры и");
        this.catalogPage.checkSectionPresence("Бытовая техника");
        this.catalogPage.checkSectionPresence("Стройка и");
        this.catalogPage.checkSectionPresence("Дом и");
        this.catalogPage.checkSectionPresence("Авто и");
        this.catalogPage.checkSectionPresence("Красота и");
        this.catalogPage.checkSectionPresence("Детям и");
        this.catalogPage.checkSectionPresence("Onlíner Prime");
        this.catalogPage.checkSectionPresence("На каждый день");
    }
}
