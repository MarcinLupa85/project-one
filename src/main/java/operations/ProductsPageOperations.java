package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ProductsPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

public class ProductsPageOperations {
    ProductsPageObject productsPageObject;
    NavbarOperations navbarOperations;
    private WaitUtils waitUtils;
    private WebDriver driver;


    public ProductsPageOperations(WebDriver driver){
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
        waitUtils.waitForUrlToContains("/bestill/customize-order");
    }

    public void openEqualizerPurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement equalizerName = driver.findElement(By.cssSelector("img[src='assets/images/products/cards/equalizer/equalizer-1.jpg']"));
        waitUtils.bringElementToViewport(equalizerName);
        productsPageObject.getPurchaseFlowEqualizerLink().click();
        waitUtils.waitForUrlToContains("/bestill/customize-order");
    }

    public void openCablePurchaseFlow() throws TimeoutException {
        navbarOperations.openProductsPage();
        waitUtils.waitForDocumentReadyState();
        WebElement cableLink = productsPageObject.getPurchaseFlowCableLink();
        waitUtils.waitForVisiblityOf(cableLink);
        cableLink.click();
        waitUtils.waitForUrlToContains("/bestill/customize-order");
    }
}
