package home7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridPage extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Grid & chart)]")
    private WebElement openGrid;

    @FindBy(xpath = "//div[@row-index='3']//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value']")
    private WebElement cellClick;

    @FindBy(xpath = "//div[@class='flex-1 post-trade__grid post-trade__grid_fullscreen']")
    private WebElement root;

    @FindBy(xpath = "//span[@class='chart-settings__title chart-mobile-title']")
    private WebElement linesClick;


}
