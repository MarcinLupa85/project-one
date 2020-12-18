import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PAYMENTMETHODS;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;
import static org.testng.Assert.*;

public class SDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;

    private void purchaseFlowSDUUser(String username, boolean extraDiscount, boolean membershipNumberNecessary, String membershipNumber, PAYMENTMETHODS paymentMethod, boolean fourteenDaysInstallation) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        if (membershipNumberNecessary){
            customizationPageOperations.fillMembershipNumber(membershipNumber);
        }
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "9990");
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.pay(paymentMethod, fourteenDaysInstallation);
    }

    @BeforeMethod private void initOperations() {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
    }

    @TestCaseId(testRailCaseId = 2885)
    @Test
    public void inglandGarasjenSDUFlow() throws TimeoutException {
        customizationPageOperations.goToInglandGarasjen();
        customizationPageOperations.checkInglandGarasjenPrice();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, false, null, PAYMENTMETHODS.VISA, false);
    }

    @TestCaseId(testRailCaseId = 2886)
    @Test
    public void obosSDUFlow() throws TimeoutException {
        customizationPageOperations.goToObos();
        customizationPageOperations.checkObosPrice();
        purchaseFlowSDUUser("sduuserwithextra@mailinator.com", true, true, "1234", PAYMENTMETHODS.KLARNA, false);
    }

    @TestCaseId(testRailCaseId = 2887)
    @Test
    public void polestarSDUFlow() throws TimeoutException {
        customizationPageOperations.goToPolestar();
        customizationPageOperations.checkPolestarPrice();
        purchaseFlowSDUUser("sduuserinstallationonly@mailinator.com", false, false, null, PAYMENTMETHODS.INVOICE, false);
    }

}
