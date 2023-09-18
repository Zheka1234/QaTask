package home7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScatterplotPage extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Scatter-plot)]")
    private WebElement openScatter;

    @FindBy(xpath = "//div[text()='X Attribute']/following-sibling::*")
    private WebElement xAttribute;

    @FindBy(xpath = "//div[text()='Y Attribute']/following-sibling::*")
    private WebElement yAttribute;

    @FindBy(xpath = "//*[@name='intervalCountAutocomplete']//input")
    private WebElement interval;

    @FindBy(xpath = "//*[@class='scatter-plot-x-label']")
    private WebElement xLabel;

    @FindBy(xpath = "//*[@class='scatter-plot-y-label']")
    private WebElement yLabel;

}
