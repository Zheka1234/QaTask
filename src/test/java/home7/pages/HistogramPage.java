package home7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HistogramPage extends AuthorizationPage {


    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Histogram')]")
    private WebElement openHistogram;

    @FindBy(xpath = "//*[contains(@class,'bars')]//*[contains(@class,'bar_container')]")
    private List<WebElement> bars;

    @FindBy(xpath = "//*[@class='tooltip']")
    private WebElement tool;


}
