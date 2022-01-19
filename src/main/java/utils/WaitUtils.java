package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {

    private WebDriver driver;
    private final int defaultMaxTimeoutForAllWaits = 30;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForUrlToContain(String url) {
        waitForUrlToContain(url, defaultMaxTimeoutForAllWaits);
    }

    public void waitForUrlToContain(String url, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, defaultMaxTimeoutForAllWaits)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void waitForElementToBeClickable(By by) {
        new WebDriverWait(driver, defaultMaxTimeoutForAllWaits)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForDocumentReadyState() throws java.util.concurrent.TimeoutException {
        ExpectedCondition<Boolean> pageLoaderCondition =
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, defaultMaxTimeoutForAllWaits);
        wait.until(pageLoaderCondition);
    }

    public void waitUntilOnUrl(int timeoutInSeconds, String url) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public void waitForPresenceOf(By locator, int maxTimeInSeconds) {
        new WebDriverWait(driver, maxTimeInSeconds)
                .until(presenceOfElementLocated(locator));
    }

    public void waitForPresenceOf(By locator) {
        this.waitForPresenceOf(locator, defaultMaxTimeoutForAllWaits);
    }


    public void waitForVisibilityOf(WebElement element) {
        this.waitForVisibilityOf(element, defaultMaxTimeoutForAllWaits);
    }

    public void waitForVisibilityOf(WebElement element, int maxTimeInSeconds) {
        new WebDriverWait(driver, maxTimeInSeconds)
                .until(visibilityOf(element));
    }

    public WebElement waitForElement(WebElement element) {
        long startTime = System.currentTimeMillis();
        long timeOutInSeconds = defaultMaxTimeoutForAllWaits;
        while (true) {
            try {
                if (element.isDisplayed()) {
                    return element;
                } else if (isTimeout(startTime, timeOutInSeconds)) {
                    throw new TimeoutException(
                            "Cannot locate element by this strategy: " + element + " waited for "
                                    + timeOutInSeconds + " seconds with 500ms interval");
                }
            } catch (Exception e) {
                if (isTimeout(startTime, timeOutInSeconds)) {
                    throw new TimeoutException(
                            "Cannot locate element by this strategy: " + element + " waited for "
                                    + timeOutInSeconds + " seconds with 500ms interval");
                }
            }
        }
    }

    private boolean isTimeout(long startTime, long timeOutInSeconds) {
        return (System.currentTimeMillis() / 1000 - (startTime / 1000)) >= timeOutInSeconds;
    }

    public void bringElementToViewport(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView()", element);
        jsExecutor.executeScript("window.scrollBy(0, -123);");
    }

    // currently, unused but highly likely it will be useful in the future
    public void waitForInvisibility(WebElement element) {
        new WebDriverWait(driver, defaultMaxTimeoutForAllWaits)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(NoSuchElementException.class)
                .until(invisibilityOf(element));
    }
}
