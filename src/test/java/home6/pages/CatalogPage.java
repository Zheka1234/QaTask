package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CatalogPage {


    private static final String CATALOG_ITEM = "//li[@class='catalog-navigation-classifier__item ']";

    public ElementsCollection getCatalogItemList(){
        return $$x(CATALOG_ITEM);
    }


}

