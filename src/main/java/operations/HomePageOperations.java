package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObject;
import utils.WaitUtils;
import static config.Constants.BASE_URL;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageOperations {

    private HomePageObject homePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private CustomizationPageOperations customizationPageOperations;
    private NavbarOperations navbarOperations;

    public HomePageOperations(WebDriver driver) {
        homePageObject = new HomePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        customizationPageOperations = new CustomizationPageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
    }

    public void openEaseePurchaseFlow() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void flowWithExtra() {
        customizationPageOperations.tickExtraCheckbox();
    }

    public void flowWithInstallationOnly() {
        customizationPageOperations.tickInstallationCheckbox();
    }

    public void flowWithEqualizer() {
        customizationPageOperations.addEqualizer();
    }

    public void openMennekesPurchaseFlowNoExtra() throws TimeoutException {
        driver.navigate().to(BASE_URL+"/hjemmelading-bestill/customize-order?id=0");
        waitUtils.waitForDocumentReadyState();
    }

    public void openMennekesPurchaseFlowWithExtra() throws TimeoutException {
        driver.navigate().to(BASE_URL+"/hjemmelading-bestill/customize-order?id=0");
        waitUtils.waitForDocumentReadyState();
        customizationPageOperations.tickExtraCheckbox();
    }

    public void openMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        driver.navigate().to(BASE_URL+"/hjemmelading-bestill/customize-order?id=0");
        waitUtils.waitForDocumentReadyState();
        customizationPageOperations.tickInstallationCheckbox();
    }

    public void openCablePurchaseFlow() {
        driver.navigate().to(BASE_URL + "/hjemmelading-bestill/customize-order?id=2");
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
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
