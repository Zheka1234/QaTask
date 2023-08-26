package home5.elements;

import home5.enums.TopMenuItem;
import home5.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenu {



    private static final String ITEM_PATTERN = "//nav//*[contains(text(),'%s')]";

    private static final Integer WAIT_TIMEOUT = 1;

    public void clickOnItem(TopMenuItem item) {

        getMenuElement(item).click();

    }

    public boolean isItemExist(TopMenuItem itemMenu) {

        return getMenuElement(itemMenu).isDisplayed();

    }

    private WebElement getMenuElement(TopMenuItem item) {
        String xpath = String.format(ITEM_PATTERN, item.getValue());

        WebElement menuItem = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }
}
