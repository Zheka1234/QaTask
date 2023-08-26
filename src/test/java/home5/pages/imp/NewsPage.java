package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;
import home5.util.Browser;
import org.openqa.selenium.By;

public class NewsPage extends BasePage {

    private By newsTitleLocator = By.xpath("//a[@class='b-tile-main'][1]");


    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.NEWS);

    }

    public boolean isNewsItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.NEWS);
    }

    public String getNewsTitle() {

       return Browser.getDriver().findElement(newsTitleLocator).getText();

    }
}
