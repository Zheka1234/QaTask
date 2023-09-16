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

import static org.testng.Assert.assertTrue;

public class MyStepHouse extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Дома и квартиры')]")
    private WebElement homePageHouse;

    public MyStepHouse() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }


    @Given("openPage onliner Start")
    public void openPageStart() {
        BrowserDriver.getDriver().get("https://www.onliner.by");
    }

    @When("On the open page, the user will move the mouse pointer over the house and apartment menu")
    public void onTheOpenPageTheUserWillMoveTheMousePointerOverTheHouseAndApartmentMenu() {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(homePageHouse).perform();


    }

    @Then("The user saw prices, cities")
    public void theUserSawPricesCities() {
        assertTrue(menuAutoElementsHouse.checkItemHouse(MenuItemFlats.ONE_ROOM));
        assertTrue((menuAutoElementsHouse.checkItemHouse(MenuItemFlats.TWO_ROOMS)));
        assertTrue((menuAutoElementsHouse.checkItemHouse(MenuItemFlats.THREE_ROOMS)));
        assertTrue((menuAutoElementsHouse.checkItemHouse(MenuItemFlats.FOUR_PLUS_MINUS)));

        assertTrue((menuAutoElementsPrice.checkItemPrice(MenuItemPrice.BEFORE)));
        assertTrue((menuAutoElementsPrice.checkItemPrice(MenuItemPrice.TO)));
        assertTrue((menuAutoElementsPrice.checkItemPrice(MenuItemPrice.PRICE)));

        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.MINSK)));
        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.GOMEL)));
        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.GRODNO)));
        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.MOGILEV)));
        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.VITEBSK)));
        assertTrue((menuAutoElementsCity.checkItemCity(MenuItemCity.BREST)));


    }
}
