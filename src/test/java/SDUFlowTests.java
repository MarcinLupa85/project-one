import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.PurchaseFlowsOperations;
import operations.SummaryPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.SduPurchaseData;

import java.util.concurrent.TimeoutException;

import static enums.PaymentMethod.*;

public class SDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
    }

    @TestCaseId(testRailCaseId = 4601)
    @Test
    public void NafSDUPartnerFlow() throws TimeoutException {
        SduPurchaseData sduPurchaseData = new SduPurchaseData()
                .withEmail("sdueaseenoextra@mailinator.com")
                .withMembershipNumberNecessary(false)
                .withPaymentMethod(KLARNA)
                .withFourteenDaysInstallation(false);

        customizationPageOperations.goToNafSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowsOperations.purchaseFlowSDUUser(sduPurchaseData);
    }

    @TestCaseId(testRailCaseId = 4597)
    @Test
    public void SmbSDUPartnerFlow() throws TimeoutException {
        SduPurchaseData sduPurchaseData = new SduPurchaseData()
                .withEmail("sdueaseenoextra@mailinator.com")
                .withMembershipNumberNecessary(false)
                .withPaymentMethod(MASTERCARD)
                .withFourteenDaysInstallation(false);

        customizationPageOperations.goToSmbSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowsOperations.purchaseFlowSDUUser(sduPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 4595)
    @Test
    public void IglandSDUPartnerFlow() throws TimeoutException {
        SduPurchaseData sduPurchaseData = new SduPurchaseData()
                .withEmail("easeeinstallation@mailinator.com")
                .withMembershipNumberNecessary(false)
                .withPaymentMethod(INVOICE)
                .withFourteenDaysInstallation(false);

        customizationPageOperations.goToIglandSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowsOperations.purchaseFlowSDUUser(sduPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }
}
