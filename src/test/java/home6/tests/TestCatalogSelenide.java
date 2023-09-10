package home6.tests;

import home6.pages.CatalogPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCatalogSelenide {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    private CatalogPage catalogPage = new CatalogPage();

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
