package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {


    private SelenideElement catalogNavigation = $x("//ul[@class='catalog-navigation-classifier ']");

    private SelenideElement button = $x("//span[contains(text(), 'Компьютеры и')]");

    private void clickElementByText(String text) {
        SelenideElement element = $x("//div[@class='catalog-navigation-list__aside-title' and text()=' " + text + " ']");
        element.shouldBe(Condition.visible).click();
    }

    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("li//span[contains(text(),'" + sectionName + "')]");
    }

    public void openCatalogPage() {
        open("https://catalog.onliner.by/");
    }

    public void checkSectionPresence(String sectionName) {

        section(sectionName).shouldBe(Condition.visible);

    }

    public void openComputerAndNet() {

        button.shouldBe(Condition.visible).click();
    }

    public void openComputerAndNetCatalog() {

        List<String> elementTexts = Arrays.asList(
                "Комплектующие",
                "Хранение данных",
                "Ноутбуки, компьютеры, мониторы",
                "Сетевое оборудование",
                "Электропитание",
                "Мультимедиа периферия"
        );
        for (String text : elementTexts) {
            clickElementByText(text);
        }
    }

}
