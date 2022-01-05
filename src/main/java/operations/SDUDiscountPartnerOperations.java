package operations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobjects.SDUDiscountPartnerPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

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

    public void goToObosDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/obos");
    }

    public void goToCoopDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/coop");
    }

    public void goToNafDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/naf");
    }

    public void clickLoginButton(){
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
        sduDiscountPartnerPageObject.getSmsCodeInput().sendKeys("000000");
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
        waitUtils.waitForUrlToContains("/confirmation");
    }

    public void sendNoExtraForm(String phone, String firstName, String lastName, String mail, String membershipNumber) {
        formUtils.fillField(sduDiscountPartnerPageObject.getPhone(), phone);
        formUtils.fillField(sduDiscountPartnerPageObject.getFirstName(), firstName);
        formUtils.fillField(sduDiscountPartnerPageObject.getLastName(), lastName);
        formUtils.fillField(sduDiscountPartnerPageObject.getEmail(), mail);
        formUtils.fillField(sduDiscountPartnerPageObject.getMembershipNumber(), membershipNumber);
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContains("/confirmation");
    }

    public void sendWithMembershipNumber() throws TimeoutException {
        waitUtils.waitForUrlToContains("/details");
        waitUtils.waitForDocumentReadyState();
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getMembershipNumber());
        sduDiscountPartnerPageObject.getMembershipNumber().sendKeys("9876543210");
        waitUtils.bringElementToViewport(sduDiscountPartnerPageObject.getSendButton());
        sduDiscountPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContains("/confirmation");
    }

    public void assertThankYouPage() {
        assertThat(driver.getCurrentUrl()).contains("/confirmation");
    }


}
