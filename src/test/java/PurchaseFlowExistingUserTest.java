import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PaymentMethod;
import operations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.ClientInfo;
import utils.FakerUtils;
import utils.PasswordUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private SDUDiscountPartnerOperations sduDiscountPartnerOperations;
    private WaitUtils waitUtils;
    private PasswordUtils passwordUtils;
    private String decryptedString;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() throws Exception {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        sduDiscountPartnerOperations = new SDUDiscountPartnerOperations(driver);
        waitUtils = new WaitUtils(driver);
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
    }

    @TestCaseId(testRailCaseId = 2506)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 1225)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, PaymentMethod.MASTERCARD);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 4775)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 2514)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 5488)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationAsProduct() throws TimeoutException {
        productsPageOperations.openInstallationPurchaseFlow();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.INVOICE);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5052)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickInstallationCheckbox();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com", true, PaymentMethod.MASTERCARD);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6099)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowExistingUser("easeenoextra@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 4061)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.INVOICE);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 6098)
    @Test(alwaysRun = true)
    public void testEqualizerWithoutExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        customizationPageOperations.addEqualizer();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com", false, PaymentMethod.VISA);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5556)
    @Test(alwaysRun = true)
    public void test2FactorAuthentication3DS1() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.TWOFACTORTYPE1);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5557)
    @Test
    public void test2FactorAuthentication3DS2() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.TWOFACTORTYPE2);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5565)
    @Test
    public void testCanceledPaymentStatus() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.KLARNA);
        waitUtils.waitForElementToBeClickable(By.xpath("//*[contains(text(),'Tilbake')]"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('back-button__text').click();");
        waitUtils.waitForUrlToContain("/order/payment-result");
    }

    @TestCaseId(testRailCaseId = 6113)
    @Test
    public void DiscountPartnerLogInTest() throws TimeoutException {
        sduDiscountPartnerOperations.goToCoopDiscountPage();
        sduDiscountPartnerOperations.clickLoginButton();
        ckidPageOperations.logInWithCredentials("easeewithextra@mailinator.com", decryptedString);
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

    private void purchaseFlowExistingUser(String username, boolean fourteenDaysInstallation, PaymentMethod paymentMethod) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(3))
                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, decryptedString);
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(paymentMethod);
    }
}
