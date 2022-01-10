import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.Constants;
import config.DriverFactory;
import config.TestsBase;
import enums.PaymentMethod;
import models.User;
import operations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.Users;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class PurchaseFlowNewUserTest extends TestsBase {
    private HomePageOperations homePageOperations;
    private ProductsPageOperations productsPageOperations;
    private HousePageOperations housePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private SDUDiscountPartnerOperations sduDiscountPartnerOperations;
    private String phoneNumber, userName, paymentMethod;
    private Boolean extraDiscount, fourteenDaysInstallation;
    private List<User> testUsers;
    private Constants constants;


    @BeforeMethod
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        sduDiscountPartnerOperations = new SDUDiscountPartnerOperations(driver);
        testUsers = new Users().getUsersList();
        driver.navigate().to(constants.BASE_URL);
    }

    private void purchaseFlowNewUser(String phoneNumber, String username, boolean fourteenDaysInstallation, PaymentMethod paymentMethod) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.registerNewUser(phoneNumber, username, "Emobility1");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "3000", fourteenDaysInstallation);
        summaryPageOperations.pay(paymentMethod);
    }

    @AfterClass(alwaysRun = true)
    private void cleanUp() throws TimeoutException {
        driver = new DriverFactory().startBrowser();
        ckidPageOperations = new CkidPageOperations(driver);
        ckidPageOperations.deleteAccounts();
        tearDown();
    }

    @TestCaseId(testRailCaseId = 1821)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
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
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowNewUser("575437307", "newuser.easeeinstallation@mailinator.com", false, PaymentMethod.KLARNA);
    }

    @TestCaseId(testRailCaseId = 6114)
    @Test
    public void DiscountPartnerNewUserTest(){
        sduDiscountPartnerOperations.goToNafDiscountPage();
        sduDiscountPartnerOperations.clickBecomeMemberButton();
        sduDiscountPartnerOperations.sendPhoneNumber();
        sduDiscountPartnerOperations.sendRegisterForm("Name", "Test", "newuser.easeenoextra2@mailinator.com", "Emobility1","9876543210");
        sduDiscountPartnerOperations.assertThankYouPage();
    }
}


