package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B2bFormPageObject {
    public B2bFormPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "charger-count")
    private WebElement chargerAmountDropdown;

    @FindBy(css = "label[for='employee-reimbursement-yes']")
    private WebElement reimbursementAgreementRadioButton;

    @FindBy(id = "company-name")
    private WebElement companyName;

    @FindBy(id = "organisation-number")
    private WebElement organisationNumber;

    @FindBy(id = "company-address")
    private WebElement companyAddress;

    @FindBy(id = "company-zip-code")
    private WebElement companyZipCode;

    @FindBy(id = "company-city")
    private WebElement companyCity;

    @FindBy(id = "invoice-address")
    private WebElement invoiceAddress;

    @FindBy(id = "invoice-zip-code")
    private WebElement invoiceZipCode;

    @FindBy(id = "invoice-city")
    private WebElement invoiceCity;

    @FindBy(id = "name")
    private WebElement buyerName;

    @FindBy(id = "email")
    private WebElement buyerEmail;

    @FindBy(id = "phone-number")
    private WebElement buyerPhone;

    @FindBy(id = "invoice-email")
    private WebElement buyerInvoiceEmail;

    @FindBy(id = "po-number")
    private WebElement referenceNumber;

    @FindBy(css = "label[for ='invoice-delivery-pdf']")
    private WebElement pdfRadio;

    @FindBy(id = "color-1")
    private WebElement chargerColorDropdown;

    @FindBy(css = "label[for = 'installation-no-1']")
    private WebElement installationNoRadio;

    @FindBy(id = "name-1")
    private WebElement name;

    @FindBy(id = "address-1")
    private WebElement address;

    @FindBy(id = "zip-code-1")
    private WebElement zipCode;

    @FindBy(id = "city-1")
    private WebElement city;

    @FindBy(id = "email-1")
    private WebElement email;

    @FindBy(id = "phone-number-1")
    private WebElement phone;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public WebElement getChargerAmountDropdown() {
        return chargerAmountDropdown;
    }

    public WebElement getReimbursementAgreementRadioButton() {
        return reimbursementAgreementRadioButton;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getOrganisationNumber() {
        return organisationNumber;
    }

    public WebElement getCompanyAddress() {
        return companyAddress;
    }

    public WebElement getCompanyZipCode() {
        return companyZipCode;
    }

    public WebElement getCompanyCity() {
        return companyCity;
    }

    public WebElement getInvoiceAddress() {
        return invoiceAddress;
    }

    public WebElement getInvoiceZipCode() {
        return invoiceZipCode;
    }

    public WebElement getInvoiceCity() {
        return invoiceCity;
    }

    public WebElement getBuyerName() {
        return buyerName;
    }

    public WebElement getBuyerEmail() {
        return buyerEmail;
    }

    public WebElement getBuyerPhone() {
        return buyerPhone;
    }

    public WebElement getBuyerInvoiceEmail() {
        return buyerInvoiceEmail;
    }

    public WebElement getReferenceNumber() {
        return referenceNumber;
    }

    public WebElement getPdfRadio() {
        return pdfRadio;
    }

    public WebElement getChargerColorDropdown() {
        return chargerColorDropdown;
    }

    public WebElement getInstallationNoRadio() {
        return installationNoRadio;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
