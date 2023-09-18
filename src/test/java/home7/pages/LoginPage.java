package home7.pages;

import home7.driver.BrowserDriver;
import home7.enums.MenuItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends AuthorizationPage {

    @FindBy(xpath = "//a[@href='/settings']")
    private WebElement settingButton;

    @FindBy(xpath = "//div[@class='app-title']")
    private WebElement checkMenu;

    @FindBy(xpath = "//div[@class='d-flex align-items-center benchmark-selection']")
    private WebElement benchmarkSelection;


    public boolean checkSetting() {
        log.info("checkSetting start");

        return settingButton.isDisplayed();
    }

    public boolean checkMenuElements() throws IOException {
        log.info("checkMenuElements start");
        menuElements.checkItem(MenuItem.SUMMARY);
        menuElements.checkItem(MenuItem.GRID_AND_CHAT);
        menuElements.checkItem(MenuItem.SCATTER_PLOT);
        menuElements.checkItem(MenuItem.REPORTS);
        menuElements.checkItem(MenuItem.HISTOGRAM);
        log.info("checkMenuElements good");
        return true;

    }

    public boolean checkBenchmarkSelection() {
        log.info("checkBenchmarkSelection start");
        return benchmarkSelection.isDisplayed();
    }

    public LoginPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
