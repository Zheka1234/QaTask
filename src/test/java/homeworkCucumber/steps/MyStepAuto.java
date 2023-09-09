package homeworkCucumber.steps;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.enums.onliner.auto.MenuItemAuto;
import homeworkCucumber.enums.onliner.auto.MenuItemAutoBrand;
import homeworkCucumber.enums.onliner.MenuItemCity;
import homeworkCucumber.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStepAuto extends BasePage {


    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Автобарахолка')]")
    private WebElement homePageAuto;

    public MyStepAuto() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

    @Given("openPage")
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
    public boolean browseFields() {
        menuAutoElements.checkItemAuto(MenuItemAuto.CAR_REVIEWS);
        menuAutoElements.checkItemAuto(MenuItemAuto.NEW_CAR);
        menuAutoElements.checkItemAuto(MenuItemAuto.PRICE_WITH_VAT);
        menuAutoElements.checkItemAuto(MenuItemAuto.WITH_MILEAGE);
        menuAutoElements.checkItemAuto(MenuItemAuto.AUTO_TO);
        menuAutoElements.checkItemAuto(MenuItemAuto.AUTO_MORE);

        menuAutoElementsCity.checkItemCity(MenuItemCity.MINSK);
        menuAutoElementsCity.checkItemCity(MenuItemCity.GOMEL);
        menuAutoElementsCity.checkItemCity(MenuItemCity.GRODNO);
        menuAutoElementsCity.checkItemCity(MenuItemCity.MOGILEV);
        menuAutoElementsCity.checkItemCity(MenuItemCity.VITEBSK);
        menuAutoElementsCity.checkItemCity(MenuItemCity.BREST);

        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.AUDI);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.BMW);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.CITROEN);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.FORD);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.MAZDA);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.MERCEDES_BENZ);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.NISSAN);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.OPEL);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.PEUGEOT);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.RENAULT);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.TOYOTA);
        menuAutoElementsBrand.checkItemBrand(MenuItemAutoBrand.VOLKSWAGEN);
        return true;
    }

}
