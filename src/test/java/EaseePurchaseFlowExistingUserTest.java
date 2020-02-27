import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
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


    public void easeePurchaseFlowExistingUser(String username, boolean extraDiscount) {
        homePageOperations.openEaseePurchaseFlow();
        customizationPageOperations.clickNextButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
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
        homePageOperations.logOut();
        assertThat(driver.getCurrentUrl().contains("/home"));

    }


    @Test
    public void testEaseePurchaseFlowWithNoExtra() {
        easeePurchaseFlowExistingUser("michal.sepczuk+1@edge1s.com", false);
    }

    @Test
    public void testEaseePurchaseFlowWithExtra() {
        easeePurchaseFlowExistingUser("michal.sepczuk25@circlekeurope.com", true);
    }


//    @Test
//    public void testEaseePurchaseFlowWithNoExtra() {
//        homePageOperations.openEaseePurchaseFlow();
//        customizationPageOperations.clickNextButton();
//        ckidPageOperations.logInWithCredentials("michal.sepczuk+6@edge1s.com", "Emobility1");
//        addressPageOperations.fillBillingAddress("Test Addresse 582");
//        addressPageOperations.fillBillingCity("Test Billing City");
//        addressPageOperations.fillBillingZipCode("72433");
//        addressPageOperations.clickNext(); //TODO: zmienić na DriverUtils.clicknext
//        assertFalse(summaryPageOperations.hasExtraDiscount());
//        summaryPageOperations.tickTcCheckbox();
//        summaryPageOperations.clickNext();
//        assertSame(completePageOperations.getEmail(), "michal.sepczuk+6@edge1s.com");
//        completePageOperations.clickBack();
//        homePageOperations.logOut();
//        assertThat(driver.getCurrentUrl().contains("/home"));
//
//    }


//    @Test
//    public void testEaseePurchaseFlowWithExtra() {
//        homePageOperations.openEaseePurchaseFlow();
//        assertThat(driver.getCurrentUrl()).contains("/hjemmelading-bestill/customize-order");
//        customizationPageOperations.clickNextButton();
//        assertThat(driver.getCurrentUrl().contains("circlekid-core"));
//        ckidPageOperations.logInWithCredentials("michal.sepczuk+1@edge1s.com", "Emobility1");
//        assertThat(driver.getCurrentUrl().contains("house-order/delivery-order"));
//        addressPageOperations.fillBillingAddress("Test Addresse 582");
//        addressPageOperations.fillBillingCity("Test Billing City");
//        addressPageOperations.fillBillingZipCode("72433");
//        addressPageOperations.clickNext();
//        assertThat(driver.getCurrentUrl().contains("hjemmelading-bestill/confirm-order"));
//        summaryPageOperations.tickTcCheckbox();
//        summaryPageOperations.clickNext();
//        assertThat(driver.getCurrentUrl().contains("hjemmelading-bestill/complete"));
//        completePageOperations.clickBack();
//        assertThat(driver.getCurrentUrl().contains("/home"));
//    }

}