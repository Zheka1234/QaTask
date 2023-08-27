package home5.homrwork5.page;


import home5.enums.TopMenuItem;
import home5.homrwork5.DriverConnector;
import home5.homrwork5.enums.TopMenuItem1;
import home5.util.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends BasePages {


    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper']")
    private WebElement electronicsTitle;


    public ElectronicsPage() {
        PageFactory.initElements(DriverConnector.getDriver(), this);
    }

    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem1.ELECTRONICS);

    }

    public boolean isElectronicsItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem1.ELECTRONICS);
    }

    @Override
    public String getTitle() {

        return electronicsTitle.getText();

    }
}
