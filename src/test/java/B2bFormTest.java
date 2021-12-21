import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.B2bFormOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class B2bFormTest extends TestsBase {
    private B2bFormOperations b2bFormOperations;

    @BeforeMethod(alwaysRun = true)
    private void initOperations(){
        b2bFormOperations = new B2bFormOperations(driver);
    }

    @TestCaseId(testRailCaseId = 6095)
    @Test
    public void sendB2bForm() throws TimeoutException {
        b2bFormOperations.goToB2bForm();
        b2bFormOperations.chooseNumberOfChargers();
        b2bFormOperations.agreeToReimbursement();
        b2bFormOperations.fillCompanyForm("Company Name", "1234", "Company Address", "3000", "Compamy City", "Invoice Address", "3000", "Invoice City", "Buyer Name", "b2bformtest@mailinator.com", "93212312", "b2bformtest@mailinator.com", "1234");
        b2bFormOperations.chooseColorOfCharger();
        b2bFormOperations.disagreeToInstallation();
        b2bFormOperations.chooseFileFormat();
        b2bFormOperations.fillChargerFrom("Name", "Address", "3001", "City", "b2bformtestreceipient@mailinator.com", "93212311");
        b2bFormOperations.sendForm();
    }
}
