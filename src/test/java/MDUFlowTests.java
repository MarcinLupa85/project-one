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

    private void purchaseFlowMDUUser(String username, boolean extraDiscount) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1");
        addressPageOperations.fillCondominiumName("Test Condominium");
        addressPageOperations.fillParkingPlace("23");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "72433");
        addressPageOperations.clickNext();
        if (extraDiscount) {
            assertTrue(summaryPageOperations.hasExtraDiscount());
        } else {
            assertFalse(summaryPageOperations.hasExtraDiscount());
        }
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
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

    @TestCaseId(testRailCaseId = 2888)
    @Test
    private void bigTrialMDUFlow() throws TimeoutException {
        customizationPageOperations.goToBigTrial();
        customizationPageOperations.checkBigTrialPrices();
        purchaseFlowMDUUser("mdueaseenoextra@mailinator.com", false);
    }

    @TestCaseId(testRailCaseId = 2889)
    @Test
    private void bigMDUFlow() throws TimeoutException {
        customizationPageOperations.goToBig();
        customizationPageOperations.checkBigPrices();
        purchaseFlowMDUUser("mdueaseewithextra@mailinator.com", true);
    }
}
