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

public class PurchaseFlowExistingUserTest extends TestsBase {
    private MailinatorPageOperations mailinatorPageOperations;
    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private WaitUtils waitUtils;


    @BeforeMethod
    private void initOperations() {
        mailinatorPageOperations = new MailinatorPageOperations(driver);
        homePageOperations = new HomePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        waitUtils = new WaitUtils(driver);
    }

    private void purchaseFlowExistingUser(String username, boolean extraDiscount, boolean fourteenDaysInstallation) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        addressPageOperations.fillBillingAddress("Test Addresse 582");
        addressPageOperations.fillBillingCity("Test Billing City");
        addressPageOperations.fillBillingZipCode("72433");
        addressPageOperations.clickNext(); //TODO: change to DriverUtils.clicknext
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        if (fourteenDaysInstallation) {
            summaryPageOperations.tick14DaysCheckbox();
        }
        summaryPageOperations.clickFinish();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();

    }

    @AfterMethod
    private void goBack() throws TimeoutException {
        driver.navigate().to(BASE_URL);
        homePageOperations.logOut();
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @TestCaseId(testRailCaseId = 2872)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", true, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("easeewithextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2873)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("easeenoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2876)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException{
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("cablenoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2874)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        purchaseFlowExistingUser("mennekesnoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekesnoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2875)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("mennekeswithextra@mailinator.com", true, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekeswithextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2879)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("easeeinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2880)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekesinstallation@mailinator.com", false, false);
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekesinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2877)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", false, true);
        mailinatorPageOperations.checkMailForPhrase("easee14daysinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2878)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekes14daysinstallation@mailinator.com", false, true);
        mailinatorPageOperations.checkMailForPhrase("mennekes14daysinstallation@mailinator.com");
    }

}
