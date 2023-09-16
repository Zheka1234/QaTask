package homeworkCucumber.elements;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.MenuItemCity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuCityElements {

    private static final String ITEM_PATTERN = "//span[contains(text(),'%s')]";


    private WebElement getMenuCity(MenuItemCity menuElements) {
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public boolean checkItemCity(MenuItemCity item) {
        getMenuCity(item).isDisplayed();
        return true;
    }
}
