package home6.mobile.tests;

import home6.mobile.pages.AccessoriesPageMobile;
import home6.mobile.pages.CatalogPageMobile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAccessoriesIphone {

    static {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=iPhone 12 Pro");

    }

    private CatalogPageMobile catalogPage = new CatalogPageMobile();

    private AccessoriesPageMobile accessoriesPageMobile = new AccessoriesPageMobile();

    @DataProvider(name = "sectionNames")
    public Object[][] sectionNames() {
        return new Object[][]{
                {"Видеокарты"},
                {"Процессоры"},
                {"Материнские платы"},
                {"Оперативная память"},
                {"Системы охлождения"},
                {"SSD"},
                {"Жесткие диски"},
                {"Корпуса"},
                {"Блоки питания"},
                {"Моддинг, аксессуары для системных блоков"},
                {"Звуковые карты"},
                {"Сетевые адаптеры"},
                {"Оптические приводы"},
                {"ТВ-тюнеры и карты видеозахвата "},
                {"Аксессуары для майнинга"},
        };
    }

    @Test(dataProvider = "sectionNames")
    public void testCatalogSections(String sectionName) {
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();
        accessoriesPageMobile.clickAccessories();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(accessoriesPageMobile.checkSectionPresenceThird(sectionName));

        soft.assertAll();

    }

    @DataProvider(name = "sectionNamesSecond")
    public Object[][] sectionNamesSecond() {
        return new Object[][]{
                {"Видеокарты"},
                {"Процессоры"},
                {"Материнские платы"},
                {"Оперативная память"},
                {"Системы охлождения"},
                {"SSD"},
                {"Жесткие диски"},
                {"Корпуса"},
                {"Блоки питания"},
                {"Моддинг, аксессуары для системных блоков"},
                {"Звуковые карты"},
                {"Сетевые адаптеры"},
                {"Оптические приводы"},
                {"ТВ-тюнеры и карты видеозахвата "},
                {"Аксессуары для майнинга"},
        };
    }

    @Test(dataProvider = "sectionNamesSecond")
    public void testCatalogPrice(String sectionName) {
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();
        accessoriesPageMobile.clickAccessories();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(accessoriesPageMobile.checkSectionPresenceFour(sectionName));
        System.out.println(sectionName);
        System.out.println();
        soft.assertAll();


    }
}


