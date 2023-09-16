package homeworkCucumber.elements.onliner.auto;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.auto.MenuItemAutoBrand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuBrandElements {

    private static final String ITEM_PATTERN = "//span[contains(text(),'%s')]";


    private WebElement getMenuBrand(MenuItemAutoBrand menuElements) {
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public boolean checkItemBrand(MenuItemAutoBrand item) {
        getMenuBrand(item).isDisplayed();
        return true;
    }
}
