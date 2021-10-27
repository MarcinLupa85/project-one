import config.TestsBase;
import operations.CustomizationPageOperations;
import operations.SalesRepOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class SalesRepTests extends TestsBase {
    SalesRepOperations salesRepOperations;
    CustomizationPageOperations customizationPageOperations;

    @BeforeMethod
    private void initOperations() {
        salesRepOperations = new SalesRepOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
    }

    @Test
    public void  salesRepFlowTest() throws TimeoutException {
        salesRepOperations.goToSalesRepPage();
        salesRepOperations.chooseRepName();
        salesRepOperations.sendRepMail();
        salesRepOperations.verifyRep();
        salesRepOperations.goToForm();
        salesRepOperations.addCharger();
        salesRepOperations.clickSubmitButton();
        salesRepOperations.fillForm();
        salesRepOperations.clickCheckbox();
        salesRepOperations.completeOrder();
    }
}
