package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;

public class ServicesPage extends BasePage {


    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.SERVICES);

    }

    public boolean isServicesItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.SERVICES);
    }
}
