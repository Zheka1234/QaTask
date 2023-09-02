package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CatalogPage {


    private SelenideElement catalogNavigation = $x("//span[@class='catalog-navigation-classifier__item-title-wrapper']");

    private SelenideElement section(String sectionName) {
        return catalogNavigation.$x("[contains(text(),'" + sectionName + ")]");
    }

    public void openCatalogPage() {
        open("https://catalog.onliner.by/");
    }


    public void checkSectionPresence(String sectionName) throws InterruptedException {

        Thread.sleep(5000);

        section(sectionName).shouldBe(Condition.visible);

    }


}

