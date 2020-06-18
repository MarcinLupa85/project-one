package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.CkidDashboardPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;

public class CkidDashboardPageOperations {

    private CkidDashboardPageObject ckidDashboardPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public CkidDashboardPageOperations (WebDriver driver) {
        ckidDashboardPageObject = new CkidDashboardPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void deleteAccount() throws TimeoutException {
        driver.navigate().to("https://test-circlekid-core-stable.test.gneis.io/#/dashboard");
        waitUtils.waitForDocumentReadyState();
        waitUtils.waitForElement(ckidDashboardPageObject.getEditAccountButton());
        waitUtils.bringElementToViewport(ckidDashboardPageObject.getEditAccountButton());
        ckidDashboardPageObject.getEditAccountButton().click();
        waitUtils.waitForDocumentReadyState();
        waitUtils.waitForElement(ckidDashboardPageObject.getDeleteAccountButton()).click();
        waitUtils.waitForElement(ckidDashboardPageObject.getValidationPhraseInput()).sendKeys("CLOSE MY ACCOUNT");
        waitUtils.waitForElement(ckidDashboardPageObject.getDeleteAccountConfirmationButton()).click();
        waitUtils.waitForPresentOf(By.id("login-submit-button"));
        driver.navigate().to(BASE_URL);

    }

}
