import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.ClientInfo;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class UtilityBundleTests extends TestsBase {
    public static final String UTILITYWITHEXTRA_MAILINATOR_COM = "easeewithutility@mailinator.com";

    private CustomizationPageOperations customizationPageOperations;
    private ProductsPageOperations productsPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private String decryptedString;

    @BeforeMethod
    private void initOperations() {
        customizationPageOperations = new CustomizationPageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

        @TestCaseId(testRailCaseId = 5864)
        @Test
        public void utilityPurchaseFlow() throws TimeoutException {
            productsPageOperations.openEaseePurchaseFlow();
            customizationPageOperations.tickUtilityCheckbox();
            purchaseFlowExistingUtilityUser(UTILITYWITHEXTRA_MAILINATOR_COM);
            summaryPageOperations.assertNextStepPage();
        }



    private void purchaseFlowExistingUtilityUser(String username) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2));
//                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.provideLoginCredentials(username, decryptedString);
        ckidPageOperations.clickLogInButton();
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
    }
}
