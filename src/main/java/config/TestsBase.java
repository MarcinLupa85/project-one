package config;

import operations.CookiePanelOperations;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;


public abstract class TestsBase {

    public WebDriver driver;
    private WaitUtils waitUtils;
    private CookiePanelOperations cookiePanelOperations;


    @BeforeMethod(alwaysRun = true)
    public void prepareSuite() throws TimeoutException {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(10, BASE_URL);
        waitUtils.waitForPresentOf(By.cssSelector("ev-image.banner-image-desktop"));
        cookiePanelOperations = new CookiePanelOperations(driver);
        waitUtils.waitForPresentOf(By.id("CybotCookiebotDialogBodyUnderlay"));
        waitUtils.waitForPresentOf(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookiePanelOperations.clickCookieOkButton();
        waitUtils.waitForPresentOf(By.cssSelector("ev-image.banner-image-desktop"));
        waitUtils.waitForDocumentReadyState();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}