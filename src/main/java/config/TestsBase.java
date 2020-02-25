package config;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WaitUtils;

import static config.Constants.BASE_URL;

public abstract class TestsBase {

    public WebDriver driver;
    private WaitUtils waitUtils;


    @BeforeClass(alwaysRun = true)
    public void prepareSuite() {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(10, BASE_URL);
        waitUtils.waitForPresentOf(By.cssSelector("app-image.banner-image-desktop"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}