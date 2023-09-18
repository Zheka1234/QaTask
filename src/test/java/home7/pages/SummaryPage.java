package home7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Summary')]")
    private WebElement openSummaryPage;


    @FindBy(xpath = "//div[@class='app-title flex-1 widget__header'][contains(text(),'Algo Performance')]/../div[@title='Expand']")
    private WebElement clickFullAgroPerform;

}
