package home5.test;

import home5.pages.imp.ServicesPage;
import home5.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ServicesTest {


    ServicesPage service;


    @BeforeMethod
    public void setUp() {
        Browser.getDriver().get("https://www.onliner.by");
        service = new ServicesPage();
    }

    @Test
    public void testNewsItemPresent() {
        assertTrue(service.isServicesItemMenuPresent());
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }
}
