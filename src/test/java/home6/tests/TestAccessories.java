package home6.tests;

import home6.pages.AccessoriesPage;
import home6.pages.CatalogPage;
import org.testng.annotations.Test;

public class TestAccessories {

    private CatalogPage catalogPage = new CatalogPage();
    private AccessoriesPage accessoriesPage = new AccessoriesPage();

    @Test
    public void testAccessories() {
        catalogPage.openCatalogPage();
        catalogPage.openComputerAndNet();
        accessoriesPage.checkAccessoriesPartFirst();
        accessoriesPage.checkAccessoriesPartSecond();
        accessoriesPage.checkAccessoriesPartThird();
        accessoriesPage.checkAccessoriesPartFourth();
        accessoriesPage.checkAccessoriesPartFifth();


    }
}
