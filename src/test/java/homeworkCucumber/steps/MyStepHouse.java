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

import java.io.IOException;

import static homeworkCucumber.driver.BrowserDriver.getPropertiess;
import static org.testng.Assert.assertTrue;

public class MyStepHouse extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Дома и квартиры')]")
    private WebElement homePageHouse;

    public MyStepHouse() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }


    @Given("openPage onliner Start")
    public void openPageStart() throws IOException {
        BrowserDriver.getDriver().get(getPropertiess().getProperty("siteUrl"));
    }

    @When("On the open page, the user will move the mouse pointer over the house and apartment menu")
    public void onTheOpenPageTheUserWillMoveTheMousePointerOverTheHouseAndApartmentMenu() throws IOException {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(homePageHouse).perform();
        assertTrue(homePageHouse.isDisplayed(), "Home page house element is not displayed");
    }

    @Then("The user saw prices, cities")
    public void theUserSawPricesCities() throws IOException {
        assertTrue(menuAutoElementsHouse.checkItemsHouse(
                MenuItemFlats.ONE_ROOM,
                MenuItemFlats.TWO_ROOMS,
                MenuItemFlats.THREE_ROOMS,
                MenuItemFlats.FOUR_PLUS_MINUS
        ));

        assertTrue(menuAutoElementsPrice.checkItemsPrice(
                MenuItemPrice.BEFORE,
                MenuItemPrice.TO,
                MenuItemPrice.PRICE
        ));

        assertTrue(menuAutoElementsCity.checkItemsCity(
                MenuItemCity.MINSK,
                MenuItemCity.GOMEL,
                MenuItemCity.GRODNO,
                MenuItemCity.MOGILEV,
                MenuItemCity.VITEBSK,
                MenuItemCity.BREST
        ));
    }
}
