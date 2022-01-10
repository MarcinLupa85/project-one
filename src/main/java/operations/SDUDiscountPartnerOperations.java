package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.SDUDiscountPartnerPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static config.Constants.SMS_CODE;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.Partner.*;

public class SDUDiscountPartnerOperations {
    private WaitUtils waitUtils;
    private WebDriver driver;
    private SDUDiscountPartnerPageObject sduDiscountPartnerPageObject;
    private FormUtils formUtils;

    public SDUDiscountPartnerOperations(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        sduDiscountPartnerPageObject = new SDUDiscountPartnerPageObject(driver);
        formUtils = new FormUtils(driver);
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
        formUtils.fillField(sduDiscountPartnerPageObject.getFirstName(), firstName);
        formUtils.fillField(sduDiscountPartnerPageObject.getLastName(), lastName);
        formUtils.fillField(sduDiscountPartnerPageObject.getEmail(), mail);
        formUtils.fillField(sduDiscountPartnerPageObject.getPassword(), password);
        formUtils.fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        sduDiscountPartnerPageObject.getExtraCheckbox().click();
        sduDiscountPartnerPageObject.getRegisterButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void sendNoExtraForm(String phone, String firstName, String lastName, String mail, String membershipNumber) {
        formUtils.fillField(sduDiscountPartnerPageObject.getPhone(), phone);
        formUtils.fillField(sduDiscountPartnerPageObject.getFirstName(), firstName);
        formUtils.fillField(sduDiscountPartnerPageObject.getLastName(), lastName);
        formUtils.fillField(sduDiscountPartnerPageObject.getEmail(), mail);
        formUtils.fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void sendWithMembershipNumber(String membershipNumber) throws TimeoutException {
        waitUtils.waitForUrlToContain("/details");
        waitUtils.waitForDocumentReadyState();
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getMembershipNumber());
        formUtils.fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain(CONFIRMATION_PAGE);
    }

    public void assertThankYouPage() {
        assertThat(driver.getCurrentUrl()).contains(CONFIRMATION_PAGE);
    }

}
