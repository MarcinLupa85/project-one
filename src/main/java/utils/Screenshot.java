package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private static final Logger LOGGER = LogManager.getLogger(Screenshot.class);

    public static void takeScreenshot(File destinationFile, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, destinationFile);
        } catch (IOException e) {
            LOGGER.error("Cannot take screenshot {}", e.getMessage());
        }
    }
}
