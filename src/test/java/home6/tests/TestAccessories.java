package home6.tests;

import com.codeborne.selenide.Configuration;
import home6.pages.AccessoriesPage;
import home6.pages.CatalogPage;
import org.testng.annotations.Test;

public class TestAccessories {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }
    private CatalogPage catalogPage = new CatalogPage();
    private AccessoriesPage accessoriesPage= new AccessoriesPage();

    @Test
    public void testAccessories(){
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();
        accessoriesPage.checkAccessoriesPartFirst();
        accessoriesPage.checkAccessoriesPartSecond();
        accessoriesPage.checkAccessoriesPartThird();
        accessoriesPage.checkAccessoriesPartFourth();
        accessoriesPage.checkAccessoriesPartFifth();


    }
}
