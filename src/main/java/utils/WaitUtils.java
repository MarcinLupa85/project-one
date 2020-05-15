package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.sql.Timestamp;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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

    public void waitForDocumentReadyState() throws java.util.concurrent.TimeoutException {
        Timestamp timestampWithTimeoutAdded = new Timestamp(System.currentTimeMillis() + 30000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        while (new Timestamp(System.currentTimeMillis()).before(timestampWithTimeoutAdded)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            String documentState = (String) jse.executeScript("return document.readyState");
            if (documentState.equals("complete")) {
                return;
            }
        }
        throw new java.util.concurrent.TimeoutException();
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


    public void waitForVisiblityOf(WebElement element) {
        this.waitForVisiblityOf(element, defaultMaxTimeoutForAllWaits);
    }

    public void waitForVisiblityOf(WebElement element, int maxTimeInSeconds) {
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

}
