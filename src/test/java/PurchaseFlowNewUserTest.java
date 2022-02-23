import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.ProductsPageOperations;
import operations.PurchaseFlowsOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.NewUserPurchaseData;

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
    }

    @TestCaseId(testRailCaseId = 1821)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        NewUserPurchaseData newUserPurchaseData = new NewUserPurchaseData()
                .withPhone("575437397")
                .withEmail(NEW_EASEE_WITH_EXTRA)
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(MASTERCARD);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowNewUser(newUserPurchaseData);
    }

    @TestCaseId(testRailCaseId = 2507)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        NewUserPurchaseData newUserPurchaseData = new NewUserPurchaseData()
                .withPhone("575437666")
                .withEmail(NEW_EASEE_NO_EXTRA)
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(KLARNA);

        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowNewUser(newUserPurchaseData);
    }

    @TestCaseId(testRailCaseId = 5049)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        NewUserPurchaseData newUserPurchaseData = new NewUserPurchaseData()
                .withPhone("575437306")
                .withEmail(NEW_CABLE_NO_EXTRA)
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(INVOICE);

        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowsOperations.purchaseFlowNewUser(newUserPurchaseData);
    }

    @TestCaseId(testRailCaseId = 2512)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        NewUserPurchaseData newUserPurchaseData = new NewUserPurchaseData()
                .withPhone("575437307")
                .withEmail(NEW_EASEE_WITH_INSTALLATION)
                .withFourteenDaysInstallation(false)
                .withPaymentMethod(KLARNA);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowsOperations.purchaseFlowNewUser(newUserPurchaseData);
    }
}
