import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class EaseePurchaseFlowExistingUserTest extends TestsBase {

    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;


    @BeforeMethod
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
    }

    public void purchaseFlowExistingUser(String username, boolean extraDiscount) {
        customizationPageOperations.clickNextButton();
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
        summaryPageOperations.clickNext();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
        homePageOperations.logOut();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void testEaseePurchaseFlowWithNoExtra() {
        homePageOperations.openEaseePurchaseFlowNoExtra();
        purchaseFlowExistingUser("testEaseePurchaseFlowWithNoExtra@mailinator.com", false);
    }

    @Test
    public void testEaseePurchaseFlowWithExtra() {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("michal.sepczuk+1@edge1s.com", true);
    }

    @Test
    public void testCablePurchaseFlowWithNoExtra() {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("michal.sepczuk+6@edge1s.com", false);
    }

    @Test
    public void testCablePurchaseFlowWithExtra() {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("michal.sepczuk+1@edge1s.com", true);
    }

    @Test
    public void testMennekesPurchaseFlowWithNoExtra() {
        homePageOperations.openMennekesPurchaseFlow();
        purchaseFlowExistingUser("michal.sepczuk+6@edge1s.com", false);
    }

    @Test
    public void testMennekesPurchaseFlowWithExtra() {
        homePageOperations.openMennekesPurchaseFlow();
        purchaseFlowExistingUser("michal.sepczuk+1@edge1s.com", true);
    }

}
