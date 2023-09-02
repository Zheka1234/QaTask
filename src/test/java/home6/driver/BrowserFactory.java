package home6.driver;

import home6.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    }

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                throw new IllegalStateException("Browser Not Supported: " + browserType);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}

