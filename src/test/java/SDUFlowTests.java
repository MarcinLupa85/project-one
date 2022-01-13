import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PaymentMethod;
import operations.AddressPageOperations;
import operations.CkidPageOperations;
import operations.CustomizationPageOperations;
import operations.SummaryPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

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
        customizationPageOperations.goToNafSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, null, PaymentMethod.KLARNA, false);
    }

    @TestCaseId(testRailCaseId = 4597)
    @Test
    public void SmbSDUPartnerFlow() throws TimeoutException {
        customizationPageOperations.goToSmbSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, null, PaymentMethod.MASTERCARD, false);
    }

    @TestCaseId(testRailCaseId = 4595)
    @Test
    public void IglandSDUPartnerFlow() throws TimeoutException {
        customizationPageOperations.goToIglandSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("easeeinstallation@mailinator.com", false, null, PaymentMethod.INVOICE, false);
    }

    private void purchaseFlowSDUUser(String username, boolean membershipNumberNecessary, String membershipNumber, PaymentMethod paymentMethod, boolean fourteenDaysInstallation) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, decryptedString);
        if (membershipNumberNecessary) {
            customizationPageOperations.fillMembershipNumber(membershipNumber);
        }
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "9990", fourteenDaysInstallation);
        summaryPageOperations.pay(paymentMethod);
    }
}
