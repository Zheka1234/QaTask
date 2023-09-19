package home5.utility;

import home5.driver.Browser;
import home5.tests.TvOnlinerTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveScreenShots extends Browser {

    private static Logger log = Logger.getLogger(TvOnlinerTest.class);


    public static void saveScreenShot() throws IOException {

        File screenShots = new File("./test-output/screenshots");

        if (!screenShots.exists()) {
            screenShots.mkdirs();
        }
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
        String formattedDate = simpleDateFormat.format(date);
        String browserName = "Chrome";
        String fileName = browserName + "_" + formattedDate + "screenshot.png";

        byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(new File("./test-output/screenshots/" + fileName).toPath(), scrFile, StandardOpenOption.CREATE);
        log.error("No save screenshot" + scrFile + fileName);
    }
}

