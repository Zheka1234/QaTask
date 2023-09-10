package home6.mobile.tests;

import com.codeborne.selenide.Configuration;
import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCatalogSelenideIphone {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=iPhone 12 Pro");
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @DataProvider(name = "sectionNames")
    public Object[][] sectionNames() {
        return new Object[][] {
                {"Электроника"},
                {"Компьютеры и"},
                {"Бытовая техника"},
                {"Стройка и"},
                {"Дом и"},
                {"Авто и"},
                {"Красота и"},
                {"Детям и"},
                {"Onlíner Prime"},
                {"На каждый день"}
        };
    }

    @Test(dataProvider = "sectionNames")
    public void testCatalogSections(String sectionName) {
        this.catalogPage.openCatalogPage();
        this.catalogPage.checkSectionPresence(sectionName);
    }
}
