package homeworkCucumber.test;

import homeworkCucumber.driver.BrowserDriver;
import homeworkCucumber.steps.MyStepAuto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAuto {

    MyStepAuto myStepAuto;

    @Before
    public void setUp() {
        BrowserDriver.getDriver().get("https://www.onliner.by");
        myStepAuto = new MyStepAuto();
    }

    @After
    public void cleanUp() {

        BrowserDriver.close();
    }

    @Test
    public void testAuto() {
        assertTrue(myStepAuto.hoverTheCursorOver());
        assertTrue(myStepAuto.browseFields());
    }
}
