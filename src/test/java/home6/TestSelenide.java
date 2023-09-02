package home6;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestSelenide {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }
    @Test
    public void selenideTest() throws InterruptedException {
        open("https://app.tca.deltixuat.com/");
        $x("//input[@formcontrolname='username']").setValue("selenium_chrome");
        $x("//input[@formcontrolname='password']").setValue("Axa@Demo");
        $x("//button").click();
        Thread.sleep(5000);
    }
}
