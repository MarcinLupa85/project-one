import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PAYMENTMETHODS;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class PurchaseFlowExistingUserTest extends TestsBase {

    private HomePageOperations homePageOperations;
    private ProductsPageOperations productsPageOperations;
    private HousePageOperations housePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private NavbarOperations navbarOperations;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
    }

    private void purchaseFlowExistingUser(String username, boolean fourteenDaysInstallation, PAYMENTMETHODS paymentMethod) throws TimeoutException {
        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.logInWithCredentials(username, "Emobility1!@");
        addressPageOperations.fillClientInfo("Test Addresse 582", "Test Billing City", "3000", fourteenDaysInstallation);
        summaryPageOperations.pay(paymentMethod);
    }

    @TestCaseId(testRailCaseId = 2872)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2873)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        purchaseFlowExistingUser("easeenoextra@mailinator.com",  false, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 2876)
    @Test(alwaysRun = true)
    public void testCablePurchaseFlowWithNoExtra() throws TimeoutException {
        productsPageOperations.openCablePurchaseFlow();
        purchaseFlowExistingUser("cablenoextra@mailinator.com",false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 2879)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationOnly() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 5490)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlowWithInstallationAsProduct() throws TimeoutException {
        productsPageOperations.openInstallationPurchaseFlow();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 2877)
    @Test(alwaysRun = true)
    public void testEaseePurchaseFlow14DaysInstallation() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithInstallationOnly();
        purchaseFlowExistingUser("easee14daysinstallation@mailinator.com",true, PAYMENTMETHODS.MASTERCARD);
    }

    @TestCaseId(testRailCaseId = 4064)
    @Test(alwaysRun = true)
    public void testEqualizerNoExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeenoextra@mailinator.com",false, PAYMENTMETHODS.KLARNA);
    }

    @TestCaseId(testRailCaseId = 4065)
    @Test(alwaysRun = true)
    public void testEqualizerWithExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeewithextra@mailinator.com",false, PAYMENTMETHODS.INVOICE);
    }

    @TestCaseId(testRailCaseId = 4066)
    @Test(alwaysRun = true)
    public void testEqualizerWithoutExtra() throws TimeoutException {
        productsPageOperations.openEqualizerPurchaseFlow();
        homePageOperations.flowWithEqualizer();
        purchaseFlowExistingUser("easeeinstallation@mailinator.com",false, PAYMENTMETHODS.VISA);
    }

    @TestCaseId(testRailCaseId = 5558)
    @Test(alwaysRun = true)
    public void test2FactorAuthentication3DS1() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.TWOFACTORTYPE1);
    }

    @TestCaseId(testRailCaseId = 5559)
    @Test
    public void test2FactorAuthentication3DS2() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        homePageOperations.flowWithExtra();
        purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PAYMENTMETHODS.TWOFACTORTYPE2);
    }
}
