package home5.test;

import home5.pages.imp.NewsPage;
import home5.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NewsTest {

    NewsPage newsPage;


    @BeforeMethod
    public void setUp() {
        Browser.getDriver().get("https://www.onliner.by");
        newsPage = new NewsPage();
    }

    @Test
    public void testNewsItemPresent() {
        assertTrue(newsPage.isNewsItemMenuPresent());
    }

    @Test
    public void openNewsPageTest(){
        newsPage.openPage();
        assertFalse(newsPage.getNewsTitle().isEmpty());
    }

    @AfterMethod
    public void cleanup() {
        Browser.close();
    }
}
