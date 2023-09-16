package home6.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPageMobile extends BasePageMobile{

    private SelenideElement catalogNavigation = $x("//ul[@class='catalog-navigation-classifier ']");

    private SelenideElement button = $x("//span[contains(text(), 'Компьютеры и')]");

    private SelenideElement sectionTwo(String sectionNameTwo) {
        SelenideElement element = $x("//div[@class='catalog-navigation-list__aside-title'][contains(text()," +
                "'" + sectionNameTwo + "')]");
        return element;
    }


    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("li//span[contains(text(),'" + sectionName + "')]");
    }

    public void openCatalogPage() {
        log.info("openCatalogPage start");
        open("https://catalog.onliner.by/");

    }

    public boolean checkSectionPresence(String sectionName) {
        log.info("checkSectionPresence start");

        section(sectionName).shouldBe(Condition.visible);


        return true;
    }

    public void openComputerAndNet() {
        log.info("openComputerAndNet start");

        button.shouldBe(Condition.visible).click();


    }


    public boolean checkSectionPresenceTwo(String sectionNameTwo) {
        log.info("checkSectionPresence start");

        sectionTwo(sectionNameTwo).shouldBe(Condition.visible);


        return true;
    }
}
