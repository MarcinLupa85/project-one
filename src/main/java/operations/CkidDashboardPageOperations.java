package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CkidDashboardPageObject;
import utils.WaitUtils;

public class CkidDashboardPageOperations {

    private CkidDashboardPageObject ckidDashboardPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public CkidDashboardPageOperations (WebDriver driver) {
        ckidDashboardPageObject = new CkidDashboardPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void deleteAccount() {
        driver.navigate().to("https://test-circlekid-core-stable.test.gneis.io/#/dashboard");
        waitUtils.bringElementToViewport(ckidDashboardPageObject.getEditAccountButton());
        ckidDashboardPageObject.getEditAccountButton().click();
        waitUtils.waitForElement(ckidDashboardPageObject.getDeleteAccountButton()).click();
        waitUtils.waitForElement(ckidDashboardPageObject.getValidationPhraseInput()).sendKeys("CLOSE MY ACCOUNT");
        waitUtils.waitForElement(ckidDashboardPageObject.getDeleteAccountConfirmationButton()).click();
    }

}
