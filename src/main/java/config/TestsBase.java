package config;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WaitUtils;

import static config.Constants.BASE_URL;


public abstract class TestsBase {

    public WebDriver driver;
    private WaitUtils waitUtils;


    @BeforeMethod(alwaysRun = true)
    public void prepareSuite() {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(10, BASE_URL);
        waitUtils.waitForPresentOf(By.cssSelector("ev-image.banner-image-desktop"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}