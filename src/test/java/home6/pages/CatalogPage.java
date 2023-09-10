package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {

    Logger log = Logger.getLogger(CatalogPage.class);


    private SelenideElement catalogNavigation = $x("//ul[@class='catalog-navigation-classifier ']");

    private SelenideElement button = $x("//span[contains(text(), 'Компьютеры и')]");


    private void clickElementByText(String text) {
        SelenideElement element =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' " + text + " ']");
        element.shouldBe(Condition.visible).click();
    }

    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("li//span[contains(text(),'" + sectionName + "')]");
    }

    public void openCatalogPage() {
        log.info("openCatalogPage start");
        open("https://catalog.onliner.by/");

        log.debug("openCatalogPage good");
    }

    public void checkSectionPresence(String sectionName) {
        log.info("checkSectionPresence start");

        section(sectionName).shouldBe(Condition.visible);

        log.debug("checkSectionPresence good");

    }

    public void openComputerAndNet() {
        log.info("openComputerAndNet start");

        button.shouldBe(Condition.visible).click();

        log.debug("openComputerAndNet good");
    }

    public void openComputerAndNetCatalog() {
        log.info("openComputerAndNetCatalog start");


        List<String> elementTexts = Arrays.asList(
                "Комплектующие",
                "Хранение данных",
                "Ноутбуки, компьютеры, мониторы",
                "Сетевое оборудование",
                "Электропитание",
                "Мультимедиа периферия"
        );
        for (String text : elementTexts) {
            try {
                clickElementByText(text);
            } catch (ElementNotFound e) {
                log.warn("Element not found: " + e.getMessage());
            }
        }
        log.debug("openComputerAndNetCatalog good");
    }

}
