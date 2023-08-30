package home5.pages;

import home5.utility.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TvPages {


    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/tv']")
    private WebElement tvLink;
    @FindBy(xpath = "//label[@class='schema-filter__checkbox-item']/span[@class='schema-filter__checkbox-text'][text()='LG']")
    private WebElement tvLg;

    @FindBy(xpath = "//label[@class='schema-filter__checkbox-item']/span[@class='schema-filter__checkbox-text'][text()='Samsung']")
    private WebElement tvSamsung;

    @FindBy(xpath = "//div[@class='schema-product__title']")
    private WebElement exampleSamsung;

    public TvPages() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void openTvPage(){
        tvLink.click();
    }

    public void openTvPageLg(){
        tvLg.click();
    }

    public boolean isOnlyLgDisplayed() {
        return !tvSamsung.isDisplayed();
    }

    public boolean isSamsungDisplayed() {
        return tvSamsung.isDisplayed();
    }

    public boolean isLgTvPageDisplayed() {
        return true;
    }



}
