package home6.mobile.tests;

import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCatalogSelenideIphone {

    static {

        System.setProperty("chromeoptions.mobileEmulation", "deviceName=iPhone 12 Pro");
    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    @DataProvider(name = "sectionNames")
    public Object[][] sectionNames() {
        return new Object[][]{
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
        catalogPage.openCatalogPage();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(catalogPage.checkSectionPresence(sectionName));

        soft.assertAll();

    }
}
