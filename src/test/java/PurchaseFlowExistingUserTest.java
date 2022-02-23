import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PaymentMethod;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;
    private PasswordUtils passwordUtils;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() throws Exception {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        passwordUtils = new PasswordUtils();
    }

    @TestCaseId(testRailCaseId = 2506)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 1225)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeenoextra@mailinator.com", false, PaymentMethod.MASTERCARD);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 4775)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser("cablenoextra@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 2514)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 5488)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationAsProduct() throws TimeoutException {
        productsPageOperations.openInstallationPurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.INVOICE);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5052)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", true, PaymentMethod.MASTERCARD);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6099)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeenoextra@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 4061)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.INVOICE);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6098)
    @Test(alwaysRun = true)
    public void testEqualizerWithoutExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }
}
