import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PAYMENTMETHODS;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class SDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;

    private void purchaseFlowSDUUser(String username, boolean membershipNumberNecessary, String membershipNumber, PAYMENTMETHODS paymentMethod, boolean fourteenDaysInstallation) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1!@");
        if (membershipNumberNecessary){
            customizationPageOperations.fillMembershipNumber(membershipNumber);
        }
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "9990", fourteenDaysInstallation);
        summaryPageOperations.pay(paymentMethod);
    }

    @BeforeMethod private void initOperations() {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
    }

    @TestCaseId(testRailCaseId = 4612)
    @Test
    public void NafSDUPartnerFlow() throws TimeoutException {
        customizationPageOperations.goToNafSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, null, PAYMENTMETHODS.VISA, false);
    }

    @TestCaseId(testRailCaseId = 6093)
    @Test
    public void SmbSDUPartnerFlow() throws TimeoutException {
        customizationPageOperations.goToSmbSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, null, PAYMENTMETHODS.MASTERCARD, false);
    }

    @TestCaseId(testRailCaseId = 6092)
    @Test
    public void IglandSDUPartnerFlow() throws TimeoutException {
        customizationPageOperations.goToSmbSDUPartner();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowSDUUser("easeeinstallation@mailinator.com", false, null, PAYMENTMETHODS.INVOICE, false);
    }
}
