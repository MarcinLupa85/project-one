package operations;

import enums.PaymentMethod;
import org.openqa.selenium.WebDriver;
import testdata.ClientInfo;
import testdata.SduPurchaseData;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowsOperations extends BaseOperations{

    private ProductsPageOperations productsPageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private PasswordUtils passwordUtils;
    private String decryptedString;

    public PurchaseFlowsOperations(WebDriver driver) throws Exception {
        super(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        passwordUtils = new PasswordUtils();
        decryptedString = passwordUtils.decryptEvPassword();
    }

    public void purchaseFlowExistingUser(String username, boolean fourteenDaysInstallation, PaymentMethod paymentMethod) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(3))
                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.provideLoginCredentials(username, decryptedString);
        ckidPageOperations.clickLogInButton();
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(paymentMethod);
    }

    public void purchaseFlowExistingUtilityUser(String username) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2));

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.provideLoginCredentials(username, decryptedString);
        ckidPageOperations.clickLogInButton();
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
    }

    public void purchaseFlowSDUUser(SduPurchaseData sduPurchaseData) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2))
                .withFourteenDaysInstallation(sduPurchaseData.isFourteenDaysInstallation());

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.provideLoginCredentials(sduPurchaseData.getEmail(), decryptedString);
        ckidPageOperations.clickLogInButton();
        if (sduPurchaseData.isMembershipNumberNecessary()) {
            customizationPageOperations.fillMembershipNumber(sduPurchaseData.getMembershipNumber());
        }
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(sduPurchaseData.getPaymentMethod());
    }

    public void purchaseFlowMDUUser(String username, boolean fourteenDaysInstallation) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2))
                .withFourteenDaysInstallation(fourteenDaysInstallation);

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.provideLoginCredentials(username, decryptedString);
        ckidPageOperations.clickLogInButton();
        addressPageOperations.fillParkingPlace(FakerUtils.getFakerNumber(11, 99));
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
        completePageOperations.clickBack();
    }
}
