package home7.pages;

import home7.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SummaryPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Summary')]")
    private WebElement openSummaryPage;


    @FindBy(xpath = "//div[@class='app-title flex-1 widget__header'][contains(text(),'Algo Performance')]/../div[@title='Expand']")
    private WebElement clickFullAgroPerform;


    public boolean SummaryClick() {
        log.info("SummaryClick start");
        openSummaryPage.click();
        log.info("SummaryClick good");
        return openSummaryPage.isDisplayed();
    }

    public void agroPerformClick() {
        log.info("agroPerformClick start");
        clickFullAgroPerform.click();
    }

    public SummaryPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

}
