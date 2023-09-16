package home7.tests;

import home7.driver.BrowserDriver;
import home7.pages.DeltixuatPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class CaseLoginTest {

    DeltixuatPage deltixuatPage;


    @BeforeMethod
    public void openDeltixuat()  {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        deltixuatPage = new DeltixuatPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void loginTest() {
        assertTrue(deltixuatPage.clickUser());
        assertTrue(deltixuatPage.checkSetting());
        assertTrue(deltixuatPage.checkBenchmarkSelection());
        assertTrue(deltixuatPage.checkMenuElements());


    }

}
