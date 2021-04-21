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
        waitUtils.waitForUrlToContains("/bestill/customize-order");
    }

    public void openEqualizerPurchaseFlow() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = homePageObject.getPurchaseFlowEqualizerLink();
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/bestill/customize-order");
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

    public void goToFaq() {
        WebElement readMoreFaqButton = homePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/elbillading/ladestasjoner/faq",2);
        assertThat(driver.getCurrentUrl()).contains("/ladestasjoner/faq");
    }

    public void goToContact() {
        waitUtils.waitForVisiblityOf(homePageObject.getContactButton());
        waitUtils.bringElementToViewport(homePageObject.getContactButton());
        homePageObject.getContactButton().click();
        waitUtils.waitForUrlToContains("/kontakt-oss",2);
    }
}
