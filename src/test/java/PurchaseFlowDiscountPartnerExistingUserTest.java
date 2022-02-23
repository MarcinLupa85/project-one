import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.CkidPageOperations;
import operations.SDUDiscountPartnerOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowDiscountPartnerExistingUserTest extends TestsBase {

    private CkidPageOperations ckidPageOperations;
    private SDUDiscountPartnerOperations sduDiscountPartnerOperations;
    private PasswordUtils passwordUtils;
    private String decryptedString;


    @BeforeMethod(alwaysRun = true)
    private void initOperations() throws Exception {

        ckidPageOperations = new CkidPageOperations(driver);
        sduDiscountPartnerOperations = new SDUDiscountPartnerOperations(driver);
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
    }
    @TestCaseId(testRailCaseId = 6113)
    @Test
    public void DiscountPartnerLogInTest() throws TimeoutException {
        sduDiscountPartnerOperations.goToCoopDiscountPage();
        sduDiscountPartnerOperations.clickLoginButton();
        ckidPageOperations.provideLoginCredentials("easeewithextra@mailinator.com", decryptedString);
        ckidPageOperations.clickLogInButton();
        sduDiscountPartnerOperations.sendWithMembershipNumber("9876543210");
        sduDiscountPartnerOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6115)
    @Test
    public void DiscountPartnerNoExtraTest() {
        sduDiscountPartnerOperations.goToObosDiscountPage();
        sduDiscountPartnerOperations.clickNoExtraLink();
        sduDiscountPartnerOperations.sendNoExtraForm("575437005", "Test", "Kowalski", "easeenoextra@mailinator.com", "9876543");
        sduDiscountPartnerOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6256)
    @Test
    public void DiscountPartnerMastercardTest() throws TimeoutException {
        sduDiscountPartnerOperations.goToMastercardDiscountPage();
        sduDiscountPartnerOperations.clickLoginButton();
        ckidPageOperations.provideLoginCredentials("easeenoextra@mailinator.com", decryptedString);
        ckidPageOperations.clickLogInButton();
        sduDiscountPartnerOperations.confirmMastercardBanner();
    }
}
