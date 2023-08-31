package home5.pages;

import home5.driver.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TvPages {


    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/tv']")
    private WebElement tvLink;
    @FindBy(xpath = "//label[@class='schema-filter__checkbox-item']/span[@class='schema-filter__checkbox-text'][text()='LG']")
    private WebElement tvLg;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name']")
    private List<WebElement> modelLglabel;

    public TvPages() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void openTvPage() {
        tvLink.click();
    }

    public void openTvPageLg() {
        tvLg.click();
    }

    public List<WebElement> getLgModelLabelElements() {

        return modelLglabel;
    }


}
