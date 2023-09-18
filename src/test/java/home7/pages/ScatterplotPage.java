package home7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScatterplotPage extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Scatter-plot)]")
    private WebElement openScatter;

    @FindBy(xpath = "//div[@row-index='3']//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value']")
    private WebElement cellClick;

    @FindBy(xpath = "//div[@class='scatter-plot-container']")
    private WebElement scatterPlotContainer;

    @FindBy(xpath = "//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid']")
    private WebElement scatterPlotInputs;

}
