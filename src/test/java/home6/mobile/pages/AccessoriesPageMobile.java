package home6.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class AccessoriesPageMobile extends BasePageMobile {

    private String AMOUNT_AND_PRICE = "[\\d]{0,}[\\,]?[\\d]+[\\s][товар[а]?[ов]?\nот\\s[\\d]+[\\,]?[\\d]{0,}[\\s]р\\.]";


    public void clickAccessories() {
        log.info("clickAccessories start");
        SelenideElement element =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Комплектующие ']");
        element.shouldBe(Condition.visible).click();
    }

    private SelenideElement sectionThird(String sectionNameThird) {
        SelenideElement element = $x("//div[.=' Комплектующие ']//..//a//span[@class='catalog-navigation-list__dropdown-title']" +
                "[contains(text()," +
                "'" + sectionNameThird + "')]");

        return element;
    }

    public SelenideElement sectionFour() {
        log.info("sectionFour start");
        SelenideElement element = $x("//div[.=' Комплектующие ']//..//a//span[@class='catalog-navigation-list__dropdown-description']")
                .shouldBe(Condition.matchText(AMOUNT_AND_PRICE));
        return element;
    }

    public boolean checkSectionPresenceFour(String sectionNameThird) {
        log.info("checkSectionPresenceFour start");

        sectionFour().shouldBe(Condition.visible);

        return true;
    }

    public boolean checkSectionPresenceThird(String sectionNameThird) {
        log.info("checkSectionPresenceThird start");

        sectionThird(sectionNameThird).shouldBe(Condition.visible);

        return true;
    }
}