import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.ProductsPageOperations;
import operations.PurchaseFlowsOperations;
import operations.SummaryPageOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.PurchaseData;
import utils.PasswordUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static enums.PaymentMethod.*;
import static testdata.EvUsers.*;

public class PaymentsTests extends TestsBase {
    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;
    private WaitUtils waitUtils;
    private PasswordUtils passwordUtils;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() throws Exception {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        waitUtils = new WaitUtils(driver);
        passwordUtils = new PasswordUtils();
    }

    @TestCaseId(testRailCaseId = 5556)
    @Test(alwaysRun = true)
    public void test2FactorAuthentication3DS1() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(EASEE_NO_EXTRA)
                .withPaymentMethod(TWOFACTORTYPE1)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(purchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5557)
    @Test
    public void test2FactorAuthentication3DS2() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_EXTRA)
                .withPaymentMethod(TWOFACTORTYPE2)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(purchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5565)
    @Test
    public void testCanceledPaymentStatus() throws TimeoutException {
        PurchaseData purchaseData = new PurchaseData()
                .withEmail(EASEE_WITH_EXTRA)
                .withPaymentMethod(KLARNA)
                .withFourteenDaysInstallation(false);

        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser(purchaseData);
        waitUtils.waitForElementToBeClickable(By.xpath("//*[contains(text(),'Tilbake')]"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('back-button__text').click();");
        waitUtils.waitForUrlToContain("/order/payment-result");
        summaryPageOperations.assertCancelledOrderPage();
    }
}
