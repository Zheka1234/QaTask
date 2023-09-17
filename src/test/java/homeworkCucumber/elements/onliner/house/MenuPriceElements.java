package homeworkCucumber.elements.onliner.house;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.house.MenuItemPrice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class MenuPriceElements {
    private static final String ITEM_PATTERN = "//span[contains(text(),'%s')]";


    private WebElement getMenuPrice(MenuItemPrice menuElements) throws IOException {
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public boolean checkItemsPrice(MenuItemPrice... items)throws IOException{
        for (MenuItemPrice item : items) {
            if (!getMenuPrice(item).isDisplayed()) {
                return true;
            }
        }
        return true;
    }
}