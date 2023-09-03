package home6.tests;

import home6.pages.CatalogPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static home6.consts.CatalogConst.APPLIANCES;
import static home6.consts.CatalogConst.BEAUTY_AND_SPORT;
import static home6.consts.CatalogConst.BUILDING_AND_RENOVATION;
import static home6.consts.CatalogConst.CARS_AND_MOTO;
import static home6.consts.CatalogConst.COMPUTERS_AND_NETS;
import static home6.consts.CatalogConst.DAY;
import static home6.consts.CatalogConst.ELECTRONICS;
import static home6.consts.CatalogConst.FOR_CHILDREN_AND_MOMS;
import static home6.consts.CatalogConst.HOUSE_AND_GARDEN;
import static home6.consts.CatalogConst.ONLINER_PRIME;

public class TestCatalogSelenide extends BasicTest {



    CatalogPage catalogPage = new CatalogPage();

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    @BeforeMethod
    public void clickToCatalog() {
        basicPage.clickToCatalogLink();
    }

    @Test
    public void testCatalogItems() {
        catalogPage.getCatalogItemList().shouldHave(size(10));

        catalogPage.getCatalogItemList().shouldHave(textsInAnyOrder(COMPUTERS_AND_NETS, APPLIANCES, DAY, BUILDING_AND_RENOVATION,ELECTRONICS,
                HOUSE_AND_GARDEN, CARS_AND_MOTO, BEAUTY_AND_SPORT, FOR_CHILDREN_AND_MOMS, ONLINER_PRIME));
    }}


