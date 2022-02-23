package config;

import operations.CkidPageOperations;
import operations.CookiePanelOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;


public abstract class TestsBase {

    public WebDriver driver;
    private WaitUtils waitUtils;
    private CookiePanelOperations cookiePanelOperations;
    private CkidPageOperations ckidPageOperations;


    @BeforeMethod(alwaysRun = true)
    public void prepareSuite() throws TimeoutException {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(10, BASE_URL);
        cookiePanelOperations = new CookiePanelOperations(driver);
        waitUtils.waitForPresenceOf(By.id("cookie-bot"));
        waitUtils.waitForPresenceOf(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        waitUtils.waitForDocumentReadyState();
        cookiePanelOperations.clickCookieOkButton();
        waitUtils.waitForPresenceOf(By.id("header-main"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    private void cleanUp() throws TimeoutException {
        driver = new DriverFactory().startBrowser();
        ckidPageOperations = new CkidPageOperations(driver);
        ckidPageOperations.deleteAccounts();
        tearDown();
    }
}
