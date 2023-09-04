package home6.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {


    private static final String CATALOG_ITEM = "//li[@class='catalog-navigation-classifier__item ']";

    private static final String COMPUTERS_AND_NETS_CATEGORY = "//li[@data-id='2']";

    private static final String COMPUTERS_AND_NETS_ITEMS =
            "//div[@data-id='2']/div[1]/div/div";

    public ElementsCollection getCatalogItemList() {
        return $$x(CATALOG_ITEM);
    }

    public void clickComputersAndNetsCategory() {
        $x(COMPUTERS_AND_NETS_CATEGORY).click();
    }

    public ElementsCollection getListOfComputersAndNetsColumn() {
        return $$x(COMPUTERS_AND_NETS_ITEMS);
    }

}

