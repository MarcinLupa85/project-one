import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.ProductsPageOperations;
import operations.PurchaseFlowsOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.PurchaseData;

import java.util.concurrent.TimeoutException;

import static enums.PaymentMethod.*;
import static testdata.EvUsers.*;

public class PurchaseFlowNewUserTest extends TestsBase {
    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;

    @BeforeMethod
    private void initOperations() {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
    }

    @TestCaseId(testRailCaseId = 1821)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(NEW_EASEE_WITH_EXTRA)
                .withPhone("575437397")
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(MASTERCARD);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowNewUser(purchaseData);
    }

    @TestCaseId(testRailCaseId = 2507)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(NEW_EASEE_NO_EXTRA)
                .withPaymentMethod(KLARNA)
                .withPhone("575437666")
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowNewUser(purchaseData);
    }

    @TestCaseId(testRailCaseId = 5049)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(NEW_CABLE_NO_EXTRA)
                .withPhone("575437306")
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(INVOICE);

        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowNewUser(purchaseData);
    }

    @TestCaseId(testRailCaseId = 2512)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(NEW_EASEE_WITH_INSTALLATION)
                .withPhone("575437307")
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(KLARNA);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowNewUser(purchaseData);
    }
}
