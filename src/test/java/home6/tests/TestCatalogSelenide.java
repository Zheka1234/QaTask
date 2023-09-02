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
        catalogPage.openCatalogPage();
        catalogPage.checkSectionPresence("Электроника");
        catalogPage.checkSectionPresence("Компьютеры и сети");
        catalogPage.checkSectionPresence("Бытовая техника");
        catalogPage.checkSectionPresence("Стройка и ремонт");
        catalogPage.checkSectionPresence("Дом и сад");
        catalogPage.checkSectionPresence("Авто и мото");
        catalogPage.checkSectionPresence("Красота и спорт");
        catalogPage.checkSectionPresence("Детям и мамам");
        catalogPage.checkSectionPresence("Работа и офис");
        catalogPage.checkSectionPresence("Еда");
    }
}

