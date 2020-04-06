package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class DriverUtils {

    private WaitUtils waitUtils;
    private WebDriver driver;
    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public void clickNext(WebElement element, String redirectionUrl) {
        element.click();
        waitUtils.waitForUrlToContains(redirectionUrl);
    }

    public void clickBack(WebElement element, String redirectionUrl) {
        element.click();
        waitUtils.waitForUrlToContains(redirectionUrl);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
