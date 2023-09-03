package home6.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BasicPage {

    private static final String URL = "https://www.onliner.by/";
    private static final String CATALOG_LINK = "//a[@href='https://catalog.onliner.by'][@class='b-main-navigation__link']";

    public BasicPage openBasePage(){
        open(URL);
        return this;
    }

    public BasicPage clickToCatalogLink(){
        $x(CATALOG_LINK).click();
        return this;
    }
}
