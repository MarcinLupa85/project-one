package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.SDUDiscountPartnerPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static config.Constants.SMS_CODE;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.Partner.*;

public class SDUDiscountPartnerOperations extends BaseOperations {
    private WaitUtils waitUtils;
    private WebDriver driver;
    private SDUDiscountPartnerPageObject sduDiscountPartnerPageObject;

    public SDUDiscountPartnerOperations(WebDriver driver) {
        super(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        sduDiscountPartnerPageObject = new SDUDiscountPartnerPageObject(driver);
    }

    public void goToObosDiscountPage() {
        driver.navigate().to(BASE_URL + OBOS_DISCOUNT_PAGE);
    }

    public void goToCoopDiscountPage() {
        driver.navigate().to(BASE_URL + COOP_DISCOUNT_PAGE);
    }

    public void goToNafDiscountPage() {
        driver.navigate().to(BASE_URL + NAF_DISCOUNT_PAGE);
    }

    public void clickLoginButton() {
        sduDiscountPartnerPageObject.getLogInButton().click();
    }

    public void clickBecomeMemberButton() {
        sduDiscountPartnerPageObject.getBecomeMemberButton().click();
    }

    public void clickNoExtraLink() {
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getNoExtraLink());
        sduDiscountPartnerPageObject.getNoExtraLink().click();
    }

    public void sendPhoneNumber() {
        sduDiscountPartnerPageObject.getPhone().sendKeys("94564565");
        sduDiscountPartnerPageObject.getSendCode().click();
        waitUtils.waitForElement(sduDiscountPartnerPageObject.getSmsCodeInput());
        sduDiscountPartnerPageObject.getSmsCodeInput().sendKeys(SMS_CODE);
        sduDiscountPartnerPageObject.getConfirmButton().click();
    }

    public void sendRegisterForm(String firstName, String lastName, String mail, String password, String membershipNumber) {
        fillField(sduDiscountPartnerPageObject.getFirstName(), firstName);
        fillField(sduDiscountPartnerPageObject.getLastName(), lastName);
        fillField(sduDiscountPartnerPageObject.getEmail(), mail);
        fillField(sduDiscountPartnerPageObject.getPassword(), password);
        fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        sduDiscountPartnerPageObject.getExtraCheckbox().click();
        sduDiscountPartnerPageObject.getRegisterButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void sendNoExtraForm(String phone, String firstName, String lastName, String mail, String membershipNumber) {
        fillField(sduDiscountPartnerPageObject.getPhone(), phone);
        fillField(sduDiscountPartnerPageObject.getFirstName(), firstName);
        fillField(sduDiscountPartnerPageObject.getLastName(), lastName);
        fillField(sduDiscountPartnerPageObject.getEmail(), mail);
        fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void sendWithMembershipNumber(String membershipNumber) throws TimeoutException {
        waitUtils.waitForUrlToContain("/details");
        waitUtils.waitForDocumentReadyState();
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getMembershipNumber());
        waitUtils.waitForElementToBeClickable(sduDiscountPartnerPageObject.getMembershipNumber());
        fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void assertThankYouPage() {
        assertThat(driver.getCurrentUrl()).contains(CONFIRMATION_PAGE);
    }

}
