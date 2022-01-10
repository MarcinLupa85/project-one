package operations;

import org.openqa.selenium.By;
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
        waitUtils.waitForVisiblityOf(easeeLink);
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openEqualizerPurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement equalizerName = driver.findElement(By.cssSelector("img[src='assets/images/products/cards/equalizer/equalizer-1.jpg']"));
        waitUtils.bringElementToViewport(equalizerName);
        productsPageObject.getPurchaseFlowEqualizerLink().click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openCablePurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement cableLink = productsPageObject.getPurchaseFlowCableLink();
        waitUtils.waitForVisiblityOf(cableLink);
        cableLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }

    public void openInstallationPurchaseFlow() throws TimeoutException {
        driver.navigate().to(BASE_URL + PRODUCTS_INSTALLATION_PAGE);
        waitUtils.waitForDocumentReadyState();
        WebElement installationLink = productsPageObject.getPurchaseInstallationButton();
        waitUtils.waitForVisiblityOf(installationLink);
        installationLink.click();
        waitUtils.waitForUrlToContain(BESTILL_CUSTOMIZE_ORDER_URL);
    }
}
