package home7.tests;

import home7.driver.BrowserDriver;
import home7.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static home7.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertTrue;

public class CaseLoginTest {

    LoginPage loginPage;

    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }
    @Test
    public void loginTest() throws IOException {
        assertTrue(loginPage.clickUser());
        assertTrue(loginPage.checkSetting());
        assertTrue(loginPage.checkBenchmarkSelection());
        assertTrue(loginPage.checkMenuElements());
    }

}
