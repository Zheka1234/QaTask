package homeworkCucumber.elements.onliner.house;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.house.MenuItemFlats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuHouseElements {
    private static final String ITEM_PATTERN = "//span[contains(text(),'%s')]";


    private WebElement getMenuFlats(MenuItemFlats menuElements) {
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public boolean checkItemsHouse(MenuItemFlats... items) {
        for (MenuItemFlats item : items) {
            if (!getMenuFlats(item).isDisplayed()) {
                return true;
            }
        }
        return true;
    }
}
