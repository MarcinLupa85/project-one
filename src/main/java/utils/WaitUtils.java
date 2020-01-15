package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class WaitUtils {

    private WebDriver driver;
    private final int defaultMaxTimeoutForAllWaits = 30;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForUrlToContains(String url) {
        waitForUrlToContains(url, defaultMaxTimeoutForAllWaits);
    }

    public void waitForUrlToContains(String url, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public void waitUntilOnUrl(int timeoutInSeconds, String url) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public void waitForPresentOf(By locator, int maxTimeInSeconds) {
        new WebDriverWait(driver, maxTimeInSeconds)
                .until(presenceOfElementLocated(locator));
    }

    public void waitForPresentOf(By locator) {
        this.waitForPresentOf(locator, defaultMaxTimeoutForAllWaits);
    }
}
