import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import enums.PaymentMethod;
import operations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PasswordUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

public class PaymentsTests extends TestsBase {
    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private PurchaseFlowsOperations purchaseFlowsOperations;
    private SummaryPageOperations summaryPageOperations;
    private WaitUtils waitUtils;
    private PasswordUtils passwordUtils;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() throws Exception {
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        purchaseFlowsOperations = new PurchaseFlowsOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        waitUtils = new WaitUtils(driver);
        passwordUtils = new PasswordUtils();
    }

    @TestCaseId(testRailCaseId = 5556)
    @Test(alwaysRun = true)
    public void test2FactorAuthentication3DS1() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.TWOFACTORTYPE1);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5557)
    @Test
    public void test2FactorAuthentication3DS2() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.TWOFACTORTYPE2);
        summaryPageOperations.assertThankYouPage();
    }

    @TestCaseId(testRailCaseId = 5565)
    @Test
    public void testCanceledPaymentStatus() throws TimeoutException {
        productsPageOperations.openEaseePurchaseFlow();
        customizationPageOperations.tickExtraCheckbox();
        purchaseFlowsOperations.purchaseFlowExistingUser("easeewithextra@mailinator.com", false, PaymentMethod.KLARNA);
        waitUtils.waitForElementToBeClickable(By.xpath("//*[contains(text(),'Tilbake')]"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('back-button__text').click();");
        waitUtils.waitForUrlToContain("/order/payment-result");
    }
}
