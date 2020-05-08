import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
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

    public void purchaseFlowNewUser(String phoneNumber, String username, boolean extraDiscount) {
        long getTimeNow = mailinatorPageOperations.getTimeNow();
        customizationPageOperations.clickNextButton();
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

    @AfterMethod(alwaysRun = true)
    private void cleanUp() {
        ckidDashboardPageOperations.deleteAccount();
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        phoneNumber = "575437400";
        userName = "testeaseenoextra" + mailinatorPageOperations.getTimeNow() + "@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        phoneNumber = "575437399";
        userName = "testeaseewithextra" + mailinatorPageOperations.getTimeNow() + "@mailinator.com";
        extraDiscount = true;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test
    public void testCablePurchaseFlowWithNoExtra() {
        homePageOperations.openCablePurchaseFlow();
        phoneNumber = "575437402";
        userName = "testcablenoextra" + mailinatorPageOperations.getTimeNow() + "@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test
    public void testMennekesPurchaseFlowWithNoExtra() {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        phoneNumber = "575437404";
        userName = "testmennekesnoextra" + mailinatorPageOperations.getTimeNow() + "@mailinator.com";
        extraDiscount = false;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

    @Test
    public void testMennekesPurchaseFlowWithExtra() {
        homePageOperations.openMennekesPurchaseFlowWithExtra();
        phoneNumber = "575437405";
        userName = "testmennekeswithextra" + mailinatorPageOperations.getTimeNow() + "@mailinator.com";
        extraDiscount = true;
        purchaseFlowNewUser(phoneNumber, userName, extraDiscount);
        mailinatorPageOperations.checkMailinator(userName);
    }

}


