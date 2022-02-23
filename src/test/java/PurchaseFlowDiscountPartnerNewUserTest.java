import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;

public class PurchaseFlowDiscountPartnerNewUserTest extends TestsBase {
    private CkidPageOperations ckidPageOperations;
    private SDUDiscountPartnerOperations sduDiscountPartnerOperations;
    private String decryptedString;


    @BeforeMethod
    private void initOperations() {
        ckidPageOperations = new CkidPageOperations(driver);
        sduDiscountPartnerOperations = new SDUDiscountPartnerOperations(driver);
        driver.navigate().to(BASE_URL);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

    @TestCaseId(testRailCaseId = 6114)
    @Test
    public void DiscountPartnerNewUserTest() {
        sduDiscountPartnerOperations.goToNafDiscountPage();
        sduDiscountPartnerOperations.clickBecomeMemberButton();
        sduDiscountPartnerOperations.sendPhoneNumber();
        sduDiscountPartnerOperations.sendRegisterForm("Name", "Test", "newuser.easeenoextra2@mailinator.com", decryptedString, "987654321");
        sduDiscountPartnerOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6321)
    @Test
    public void PartnerMastercardNewUserTest() throws TimeoutException {
        sduDiscountPartnerOperations.goToMastercardDiscountPage();
        sduDiscountPartnerOperations.clickLoginButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.registerNewUser("575437307", "newuser.easeenoextra3@mailinator.com", decryptedString);
        sduDiscountPartnerOperations.confirmMastercardBanner();
    }
}
