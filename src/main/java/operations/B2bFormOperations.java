package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.B2bFormPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.B2B_FORM_PAGE;

public class B2bFormOperations extends BaseOperations {
    private B2bFormPageObject b2bFormPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public B2bFormOperations(WebDriver driver) {
        super(driver);
        b2bFormPageObject = new B2bFormPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void goToB2bForm() throws TimeoutException {
        driver.navigate().to(BASE_URL + B2B_FORM_PAGE);
        waitUtils.waitForDocumentReadyState();
    }

    public void chooseNumberOfChargers() {
        Select dropdown = new Select(b2bFormPageObject.getChargerAmountDropdown());
        dropdown.selectByIndex(1);
    }

    public void agreeToReimbursement() {
        b2bFormPageObject.getReimbursementAgreementRadioButton().click();
    }

    public void fillCompanyForm(String companyName, String organisationNumber, String companyAddress, String companyZipCode, String companyCity, String invoiceAddress, String invoiceZipCode, String invoiceCity, String buyerName, String buyerEmail, String buyerPhone, String buyerInvoiceEmail, String referenceNumber) {
        fillField(b2bFormPageObject.getCompanyName(), companyName);
        fillField(b2bFormPageObject.getOrganisationNumber(), organisationNumber);
        fillField(b2bFormPageObject.getCompanyAddress(), companyAddress);
        fillField(b2bFormPageObject.getCompanyZipCode(), companyZipCode);
        fillField(b2bFormPageObject.getCompanyCity(), companyCity);
        fillField(b2bFormPageObject.getInvoiceAddress(), invoiceAddress);
        fillField(b2bFormPageObject.getInvoiceZipCode(), invoiceZipCode);
        fillField(b2bFormPageObject.getInvoiceCity(), invoiceCity);
        fillField(b2bFormPageObject.getBuyerName(), buyerName);
        fillField(b2bFormPageObject.getBuyerEmail(), buyerEmail);
        fillField(b2bFormPageObject.getBuyerPhone(), buyerPhone);
        fillField(b2bFormPageObject.getBuyerInvoiceEmail(), buyerInvoiceEmail);
        fillField(b2bFormPageObject.getReferenceNumber(), referenceNumber);
    }

    public void chooseColorOfCharger() {
        Select dropdown = new Select(b2bFormPageObject.getChargerColorDropdown());
        waitUtils.waitForElementToBeClickable(b2bFormPageObject.getChargerColorDropdown());
        dropdown.selectByIndex(2);
    }

    public void disagreeToInstallation() {
        b2bFormPageObject.getInstallationNoRadio().click();
    }

    public void chooseFileFormat() {
        b2bFormPageObject.getPdfRadio().click();
    }

    public void fillChargerFrom(String name, String address, String zipCode, String city, String email, String phone) {
        fillField(b2bFormPageObject.getName(), name);
        fillField(b2bFormPageObject.getAddress(), address);
        fillField(b2bFormPageObject.getZipCode(), zipCode);
        fillField(b2bFormPageObject.getCity(), city);
        fillField(b2bFormPageObject.getEmail(), email);
        fillField(b2bFormPageObject.getPhone(), phone);
    }

    public void sendForm() throws TimeoutException {
        b2bFormPageObject.getSubmitButton().click();
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl()).contains("/for-ansatte/bestillingsskjema-hjemmelader/complete");
    }
}
