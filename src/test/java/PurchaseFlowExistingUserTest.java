import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PAYMENTMETHODS;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
    }

    private void purchaseFlowExistingUser(String username, boolean extraDiscount, boolean fourteenDaysInstallation, PAYMENTMETHODS paymentMethod) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1!@");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "72433");
        summaryPageOperations.assertExtraDiscount(extraDiscount);
        summaryPageOperations.pay(paymentMethod, fourteenDaysInstallation);
    }

    @TestCaseId(testRailCaseId = 2872)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", true, false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2873)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, false, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 2876)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com", false, false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2874)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        purchaseFlowExistingUser("mennekesnoextra@mailinator.com", false, false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 2875)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithExtra();
        purchaseFlowExistingUser("mennekeswithextra@mailinator.com", true, false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 2879)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2880)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekesinstallation@mailinator.com", false, false, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 2877)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", false, true, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 2878)
    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekes14daysinstallation@mailinator.com", false, true, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 4064)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 4065)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", true, false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 4066)
    @Test(alwaysRun = true)
    public void testEqualizerWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, false, PAYMENTMETHODS.VISA);
    }
}
