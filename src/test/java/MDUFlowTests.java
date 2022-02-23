import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class MDUFlowTests extends TestsBase {
    public static final String MDUEASEENOEXTRA_MAILINATOR_COM = "mdueaseenoextra@mailinator.com";
    public static final String COMPANY_NAME = "osp";

    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private HousingOperations housingOperations;
    private String decryptedString;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        housingOperations = new HousingOperations(driver);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

    @TestCaseId(testRailCaseId = 4598)
    @Test
    public void MDULightFlow() throws TimeoutException {
        customizationPageOperations.goToMDULight();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowsOperations.purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }

    @TestCaseId(testRailCaseId = 4599)
    @Test
    public void MDUReadyFlow() throws TimeoutException {
        customizationPageOperations.goToMDUReady();
        customizationPageOperations.checkPriceFormat();
        purchaseFlowsOperations.purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }

    //TODO No Leasing offer available in SF
   /*@TestCaseId(testRailCaseId = 4600)
   @Test
   private void MDULeasingFlow() throws TimeoutException {
       customizationPageOperations.goToMDULeasing();
       customizationPageOperations.checkMDULeasingPriceFormat();
       purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }*/

    @TestCaseId(testRailCaseId = 6179)
    @Test
    public void HousingCompanyTest() throws TimeoutException {
        housingOperations.goToHousingCompanyPage();
        housingOperations.inputHousingCompanyName(COMPANY_NAME);
        housingOperations.clickSearchButton();
        housingOperations.clickBuyButton();
        purchaseFlowsOperations.purchaseFlowMDUUser(MDUEASEENOEXTRA_MAILINATOR_COM, false);
    }
}
