package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {


    private SelenideElement catalogNavigation = $x("//ul[@class='catalog-navigation-classifier ']");

    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("li//span[contains(text(),'" + sectionName + "')]");
    }

    public void openCatalogPage() {
        open("https://catalog.onliner.by/");
    }


    public void checkSectionPresence(String sectionName) {

        section(sectionName).shouldBe(Condition.visible);

    }

}

