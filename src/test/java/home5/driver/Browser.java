package home5.driver;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser {
    protected static WebDriver driver;

    private static Logger log = Logger.getLogger(Browser.class);

    private static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        log.error("No load driver" + driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}



