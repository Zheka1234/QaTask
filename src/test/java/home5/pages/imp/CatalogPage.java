package home5.pages.imp;

import home5.enums.TopMenuItem;
import home5.pages.BasePage;

public class CatalogPage extends BasePage {
    @Override
    public void openPage() {

        topMenu.clickOnItem(TopMenuItem.CATALOG);

    }

    public boolean isCatalogItemMenuPresent() {

        return topMenu.isItemExist(TopMenuItem.CATALOG);
    }
}
