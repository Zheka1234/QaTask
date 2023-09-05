package home6.tests;

import home6.pages.CatalogPage;
import org.testng.annotations.Test;

public class TestCatalogSelenide {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    private CatalogPage catalogPage = new CatalogPage();

    @Test
    public void testCatalogSections() throws InterruptedException {
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