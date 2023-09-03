package home6.tests;

import home6.pages.BasicPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWindow;

public class BasicTest {

    BasicPage basicPage = new BasicPage();

    @BeforeClass
    public void openCatalog() {
        basicPage.openBasePage();
    }

    @AfterClass
    public void closeResource() {
        clearBrowserCookies();
        closeWindow();
    }
}
