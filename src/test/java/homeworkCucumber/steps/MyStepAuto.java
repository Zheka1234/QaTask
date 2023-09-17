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

import java.io.IOException;

import static homeworkCucumber.driver.BrowserDriver.getPropertiess;
import static org.testng.Assert.assertTrue;

public class MyStepAuto extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Автобарахолка')]")
    private WebElement homePageAuto;

    public MyStepAuto()throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

    @Given("openPage onliner")
    public void openPage()throws IOException {
        BrowserDriver.getDriver().get(getPropertiess().getProperty("siteUrl"));
    }


    @When("On the open page, the user will move the mouse to the AutoFlea Market menu")
    public void hoverTheCursorOver() throws IOException{
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(homePageAuto).perform();
        assertTrue(homePageAuto.isDisplayed(), "Home page auto element is not displayed");
    }

    @Then("The user saw prices, cities, brands")
    public void browseFields()throws IOException {
        assertTrue(menuAutoElements.checkItemsAuto(
                MenuItemAuto.CAR_REVIEWS,
                MenuItemAuto.NEW_CAR,
                MenuItemAuto.PRICE_WITH_VAT,
                MenuItemAuto.WITH_MILEAGE,
                MenuItemAuto.AUTO_TO,
                MenuItemAuto.AUTO_MORE
        ));

        assertTrue(menuAutoElementsCity.checkItemsCity(
                MenuItemCity.MINSK,
                MenuItemCity.GOMEL,
                MenuItemCity.GRODNO,
                MenuItemCity.MOGILEV,
                MenuItemCity.VITEBSK,
                MenuItemCity.BREST
        ));

        assertTrue(menuAutoElementsBrand.checkItemsBrand(
                MenuItemAutoBrand.AUDI,
                MenuItemAutoBrand.BMW,
                MenuItemAutoBrand.CITROEN,
                MenuItemAutoBrand.FORD,
                MenuItemAutoBrand.MAZDA,
                MenuItemAutoBrand.MERCEDES_BENZ,
                MenuItemAutoBrand.NISSAN,
                MenuItemAutoBrand.OPEL,
                MenuItemAutoBrand.PEUGEOT,
                MenuItemAutoBrand.RENAULT,
                MenuItemAutoBrand.TOYOTA,
                MenuItemAutoBrand.VOLKSWAGEN
        ));
    }

}
