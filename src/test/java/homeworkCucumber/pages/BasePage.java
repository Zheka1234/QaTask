package homeworkCucumber.pages;

import homeworkCucumber.elements.MenuCityElements;
import homeworkCucumber.elements.onliner.auto.MenuAutoElements;
import homeworkCucumber.elements.onliner.auto.MenuBrandElements;
import homeworkCucumber.elements.onliner.house.MenuHouseElements;
import homeworkCucumber.elements.onliner.house.MenuPriceElements;

public class BasePage {

    protected MenuAutoElements menuAutoElements = new MenuAutoElements();

    protected MenuCityElements menuAutoElementsCity = new MenuCityElements();

    protected MenuBrandElements menuAutoElementsBrand = new MenuBrandElements();


    protected MenuHouseElements menuAutoElementsHouse = new MenuHouseElements();


    protected MenuPriceElements menuAutoElementsPrice = new MenuPriceElements();

}
