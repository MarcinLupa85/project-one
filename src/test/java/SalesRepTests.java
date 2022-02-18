import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.SalesRepOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class SalesRepTests extends TestsBase {
    SalesRepOperations salesRepOperations;

    @BeforeMethod
    private void initOperations() {
        salesRepOperations = new SalesRepOperations(driver);
    }

    @TestCaseId(testRailCaseId = 5535)
    @Test
    public void salesRepFlowTest() throws TimeoutException {
        salesRepOperations.goToSalesRepPage();
        salesRepOperations.chooseRepName();
        salesRepOperations.sendRepMail();
        salesRepOperations.verifyRep();
        salesRepOperations.goToForm();
        salesRepOperations.addCharger();
        salesRepOperations.clickSubmitButton();
        salesRepOperations.fillForm();
        salesRepOperations.clickTCCheckbox();
        salesRepOperations.completeOrder();
    }

    @TestCaseId(testRailCaseId = 6482)
    @Test
    public void salesRepFlowTestWithInstallation() throws TimeoutException {
        salesRepOperations.goToSalesRepPage();
        salesRepOperations.chooseRepName();
        salesRepOperations.sendRepMail();
        salesRepOperations.verifyRep();
        salesRepOperations.goToForm();
        salesRepOperations.addCharger();
        salesRepOperations.tickInstallationCheckbox();
        salesRepOperations.clickSubmitButton();
        salesRepOperations.fillForm();
        salesRepOperations.clickTCCheckbox();
        salesRepOperations.completeOrder();
    }
}
