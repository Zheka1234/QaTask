package homeworkCucumber.elements.onliner.auto;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.auto.MenuItemAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class MenuAutoElements {

    private static final String ITEM_PATTERN = "//span[contains(text(),'%s')]";


    private WebElement getMenuAuto(MenuItemAuto menuElements) throws IOException{
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public boolean checkItemsAuto(MenuItemAuto... items)throws IOException {
        for (MenuItemAuto item : items) {
            if (!getMenuAuto(item).isDisplayed()) {
                return true;
            }
        }
        return true;
    }
}
