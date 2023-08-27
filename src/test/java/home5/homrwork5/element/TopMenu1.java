package home5.homrwork5.element;



import home5.homrwork5.DriverConnector;
import home5.homrwork5.enums.TopMenuItem1;
import home5.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenu1 {

    private static final String ITEM_PATTERN = "//ul[@class='catalog-navigation-classifier']//li[@class='catalog-navigation-classifier__item'][@data-id='%s']";

    private static final Integer WAIT_TIMEOUT = 1;

    public void clickOnItem(TopMenuItem1 item) {

        getMenuElement(item).click();

    }


    public boolean isItemExist(TopMenuItem1 itemMenu) {

        return getMenuElement(itemMenu).isDisplayed();

    }

    private WebElement getMenuElement(TopMenuItem1 item) {
        String xpath = String.format(ITEM_PATTERN, item.getValue());

        WebElement menuItem = new WebDriverWait(DriverConnector.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }
}
