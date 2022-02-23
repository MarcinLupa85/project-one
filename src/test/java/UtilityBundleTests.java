import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.ProductsPageOperations;
import operations.PurchaseFlowsOperations;
import operations.SummaryPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

import static testdata.EvUsers.UTILITYWITHEXTRA_MAILINATOR_COM;

public class UtilityBundleTests extends TestsBase {

    private CustomizationPageOperations customizationPageOperations;
    private ProductsPageOperations productsPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;

    @BeforeMethod
    private void initOperations() throws Exception {
        customizationPageOperations = new CustomizationPageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
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
