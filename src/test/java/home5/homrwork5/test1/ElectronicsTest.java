package home5.homrwork5.test1;

import home5.homrwork5.DriverConnector;
import home5.homrwork5.page.ElectronicsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ElectronicsTest {


    ElectronicsPage electronicsPage;


    @BeforeMethod
    public void setUp(){
        DriverConnector.getDriver().get("https://catalog.onliner.by");
        electronicsPage = new ElectronicsPage();
    }

    @AfterMethod
    public void close(){
        DriverConnector.close();
    }

    @Test
    public void testElectronicsItemPresent() {
       assertTrue(electronicsPage.isElectronicsItemMenuPresent());
    }

    @Test
    public void openElectronicsPageTest(){
        electronicsPage.openPage();
        assertFalse(electronicsPage.getTitle().isEmpty());
    }


}
