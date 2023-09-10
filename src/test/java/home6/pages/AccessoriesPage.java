package home6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;


public class AccessoriesPage {

    Logger log = Logger.getLogger(AccessoriesPage.class);

    private String AMOUNT_AND_PRICE = "[\\d]{0,}[\\,]?[\\d]+[\\s][товар[а]?[ов]?\nот\\s[\\d]+[\\,]?[\\d]{0,}[\\s]р\\.]";

    private void clickAccessories() {
        SelenideElement element =
                $x("//div[@class='catalog-navigation-list__aside-title' and text()=' Комплектующие ']");
        element.shouldBe(Condition.visible).click();
    }

    public void checkAccessoriesPartFirst() {
        log.info("checkAccessoriesPartFirst start");
        clickAccessories();
        try {
            SelenideElement videoCard = $x("//a[@href='https://catalog.onliner.by/videocard']/span/span[2]");
            SelenideElement videoCard1 = $x("//a[@href='https://catalog.onliner.by/videocard']/span/span[3]");
            videoCard.shouldBe(Condition.visible);
            videoCard1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement cpu = $x("//a[@href='https://catalog.onliner.by/cpu']/span/span[2]");
            SelenideElement cpu1 = $x("//a[@href='https://catalog.onliner.by/cpu']/span/span[3]");
            cpu.shouldBe(Condition.visible);
            cpu1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement motherBoard = $x("//a[@href='https://catalog.onliner.by/motherboard']/span/span[2]");
            SelenideElement motherBoard1 = $x("//a[@href='https://catalog.onliner.by/motherboard']/span/span[3]");
            motherBoard.shouldBe(Condition.visible);
            motherBoard1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        log.debug("checkAccessoriesPartFirst good");

    }

    public void checkAccessoriesPartSecond() {
        log.info("checkAccessoriesPartSecond start");
        try {
            SelenideElement ram = $x("//a[@href='https://catalog.onliner.by/dram']/span/span[2]");
            SelenideElement ram1 = $x("//a[@href='https://catalog.onliner.by/dram']/span/span[3]");
            ram.shouldBe(Condition.visible);
            ram1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement ssd = $x("//a[@href='https://catalog.onliner.by/ssd']/span/span[2]");
            SelenideElement ssd1 = $x("//a[@href='https://catalog.onliner.by/ssd']/span/span[3]");
            ssd.shouldBe(Condition.visible);
            ssd1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());
        }
        try {
            SelenideElement hdd = $x("//a[@href='https://catalog.onliner.by/hdd']/span/span[2]");
            SelenideElement hdd1 = $x("//a[@href='https://catalog.onliner.by/hdd']/span/span[3]");
            hdd.shouldBe(Condition.visible);
            hdd1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        log.debug("checkAccessoriesPartSecond good");

    }

    public void checkAccessoriesPartThird() {
        log.info("checkAccessoriesPartThird start");
        try {
            SelenideElement fan = $x("//a[@href='https://catalog.onliner.by/fan']/span/span[2]");
            SelenideElement fan1 = $x("//a[@href='https://catalog.onliner.by/fan']/span/span[3]");
            fan.shouldBe(Condition.visible);
            fan1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }

        try {
            SelenideElement powerSupply = $x("//a[@href='https://catalog.onliner.by/powersupply']/span/span[2]");
            SelenideElement powerSupply1 = $x("//a[@href='https://catalog.onliner.by/powersupply']/span/span[3]");
            powerSupply.shouldBe(Condition.visible);
            powerSupply1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement frame = $x("//a[@href='https://catalog.onliner.by/chassis']/span/span[2]");
            SelenideElement frame1 = $x("//a[@href='https://catalog.onliner.by/chassis']/span/span[3]");
            frame.shouldBe(Condition.visible);
            frame1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        log.debug("checkAccessoriesPartThird good");

    }

    public void checkAccessoriesPartFourth() {
        log.info("checkAccessoriesPartFourth start");
        try {
            SelenideElement accessory = $x("//a[@href='https://catalog.onliner.by/moddingpc']/span/span[2]");
            SelenideElement accessory1 = $x("//a[@href='https://catalog.onliner.by/moddingpc']/span/span[3]");
            accessory.shouldBe(Condition.visible);
            accessory1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());
        }
        try {
            SelenideElement soundCard =
                    $x("//a[@href='https://catalog.onliner.by/" +
                            "soundcard?type_soundcard%5B0%5D=internal&type_soundcard%5Boperation%5D=union']/span/span[2]");
            SelenideElement soundCard1 =
                    $x("//a[@href='https://catalog.onliner.by/" +
                            "soundcard?type_soundcard%5B0%5D=internal&type_soundcard%5Boperation%5D=union']/span/span[3]");
            soundCard.shouldBe(Condition.visible);
            soundCard1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement network = $x("//a[@href='https://catalog.onliner.by/networkadapter']/span/span[2]");
            SelenideElement network1 = $x("//a[@href='https://catalog.onliner.by/networkadapter']/span/span[3]");
            network.shouldBe(Condition.visible);
            network1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        log.debug("checkAccessoriesPartFourth good");

    }

    public void checkAccessoriesPartFifth() {
        log.info("checkAccessoriesPartFifth start");
        try {
            SelenideElement optical = $x("//a[@href='https://catalog.onliner.by/optical']/span/span[2]");
            SelenideElement optical1 = $x("//a[@href='https://catalog.onliner.by/optical']/span/span[3]");
            optical.shouldBe(Condition.visible);
            optical1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement tvTuner =
                    $x("//a[@href='https://catalog.onliner.by/" +
                            "tvtuner?execution_tvtune%5B0%5D=in&execution_tvtune%5Boperation%5D=union']/span/span[2]");
            SelenideElement tvTuner1 =
                    $x("//a[@href='https://catalog.onliner.by/" +
                            "tvtuner?execution_tvtune%5B0%5D=in&execution_tvtune%5Boperation%5D=union']/span/span[3]");
            tvTuner.shouldBe(Condition.visible);
            tvTuner1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        try {
            SelenideElement mining = $x("//a[@href='https://catalog.onliner.by/mining_acs']/span/span[2]");
            SelenideElement mining1 = $x("//a[@href='https://catalog.onliner.by/mining_acs']/span/span[3]");
            mining.shouldBe(Condition.visible);
            mining1.should(Condition.matchText(AMOUNT_AND_PRICE));
        } catch (ElementNotFound e) {
            log.warn("Element not found: " + e.getMessage());

        }
        log.debug("checkAccessoriesPartFifth good");
    }
}
