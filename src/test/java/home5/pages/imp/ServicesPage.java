package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;
import home5.util.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage extends BasePage {


    @FindBy(xpath = "//div[@class='service-header service-header_primary service-header_condensed']")
    private WebElement serviceTitle;

    public ServicesPage(){
        PageFactory.initElements(Browser.getDriver(),this);
    }



    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.SERVICES);

    }

    public boolean isServicesItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.SERVICES);
    }

    public String getServiceTitle() {
        return serviceTitle.getText();
    }
}
