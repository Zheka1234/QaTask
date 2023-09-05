package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {


    private SelenideElement catalogNavigation = $x("//ul[@class='catalog-navigation-classifier ']");

    private SelenideElement button = $x("//span[contains(text(), 'Компьютеры и')]");

//    private SelenideElement elementComputer = $x("//div[@class='catalog-navigation-list__aside-list']");

    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("li//span[contains(text(),'" + sectionName + "')]");
    }

//    private SelenideElement sectionComputer(String sectionName) {
//        return elementComputer.$x("div[@class='catalog-navigation-list__aside-title' and text()='" + sectionName + "']");
//    }



    public void openCatalogPage() {
        open("https://catalog.onliner.by/");
    }


    public void checkSectionPresence(String sectionName) {

        section(sectionName).shouldBe(Condition.visible);

    }

//    public void checkSectionPresenceComputer(String sectionName) {
//
//        sectionComputer(sectionName).shouldBe(Condition.visible);
//
//    }

    public void openComputerAndNet(){

        button.shouldBe(Condition.visible).click();

        SelenideElement element =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Комплектующие ']");
        element.shouldBe(Condition.visible).click();

        SelenideElement element2 =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Хранение данных ']");
        element2.shouldBe(Condition.visible).click();

        SelenideElement element3 =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Ноутбуки, компьютеры, мониторы ']");
        element3.shouldBe(Condition.visible).click();
        SelenideElement element4 =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Сетевое оборудование ']");
        element4.shouldBe(Condition.visible).click();

    }



}

