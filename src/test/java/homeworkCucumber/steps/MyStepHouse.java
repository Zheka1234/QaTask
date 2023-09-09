package homeworkCucumber.steps;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.MenuItemCity;
import homeworkCucumber.enums.onliner.house.MenuItemFlats;
import homeworkCucumber.enums.onliner.house.MenuItemPrice;
import homeworkCucumber.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStepHouse extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Дома и квартиры')]")
    private WebElement homePageHouse;

    public MyStepHouse() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }




    @Given("openPageStart")
    public void openPageStart() {
        BrowserDriver.getDriver().get("https://www.onliner.by");
    }

    @When("On the open page, the user will move the mouse pointer over the house and apartment menu")
    public boolean onTheOpenPageTheUserWillMoveTheMousePointerOverTheHouseAndApartmentMenu() {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(homePageHouse).perform();
        return homePageHouse.isDisplayed();
    }

    @Then("The user saw prices, cities")
    public boolean theUserSawPricesCities() {
        menuAutoElementsHouse.checkItemHouse(MenuItemFlats.ONE_ROOM);
        menuAutoElementsHouse.checkItemHouse(MenuItemFlats.TWO_ROOMS);
        menuAutoElementsHouse.checkItemHouse(MenuItemFlats.THREE_ROOMS);
        menuAutoElementsHouse.checkItemHouse(MenuItemFlats.FOUR_PLUS_MINUS);

        menuAutoElementsPrice.checkItemPrice(MenuItemPrice.BEFORE);
        menuAutoElementsPrice.checkItemPrice(MenuItemPrice.TO);
        menuAutoElementsPrice.checkItemPrice(MenuItemPrice.PRICE);

        menuAutoElementsCity.checkItemCity(MenuItemCity.MINSK);
        menuAutoElementsCity.checkItemCity(MenuItemCity.GOMEL);
        menuAutoElementsCity.checkItemCity(MenuItemCity.GRODNO);
        menuAutoElementsCity.checkItemCity(MenuItemCity.MOGILEV);
        menuAutoElementsCity.checkItemCity(MenuItemCity.VITEBSK);
        menuAutoElementsCity.checkItemCity(MenuItemCity.BREST);

        return true;
    }
}
