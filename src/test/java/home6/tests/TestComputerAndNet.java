package home6.tests;

import home6.pages.CatalogPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestComputerAndNet {


    private CatalogPage catalogPage = new CatalogPage();

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
