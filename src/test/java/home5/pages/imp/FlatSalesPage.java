package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;

public class FlatSalesPage extends BasePage {
    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.FLATSALES);

    }
    public boolean isFlatItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.FLATSALES);
    }

}
