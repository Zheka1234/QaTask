package home6.tests;

import com.codeborne.selenide.ElementsCollection;
import home6.pages.CatalogPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static home6.consts.CatalogConst.ACCESSORIES;
import static home6.consts.CatalogConst.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS;
import static home6.consts.CatalogConst.CASH_REGISTERS_AND_COMMERCIAL_EQUIPMENT;
import static home6.consts.CatalogConst.DATA_STORAGE;
import static home6.consts.CatalogConst.GAMES_AND_SOFTWARE;
import static home6.consts.CatalogConst.LAPTOPS_COMPUTERS_MONITORS;
import static home6.consts.CatalogConst.MANIPULATORS_AND_INPUT_DEVICES;
import static home6.consts.CatalogConst.MULTIMEDIA_PERIPHERALS;
import static home6.consts.CatalogConst.NETWORK_EQUIPMENT;
import static home6.consts.CatalogConst.POWER_SUPPLY;
import static home6.consts.CatalogConst.PRINTING_AND_DESIGN_EQUIPMENT;
import static home6.utillity.SelenideScroll.scrollDown;

public class CatalogCompTest extends BasicTest {

    CatalogPage catalogPage = new CatalogPage();

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    @BeforeClass
    public void clickToCompCategory() {
        basicPage.clickToCatalogLink();
        catalogPage.clickComputersAndNetsCategory();
        scrollDown();
    }

    @Test
    public void testListOfCompColumn() {
        ElementsCollection listOfComputersAndNetsColumn = catalogPage.getListOfComputersAndNetsColumn();
        listOfComputersAndNetsColumn.shouldHave(size(11));
        catalogPage.getListOfComputersAndNetsColumn().shouldHave(textsInAnyOrder(GAMES_AND_SOFTWARE, LAPTOPS_COMPUTERS_MONITORS,
                ACCESSORIES, CASH_REGISTERS_AND_COMMERCIAL_EQUIPMENT, MANIPULATORS_AND_INPUT_DEVICES, DATA_STORAGE,
                MULTIMEDIA_PERIPHERALS, NETWORK_EQUIPMENT, PRINTING_AND_DESIGN_EQUIPMENT, ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS,
                POWER_SUPPLY));


    }
}
