package home6.tests;

import home6.pages.AccessoriesPage;
import home6.pages.CatalogPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAccessories {

    private CatalogPage catalogPage = new CatalogPage();
    private AccessoriesPage accessoriesPage = new AccessoriesPage();


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
        accessoriesPage.clickAccessories();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(accessoriesPage.checkSectionPresenceThird(sectionName));

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
        accessoriesPage.clickAccessories();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(accessoriesPage.checkSectionPresenceFour(sectionName));

        soft.assertAll();

    }
}
