package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageOperations {

    private HomePageObject homePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private CustomizationPageOperations customizationPageOperations;

    public HomePageOperations(WebDriver driver) {
        homePageObject = new HomePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        customizationPageOperations = new CustomizationPageOperations(driver);
    }

    public void openEaseePurchaseFlowNoExtra() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void openEaseePurchaseFlowWithExtra() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickExtraCheckbox();
    }

    public void openEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickInstallationCheckbox();
    }

    public void openMennekesPurchaseFlowNoExtra() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement mennekesLink = homePageObject.getPurchaseFlowMennekesLink();
        waitUtils.waitForVisiblityOf(mennekesLink);
        waitUtils.bringElementToViewport(mennekesLink);
        mennekesLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void openMennekesPurchaseFlowWithExtra() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement mennekesLink = homePageObject.getPurchaseFlowMennekesLink();
        waitUtils.waitForVisiblityOf(mennekesLink);
        waitUtils.bringElementToViewport(mennekesLink);
        mennekesLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickExtraCheckbox();
    }

    public void openMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement mennekesLink = homePageObject.getPurchaseFlowMennekesLink();
        waitUtils.waitForVisiblityOf(mennekesLink);
        waitUtils.bringElementToViewport(mennekesLink);
        mennekesLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickInstallationCheckbox();
    }

    public void openCablePurchaseFlow() {
        driver.navigate().to("https://emobility-test-unstable.test.gneis.io/hjemmelading-bestill/customize-order?id=2");
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void openEaseePurchaseFlow14DaysInstalation() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickInstallationCheckbox();
    }

    public void logOut() {
        WebElement username = homePageObject.getUsernameText();
        waitUtils.waitForVisiblityOf(username);
        username.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("a.logout-href"));
        waitUtils.waitForVisiblityOf(logoutButton);
        logoutButton.click();
        waitUtils.waitForUrlToContains("/home");
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = homePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/on-the-go",2);
        assertThat(driver.getCurrentUrl()).contains("/on-the-go");
    }
}
