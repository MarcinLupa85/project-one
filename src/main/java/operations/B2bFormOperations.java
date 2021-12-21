package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.B2bFormPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class B2bFormOperations {
    private B2bFormPageObject b2bFormPageObject;
    private FormUtils formUtils;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public B2bFormOperations(WebDriver driver) {
        b2bFormPageObject = new B2bFormPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils =  new FormUtils(driver);
        this.driver = driver;
    }

    public void goToB2bForm() throws TimeoutException {
        driver.navigate().to(BASE_URL + "/hjemmelading/for-ansatte/bestillingsskjema-hjemmelader/customize-order");
        waitUtils.waitForDocumentReadyState();
    }

    public void chooseNumberOfChargers(){
        Select dropdown = new Select(b2bFormPageObject.getChargerAmountDropdown());
        dropdown.selectByIndex(1);
    }

    public void agreeToReimbursement(){
        b2bFormPageObject.getReimbursementAgreementRadioButton().click();
    }

    public void fillCompanyForm(String companyName, String organisationNumber, String companyAddress, String companyZipCode, String companyCity, String invoiceAddress, String invoiceZipCode, String invoiceCity, String buyerName, String buyerEmail, String buyerPhone, String buyerInvoiceEmail, String referenceNumber){
        formUtils.fillField(b2bFormPageObject.getCompanyName(), companyName);
        formUtils.fillField(b2bFormPageObject.getOrganisationNumber(), organisationNumber);
        formUtils.fillField(b2bFormPageObject.getCompanyAddress(), companyAddress);
        formUtils.fillField(b2bFormPageObject.getCompanyZipCode(), companyZipCode);
        formUtils.fillField(b2bFormPageObject.getCompanyCity(), companyCity);
        formUtils.fillField(b2bFormPageObject.getInvoiceAddress(), invoiceAddress);
        formUtils.fillField(b2bFormPageObject.getInvoiceZipCode(), invoiceZipCode);
        formUtils.fillField(b2bFormPageObject.getInvoiceCity(), invoiceCity);
        formUtils.fillField(b2bFormPageObject.getBuyerName(), buyerName);
        formUtils.fillField(b2bFormPageObject.getBuyerEmail(), buyerEmail);
        formUtils.fillField(b2bFormPageObject.getBuyerPhone(), buyerPhone);
        formUtils.fillField(b2bFormPageObject.getBuyerInvoiceEmail(), buyerInvoiceEmail);
        formUtils.fillField(b2bFormPageObject.getReferenceNumber(), referenceNumber);
    }

    public void chooseColorOfCharger(){
        Select dropdown = new Select(b2bFormPageObject.getChargerColorDropdown());
        dropdown.selectByIndex(2);
    }

    public void disagreeToInstallation(){
        b2bFormPageObject.getInstallationNoRadio().click();
    }

    public void chooseFileFormat(){
        b2bFormPageObject.getPdfRadio().click();
    }

    public void fillChargerFrom(String name, String address, String zipCode, String city, String email, String phone){
        formUtils.fillField(b2bFormPageObject.getName(), name);
        formUtils.fillField(b2bFormPageObject.getAddress(), address);
        formUtils.fillField(b2bFormPageObject.getZipCode(), zipCode);
        formUtils.fillField(b2bFormPageObject.getCity(), city);
        formUtils.fillField(b2bFormPageObject.getEmail(), email);
        formUtils.fillField(b2bFormPageObject.getPhone(), phone);
    }

    public void sendForm() throws TimeoutException {
        b2bFormPageObject.getSubmitButton().click();
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.getCurrentUrl()).contains("/for-ansatte/bestillingsskjema-hjemmelader/complete");
    }
}
