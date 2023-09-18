package home6.mobile.tests;

import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestComputerAndNetIphone {

    static {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=iPhone 12 Pro");
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @DataProvider(name = "sectionNamesTwo")
    public Object[][] sectionNamesTwo() {
        return new Object[][]{
                {"Комплектующие"},
                {"Хранение данных"},
                {"Ноутбуки, компьютеры, мониторы"},
                {"Сетевое оборудование"}
        };
    }

    @Test(dataProvider = "sectionNamesTwo")
    public void testCatalogSections(String sectionNameTwo) {
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(catalogPage.checkSectionPresenceTwo(sectionNameTwo));

        soft.assertAll();

    }
}
