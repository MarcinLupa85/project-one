import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.testng.Assert.*;


public class EaseePurchaseFlowNewUserTest extends TestsBase {

     private HomePageOperations homePageOperations;
     private CustomizationPageOperations customizationPageOperations;
     private CkidPageOperations ckidPageOperations;
     private AddressPageOperations addressPageOperations;
     private SummaryPageOperations summaryPageOperations;
     private CompletePageOperations completePageOperations;
     private CkidDashboardPageOperations ckidDashboardPageOperations;


    @BeforeMethod
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        ckidDashboardPageOperations = new CkidDashboardPageOperations(driver);
    }

    public void purchaseFlowNewUser(String phoneNumber, String username, boolean extraDiscount) {
        customizationPageOperations.clickNextButton();
        ckidPageOperations.registerNewUser(phoneNumber, username, "Emobility1");
        addressPageOperations.fillBillingAddress("Test Addresse 582");
        addressPageOperations.fillBillingCity("Test Billing City");
        addressPageOperations.fillBillingZipCode("72433");
        addressPageOperations.clickNext(); //TODO: zmienić na DriverUtils.clicknext
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.tickTcCheckbox();
        summaryPageOperations.clickNext();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
        assertThat(driver.getCurrentUrl().contains("/home"));
        ckidDashboardPageOperations.deleteAccount();

    }


    @Test
    public void testEaseePurchaseFlowWithNoExtra() {
        homePageOperations.openEaseePurchaseFlow();
        purchaseFlowNewUser("575437499", "michal.sepczuk+noextra@edge1s.com", false);
    }

    @Test
    public void testEaseePurchaseFlowWithExtra() {
        homePageOperations.openEaseePurchaseFlow();
        purchaseFlowNewUser("575437499", "michal.sepczuk+extra@edge1s.com",true);
    }


    @Test
    public void testCablePurchaseFlowWithNoExtra() {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowNewUser("575437500", "michal.sepczuk+noextra@edge1s.com", false);
    }

    @Test
    public void testCablePurchaseFlowWithExtra() {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowNewUser("575437500", "michal.sepczuk+extra@edge1s.com",true);
    }

    @Test
    public void testMennekesPurchaseFlowWithNoExtra() {
        homePageOperations.openMennekesPurchaseFlow();
        purchaseFlowNewUser("575437500", "michal.sepczuk+noextra@edge1s.com", false);
    }

    @Test
    public void testMennekesPurchaseFlowWithExtra() {
        homePageOperations.openMennekesPurchaseFlow();
        purchaseFlowNewUser("575437500", "michal.sepczuk+extra@edge1s.com",true);
    }

}


