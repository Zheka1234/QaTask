package homeworkCucumber.steps;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.MenuItemCity;
import homeworkCucumber.enums.onliner.auto.MenuItemAuto;
import homeworkCucumber.enums.onliner.auto.MenuItemAutoBrand;
import homeworkCucumber.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class MyStepAuto extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Автобарахолка')]")
    private WebElement homePageAuto;

    public MyStepAuto() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

    @Given("openPage onliner")
    public void openPage() {
        BrowserDriver.getDriver().get("https://www.onliner.by");
    }


    @When("On the open page, the user will move the mouse to the AutoFlea Market menu")
    public boolean hoverTheCursorOver() {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(homePageAuto).perform();
        return homePageAuto.isDisplayed();
    }

    @Then("The user saw prices, cities, brands")
    public void browseFields() {
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.CAR_REVIEWS));
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.NEW_CAR));
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.PRICE_WITH_VAT));
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.WITH_MILEAGE));
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.AUTO_TO));
        assertTrue(menuAutoElements.checkItemAuto(MenuItemAuto.AUTO_MORE));

        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.MINSK));
        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.GOMEL));
        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.GRODNO));
        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.MOGILEV));
        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.VITEBSK));
        assertTrue(menuAutoElementsCity.checkItemCity(MenuItemCity.BREST));

        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.AUDI));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.BMW));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.CITROEN));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.FORD));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.MAZDA));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.MERCEDES_BENZ));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.NISSAN));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.OPEL));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.PEUGEOT));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.RENAULT));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.TOYOTA));
        assertTrue(menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.VOLKSWAGEN));

    }

}
