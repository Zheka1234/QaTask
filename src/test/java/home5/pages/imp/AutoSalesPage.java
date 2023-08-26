package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;

public class AutoSalesPage extends BasePage {
    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.AUTOSALES);

    }

    public boolean isAutoItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.AUTOSALES);
    }
}
