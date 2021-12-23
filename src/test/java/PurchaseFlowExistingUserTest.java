import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PAYMENTMETHODS;
import operations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private HomePageOperations homePageOperations;
    private ProductsPageOperations productsPageOperations;
    private HousePageOperations housePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private NavbarOperations navbarOperations;
    private WaitUtils waitUtils;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
        waitUtils = new WaitUtils(driver);
    }

    private void purchaseFlowExistingUser(String username, boolean fourteenDaysInstallation, PAYMENTMETHODS paymentMethod) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1!@");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "3000", fourteenDaysInstallation);
        summaryPageOperations.pay(paymentMethod);
    }

    @TestCaseId(testRailCaseId = 2506)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 1225)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowExistingUser("easeenoextra@mailinator.com",  false, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 4775)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com",false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2514)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 5488)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationAsProduct() throws TimeoutException {
        productsPageOperations.openInstallationPurchaseFlow();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 5052)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com",true, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 6099)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeenoextra@mailinator.com",false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 4061)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeewithextra@mailinator.com",false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 6098)
    @Test(alwaysRun = true)
    public void testEqualizerWithoutExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 5556)
    @Test(alwaysRun = true)
    public void test2FactorAuthentication3DS1() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.TWOFACTORTYPE1);
    }

    @TestCaseId(testRailCaseId = 5557)
    @Test
    public void test2FactorAuthentication3DS2() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.TWOFACTORTYPE2);
    }

    @TestCaseId(testRailCaseId = 5565)
    @Test
    public void testCanceledPaymentStatus() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.KLARNA);
        waitUtils.waitForElementToBeClickable(By.xpath("//*[contains(text(),'Tilbake')]"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('back-button__text').click();");
        waitUtils.waitForUrlToContains("/order/payment-result");
    }
}