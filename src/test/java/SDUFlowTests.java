import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private HomePageOperations homePageOperations;
    private PartnerOrderOperations partnerOrderOperations;
    private WaitUtils waitUtils;

    private void purchaseFlowSDUUser(String username, boolean extraDiscount, boolean membershipNumberNecessary, String membershipNumber) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        addressPageOperations.fillBillingAddress("Test Addresse 582");
        addressPageOperations.fillBillingCity("Test Billing City");
        addressPageOperations.fillBillingZipCode("72433");
        if (membershipNumberNecessary){
            customizationPageOperations.fillMembershipNumber(membershipNumber);
        }
        addressPageOperations.clickNext(); //TODO: change to DriverUtils.clicknext
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
    }

    @BeforeMethod private void initOperations() {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        homePageOperations = new HomePageOperations(driver);
        partnerOrderOperations = new PartnerOrderOperations(driver);
        waitUtils = new WaitUtils(driver);
    }

    @AfterMethod
    private void goBack() throws TimeoutException {
        driver.navigate().to(BASE_URL);
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @TestCaseId(testRailCaseId = 2885)
    @Test
    public void inglandGarasjenSDUFlow() throws TimeoutException {
        customizationPageOperations.goToInglandGarasjen();
        customizationPageOperations.checkInglandGarasjenPrice();
        purchaseFlowSDUUser("sdueaseenoextra@mailinator.com", false, false, null);
    }

    @TestCaseId(testRailCaseId = 2886)
    @Test
    public void obosSDUFlow() throws TimeoutException {
        customizationPageOperations.goToObos();
        customizationPageOperations.checkObosPrice();
        purchaseFlowSDUUser("sduuserwithextra@mailinator.com", true, true, "1234");
    }

    @TestCaseId(testRailCaseId = 2887)
    @Test
    public void polestarSDUFlow() throws TimeoutException {
        customizationPageOperations.goToPolestar();
        customizationPageOperations.checkPolestarPrice();
        purchaseFlowSDUUser("sduuserinstallationonly@mailinator.com", false, false, null);
    }

    @TestCaseId(testRailCaseId = 2982)
    @Test
    public void elkjopSDUFlow() {
        partnerOrderOperations.goToElkjop();
        partnerOrderOperations.fillElkjopForm("Test", "Kowalski", "sduelkjopnoinstallationy@mailinator.com", "575437667", "Test Addresse 582", "72433", "Test Billing City");
        partnerOrderOperations.submitOrder();
    }

    @TestCaseId(testRailCaseId = 2983)
    @Test
    public void elkjopWithInstallationSDUFlow() {
        partnerOrderOperations.goToElkjop();
        partnerOrderOperations.tickInstallationCheckbox();
        partnerOrderOperations.fillElkjopForm("Test", "Kowalski", "sduelkjopnoinstallationy@mailinator.com", "575437667", "Test Addresse 582", "72433", "Test Billing City");
        partnerOrderOperations.submitOrder();
    }
}
