import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.ClientInfo;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class MDUFlowTests extends TestsBase {
    public static final String MDUEASEENOEXTRA_MAILINATOR_COM = "mdueaseenoextra@mailinator.com";

    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
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
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
    }

    @TestCaseId(testRailCaseId = 4598)
    @Test
    private void MDULightFlow() throws TimeoutException {
        customizationPageOperations.goToMDULight();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }

    @TestCaseId(testRailCaseId = 4599)
    @Test
    private void MDUReadyFlow() throws TimeoutException {
        customizationPageOperations.goToMDUReady();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }

    /* No Leasing offer available in SF
   @TestCaseId(testRailCaseId = 4600)
   @Test
   private void MDULeasingFlow() throws TimeoutException {
       customizationPageOperations.goToMDULeasing();
       customizationPageOperations.checkMDULeasingPriceFormat();
       purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }*/

    private void purchaseFlowMDUUser(String username, boolean fourteenDaysInstallation) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity())
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2))
                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, decryptedString);
        addressPageOperations.fillParkingPlace(FakerUtils.getFakerNumber(11, 99));
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
        completePageOperations.clickBack();
    }
}
