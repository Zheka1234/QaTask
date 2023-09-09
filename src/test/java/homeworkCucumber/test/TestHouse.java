package homeworkCucumber.test;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.steps.MyStepAuto;
import homeworkCucumber.steps.MyStepHouse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestHouse {

    MyStepHouse myStepHouse;

    @Before
    public void setUp() {
        BrowserDriver.getDriver().get("https://www.onliner.by");
        myStepHouse = new MyStepHouse();
    }

    @After
    public void cleanUp() {

        BrowserDriver.close();
    }

    @Test
    public void testAuto() {
        assertTrue(myStepHouse.onTheOpenPageTheUserWillMoveTheMousePointerOverTheHouseAndApartmentMenu());
        assertTrue(myStepHouse.theUserSawPricesCities());
    }
}
