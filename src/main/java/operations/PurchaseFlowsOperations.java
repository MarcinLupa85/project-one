package operations;

import org.openqa.selenium.WebDriver;
import testdata.ClientInfo;
import testdata.PurchaseData;
import utils.FakerUtils;
import utils.PasswordUtils;

import java.util.concurrent.TimeoutException;

public class PurchaseFlowsOperations extends BaseOperations {

    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;
    private CompletePageOperations completePageOperations;
    private String decryptedString;

    public PurchaseFlowsOperations(WebDriver driver) {
        super(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
        decryptedString = PasswordUtils.decryptEvPassword();
    }

    public void purchaseFlowExistingUser(PurchaseData defaultPurchaseData) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(3))
                .withFourteenDaysInstallation(defaultPurchaseData.isFourteenDaysInstallation());

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.logIn(defaultPurchaseData.getEmail(), decryptedString);
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(defaultPurchaseData.getPaymentMethod());
    }

    public void purchaseFlowExistingUtilityUser(String username) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2));

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.logIn(username, decryptedString);
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
    }

    public void purchaseFlowSDUUser(PurchaseData sduPurchaseData) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(2))
                .withFourteenDaysInstallation(sduPurchaseData.isFourteenDaysInstallation());

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.logIn(sduPurchaseData.getEmail(), decryptedString);
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
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.logIn(username, decryptedString);
        addressPageOperations.fillParkingPlace(FakerUtils.getFakerNumber(11, 99));
        addressPageOperations.fillClientInfo(clientInfo);
        addressPageOperations.clickNext();
        summaryPageOperations.tickTermsAndConditionsCheckbox();
        summaryPageOperations.clickFinish();
        completePageOperations.clickBack();
    }

    public void purchaseFlowNewUser(PurchaseData newUserPurchaseData) throws TimeoutException {
        ClientInfo clientInfo = new ClientInfo()
                .withAddress(FakerUtils.getFakerStreetAddress())
                .withCity(FakerUtils.getFakerCity(false))
                .withZipcode(FakerUtils.getFakerZipCode())
                .withComment(FakerUtils.getFakerDescription(3))
                .withFourteenDaysInstallation(newUserPurchaseData.isFourteenDaysInstallation());

        customizationPageOperations.clickSubmitButton();
        ckidPageOperations.closeCookieBot();
        ckidPageOperations.registerNewUser(newUserPurchaseData.getPhone(), newUserPurchaseData.getEmail(), decryptedString);
        addressPageOperations.fillClientInfo(clientInfo);
        summaryPageOperations.pay(newUserPurchaseData.getPaymentMethod());
    }
}
