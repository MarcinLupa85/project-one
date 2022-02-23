import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class UtilityBundleTests extends TestsBase {
    public static final String UTILITYWITHEXTRA_MAILINATOR_COM = "easeewithutility@mailinator.com";

    private CustomizationPageOperations customizationPageOperations;
    private ProductsPageOperations productsPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;
    private String decryptedString;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

        @TestCaseId(testRailCaseId = 5864)
        @Test
        public void utilityPurchaseFlow() throws TimeoutException {
            productsPageOperations.openEaseePurchaseFlow();
            customizationPageOperations.tickUtilityCheckbox();
            purchaseFlowsOperations.purchaseFlowExistingUtilityUser(UTILITYWITHEXTRA_MAILINATOR_COM);
            summaryPageOperations.assertNextStepPage();
        }
}
