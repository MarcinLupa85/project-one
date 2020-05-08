import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


    @BeforeMethod
    private void initOperations() {
        mailinatorPageOperations = new MailinatorPageOperations(driver);
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
        purchaseFlowExistingUser("testeaseenoextra@mailinator.com", false);
        mailinatorPageOperations.checkMailinator("testeaseenoextra@mailinator.com");
    }

    @Test
    public void testEaseePurchaseFlowWithExtra() {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("testeaseewithextra@mailinator.com", true);
        mailinatorPageOperations.checkMailinator("testeaseewithextra@mailinator.com");
    }

    @Test
    public void testCablePurchaseFlowWithNoExtra() {
        homePageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("testcablenoextra@mailinator.com", false);
        mailinatorPageOperations.checkMailinator("testcablenoextra@mailinator.com");
    }

    @Test
    public void testMennekesPurchaseFlowWithNoExtra() {
        homePageOperations.openMennekesPurchaseFlowNoExtra();
        purchaseFlowExistingUser("testmennekesnoextra@mailinator.com", false);
        mailinatorPageOperations.checkMailinator("testmennekesnoextra@mailinator.com");
    }

    @Test
    public void testMennekesPurchaseFlowWithExtra() {
        homePageOperations.openEaseePurchaseFlowWithExtra();
        purchaseFlowExistingUser("testmennekeswithextra@mailinator.com", true);
        mailinatorPageOperations.checkMailinator("testmennekeswithextra@mailinator.com");
    }

}
