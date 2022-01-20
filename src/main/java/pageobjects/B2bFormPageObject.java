package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class B2bFormPageObject extends EvPage {
    public B2bFormPageObject(WebDriver driver) {
        super(driver);
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

}
