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

public class MDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private HomePageOperations homePageOperations;
    private WaitUtils waitUtils;

    private void purchaseFlowMDUUser(String username, boolean extraDiscount) {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        addressPageOperations.fillBillingAddress("Test Addresse 582");
        addressPageOperations.fillBillingCity("Test Billing City");
        addressPageOperations.fillBillingZipCode("72433");
        addressPageOperations.fillCondominiumName("Test Condominium");
        addressPageOperations.fillParkingPlace("23");
        addressPageOperations.clickNextApartmentFlow();
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinishApartmentFlow();
        assertEquals(completePageOperations.getEmail(), username);
        completePageOperations.clickBack();
    }

    @BeforeMethod
    private void initOperations() {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        homePageOperations = new HomePageOperations(driver);
        waitUtils = new WaitUtils(driver);
    }

    @AfterMethod
    private void goBack() throws TimeoutException {
        driver.navigate().to(BASE_URL);
        homePageOperations.logOut();
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }

    @TestCaseId(testRailCaseId = 2895)
    @Test
    private void bigTrialMDUFlow() {
        customizationPageOperations.goToBigTrial();
        customizationPageOperations.checkBigTrialPrices();
        purchaseFlowMDUUser("mdueaseenoextra@mailinator.com", false);
    }


}
