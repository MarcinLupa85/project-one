import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;
import static org.testng.Assert.*;

public class PurchaseFlowExistingUserTest extends TestsBase {
    private static final String VISA = "4988 4388 4388 4305";
    private static final String MASTERCARD = "5101 1800 0000 0007";

    private MailinatorPageOperations mailinatorPageOperations;
    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private WaitUtils waitUtils;

    @BeforeMethod(alwaysRun = true)
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

    private void purchaseFlowExistingUser(String username, boolean extraDiscount, boolean fourteenDaysInstallation, String paymentMethod) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "72433");
        summaryPageOperations.assertExtraDiscount(extraDiscount);
        summaryPageOperations.pay(paymentMethod, fourteenDaysInstallation);
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
    }

    //Deleted AfterMethod due to TestNG defect: When there is a failed assertion within AfterMethod, the following tests would be ignored

    @TestCaseId(testRailCaseId = 2872)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", true, false, "Visa");
        mailinatorPageOperations.checkMailForLackOfPhrase("easeewithextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2873)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, false, "Mastercard");
        mailinatorPageOperations.checkMailForLackOfPhrase("easeenoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2876)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com", false, false, "Visa");
        mailinatorPageOperations.checkMailForLackOfPhrase("cablenoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2874)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        purchaseFlowExistingUser("mennekesnoextra@mailinator.com", false, false, "Invoice");
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekesnoextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2875)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("mennekeswithextra@mailinator.com", true, false, "Klarna");
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekeswithextra@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2879)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, false, "Visa");
        mailinatorPageOperations.checkMailForLackOfPhrase("easeeinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2880)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekesinstallation@mailinator.com", false, false, "Mastercard");
        mailinatorPageOperations.checkMailForLackOfPhrase("mennekesinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2877)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", false, true, "Mastercard");
        mailinatorPageOperations.checkMailForPhrase("easee14daysinstallation@mailinator.com");
    }

    @TestCaseId(testRailCaseId = 2878)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekes14daysinstallation@mailinator.com", false, true, "Invoice");
        mailinatorPageOperations.checkMailForPhrase("mennekes14daysinstallation@mailinator.com");
    }
}
