import config.TestsBase;
import operations.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PurchaseFlowNewUserTest extends TestsBase {
    private MailinatorPageOperations mailinatorPageOperations;
    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private CkidDashboardPageOperations ckidDashboardPageOperations;
    private String phoneNumber, userName;
    private Boolean extraDiscount;

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
    }

    private void purchaseFlowNewUser(String phoneNumber, String username, boolean extraDiscount) {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.registerNewUser(phoneNumber, username, "Emobility1");
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
        summaryPageOperations.clickNext();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @AfterMethod
    private void cleanUp(ITestResult result) {
        if (result.isSuccess()) {
            ckidDashboardPageOperations.deleteAccount();
        }
    }


    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        phoneNumber = "575437398";
        userName = "newuser.easeewithextra@mailinator.com";
        extraDiscount = true;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        phoneNumber = "575437666";
        userName = "newuser.easeenoextra@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() {
        homePageOperations.openCablePurchaseFlow();
        phoneNumber = "575437306";
        userName = "newuser.cablenoextra@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithNoExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        phoneNumber = "575437304";
        userName = "newuser.mennekesnoextra@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithExtra() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithExtra();
        phoneNumber = "575437305";
        userName = "newuser.mennekeswithextra@mailinator.com";
        extraDiscount = true;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openEaseePurchaseFlowWithInstallationOnly();
        phoneNumber = "575437307";
        userName = "newuser.easeeinstallation@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testMennekesPurchaseFlowWithInstallationOnly() throws TimeoutException {
        homePageOperations.openMennekesPurchaseFlowWithInstallationOnly();
        phoneNumber = "575437308";
        userName = "newuser.mennekesinstallation@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

}


