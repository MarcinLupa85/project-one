import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.ProductsPageOperations;
import operations.PurchaseFlowsOperations;
import operations.SummaryPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.PurchaseData;

import java.util.concurrent.TimeoutException;

import static enums.PaymentMethod.*;
import static testdata.EvUsers.*;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);;
    }

    @TestCaseId(testRailCaseId = 2506)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_EXTRA)
                .withPaymentMethod(VISA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 1225)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_NO_EXTRA)
                .withPaymentMethod(MASTERCARD)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 4775)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(CABLE_NO_EXTRA)
                .withPaymentMethod(VISA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 2514)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_INSTALLATION)
                .withPaymentMethod(KLARNA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
    }

    @TestCaseId(testRailCaseId = 5488)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationAsProduct() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_INSTALLATION)
                .withPaymentMethod(INVOICE)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openInstallationPurchaseFlow();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5052)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_14_DAYS_INSTALLATION)
                .withPaymentMethod(MASTERCARD)
                .withFourteenDaysInstallation(true);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6099)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_INSTALLATION)
                .withPaymentMethod(KLARNA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
    }

    @TestCaseId(testRailCaseId = 4061)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_EXTRA)
                .withPaymentMethod(INVOICE)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6098)
    @Test(alwaysRun = true)
    public void testEqualizerWithoutExtra() throws TimeoutException {
        PurchaseData defaultPurchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_INSTALLATION)
                .withPaymentMethod(VISA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowsOperations.purchaseFlowExistingUser(defaultPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }
}
