import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.AddressPageOperations;
import operations.CkidPageOperations;
import operations.CustomizationPageOperations;
import operations.SummaryPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.ClientInfo;
import testdata.SduPurchaseData;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

import static enums.PaymentMethod.*;

public class SDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private PasswordUtils passwordUtils;
    private String decryptedString;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
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
        purchaseFlowSDUUser(sduPurchaseData);
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
        purchaseFlowSDUUser(sduPurchaseData);
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
        purchaseFlowSDUUser(sduPurchaseData);
        summaryPageOperations.assertThankYouPage();
    }

    private void purchaseFlowSDUUser(SduPurchaseData sduPurchaseData) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2))
                .withFourteenDaysInstallation(sduPurchaseData.isFourteenDaysInstallation());

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(sduPurchaseData.getEmail(), decryptedString);
        if (sduPurchaseData.isMembershipNumberNecessary()) {
            customizationPageOperations.fillMembershipNumber(sduPurchaseData.getMembershipNumber());
        }
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(sduPurchaseData.getPaymentMethod());
    }
}
