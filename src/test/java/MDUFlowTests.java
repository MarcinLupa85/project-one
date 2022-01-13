import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

public class MDUFlowTests extends TestsBase {
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private HomePageOperations homePageOperations;
    private WaitUtils waitUtils;
    private PasswordUtils passwordUtils;
    private String decryptedString;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        homePageOperations = new HomePageOperations(driver);
        waitUtils = new WaitUtils(driver);
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
    }

    @TestCaseId(testRailCaseId = 4598)
    @Test
    private void MDULightFlow() throws TimeoutException {
        customizationPageOperations.goToMDULight();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowMDUUser("mdueaseenoextra@mailinator.com", false);
    }

    @TestCaseId(testRailCaseId = 4599)
    @Test
    private void MDUReadyFlow() throws TimeoutException {
        customizationPageOperations.goToMDUReady();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowMDUUser("mdueaseenoextra@mailinator.com", false);
    }

    /* No Leasing offer available in SF
   @TestCaseId(testRailCaseId = 4600)
   @Test
   private void MDULeasingFlow() throws TimeoutException {
       customizationPageOperations.goToMDULeasing();
       customizationPageOperations.checkMDULeasingPriceFormat();
       purchaseFlowMDUUser("mdueaseenoextra@mailinator.com", false);
    }*/

    private void purchaseFlowMDUUser(String username, boolean fourteenDaysInstallation) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, decryptedString);
        addressPageOperations.fillParkingPlace("23");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "3000", fourteenDaysInstallation);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
        completePageOperations.clickBack();
    }
}
