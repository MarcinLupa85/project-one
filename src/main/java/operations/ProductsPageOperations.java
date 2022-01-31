package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ProductsPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.Navbar.PRODUCTS_INSTALLATION_PAGE;

public class ProductsPageOperations {
    private static final String BESTILL_CUSTOMIZE_ORDER_URL = "/bestill/customize-order";
    ProductsPageObject productsPageObject;
    NavbarOperations navbarOperations;
    private WaitUtils waitUtils;
    private WebDriver driver;


    public ProductsPageOperations(WebDriver driver) {
        productsPageObject = new ProductsPageObject(driver);
        navbarOperations = new NavbarOperations(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public void openEaseePurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement easeeLink = productsPageObject.getPurchaseFlowEaseeLink();
        waitUtils.waitForElementToBeClickable(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openEqualizerPurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        waitUtils.waitForElementToBeClickable(productsPageObject.getPurchaseFlowEqualizerLink());
        waitUtils.bringElementToViewport(productsPageObject.getPurchaseFlowEqualizerLink());
        productsPageObject.getPurchaseFlowEqualizerLink().click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openCablePurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement cableLink = productsPageObject.getPurchaseFlowCableLink();
        waitUtils.waitForElementToBeClickable(cableLink);
        cableLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openInstallationPurchaseFlow() throws TimeoutException {
        driver.navigate().to(BASE_URL + PRODUCTS_INSTALLATION_PAGE);
        waitUtils.waitForDocumentReadyState();
        WebElement installationLink = productsPageObject.getPurchaseInstallationButton();
        waitUtils.waitForElementToBeClickable(installationLink);
        installationLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }
}
