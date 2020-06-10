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
    private CkidDashboardPageOperations ckidDashboardPageOperations;
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
        ckidDashboardPageOperations = new CkidDashboardPageOperations(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void purchaseFlowExistingUser(String username, boolean extraDiscount, boolean fourteenDaysInstallation) throws TimeoutException {
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
        summaryPageOperations.clickNext();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
        homePageOperations.logOut();
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @AfterMethod
    private void goBack() {
        driver.navigate().to(BASE_URL);
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", true, false);
        mailinatorPageOperations.checkMailinator("easeewithextra@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailinator("easeenoextra@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException{
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailinator("cablenoextra@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        purchaseFlowExistingUser("mennekesnoextra@mailinator.com", false, false);
        mailinatorPageOperations.checkMailinator("mennekesnoextra@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("mennekeswithextra@mailinator.com", true, false);
        mailinatorPageOperations.checkMailinator("mennekeswithextra@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, false);
        mailinatorPageOperations.checkMailinator("easeeinstallation@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekesinstallation@mailinator.com", false, false);
        mailinatorPageOperations.checkMailinator("mennekesinstallation@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testEaseePurchasePlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", false, true);
        mailinatorPageOperations.checkMailContent("easee14daysinstallation@mailinator.com");
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchasePlow14DaysInstallation() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        purchaseFlowExistingUser("mennekes14daysinstallation@mailinator.com", false, true);
        mailinatorPageOperations.checkMailContent("mennekes14daysinstallation@mailinator.com");
    }

}
