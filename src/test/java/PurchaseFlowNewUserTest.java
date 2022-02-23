import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PaymentMethod;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.ClientInfo;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;

public class PurchaseFlowNewUserTest extends TestsBase {
    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private String decryptedString;


    @BeforeMethod
    private void initOperations() {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        driver.navigate().to(BASE_URL);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

    private void purchaseFlowNewUser(String phoneNumber, String username, boolean fourteenDaysInstallation, PaymentMethod paymentMethod) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(3))
                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.registerNewUser(phoneNumber, username, decryptedString);
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(paymentMethod);
    }

    @TestCaseId(testRailCaseId = 1821)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowNewUser("575437397", "newuser.easeewithextra@mailinator.com", false, PaymentMethod.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 2507)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowNewUser("575437666", "newuser.easeenoextra@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 5049)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowNewUser("575437306", "newuser.cablenoextra@mailinator.com", false, PaymentMethod.INVOICE);
    }

    @TestCaseId(testRailCaseId = 2512)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowNewUser("575437307", "newuser.easeeinstallation@mailinator.com", false, PaymentMethod.KLARNA);
    }
}
