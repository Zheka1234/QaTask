package home6.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class CatalogPage {


    private static final String CATALOG_ITEM = "//li[@class='catalog-navigation-classifier__item ']";

    public ElementsCollection getCatalogItemList() {
        return $$x(CATALOG_ITEM);
    }


}

