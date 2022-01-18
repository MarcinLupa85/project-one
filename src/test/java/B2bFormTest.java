import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.B2bFormOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerUtils;

import java.util.concurrent.TimeoutException;

public class B2bFormTest extends TestsBase {
    private static final String B_2_BFORMTEST_MAILINATOR_COM = "b2bformtest@mailinator.com";
    private static final String B_2_BFORMTESTRECEIPIENT_MAILINATOR_COM = "b2bformtestreceipient@mailinator.com";
    private B2bFormOperations b2bFormOperations;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        b2bFormOperations = new B2bFormOperations(driver);
    }

    @TestCaseId(testRailCaseId = 5850)
    @Test
    public void sendB2bForm() throws TimeoutException {
        b2bFormOperations.goToB2bForm();
        b2bFormOperations.chooseNumberOfChargers();
        b2bFormOperations.agreeToReimbursement();
        b2bFormOperations.fillCompanyForm(
                FakerUtils.getFakerCompany(),
                FakerUtils.getFakerNumber(1200, 1299),
                FakerUtils.getFakerStreetAddress(),
                FakerUtils.getFakerZipCode(),
                FakerUtils.getFakerCity(false),
                FakerUtils.getFakerStreetAddress(),
                FakerUtils.getFakerZipCode(),
                FakerUtils.getFakerCity(true),
                FakerUtils.getFakerFullName(),
                B_2_BFORMTEST_MAILINATOR_COM,
                FakerUtils.getFakerPhone(),
                B_2_BFORMTEST_MAILINATOR_COM,
                FakerUtils.getFakerNumber(1200, 1299));
        b2bFormOperations.chooseColorOfCharger();
        b2bFormOperations.disagreeToInstallation();
        b2bFormOperations.chooseFileFormat();
        b2bFormOperations.fillChargerFrom(
                FakerUtils.getFakerLastName(),
                FakerUtils.getFakerStreetAddress(),
                FakerUtils.getFakerZipCode(),
                FakerUtils.getFakerCity(false),
                B_2_BFORMTESTRECEIPIENT_MAILINATOR_COM,
                FakerUtils.getFakerProject());
        b2bFormOperations.sendForm();
    }
}
