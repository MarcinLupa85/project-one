import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static testdata.EvUsers.*;

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
        sduDiscountPartnerOperations.sendRegisterForm(
                FakerUtils.getFakerFirstName(),
                FakerUtils.getFakerLastName(),
                NEW_EASEE_NO_EXTRA2,
                decryptedString,
                FakerUtils.getFakerNumber(100000000, 999999999));
        sduDiscountPartnerOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6321)
    @Test
    public void PartnerMastercardNewUserTest() throws TimeoutException {
        sduDiscountPartnerOperations.goToMastercardDiscountPage();
        sduDiscountPartnerOperations.clickLoginButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.registerNewUser(
                "94564566",
                NEW_EASEE_NO_EXTRA3,
                decryptedString);
        sduDiscountPartnerOperations.confirmMastercardBanner();
    }
}
