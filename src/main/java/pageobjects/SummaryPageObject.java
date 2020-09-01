package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPageObject {

    public SummaryPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.custom-radio")
    private WebElement tcCheckbox;

    @FindBy(css = "button[type=submit]")
    private WebElement finishOrderButton;

    @FindBy(xpath = ".//label[contains(@for, 'accept14DaysInstall')]")
    private WebElement fourteenDaysCheckbox;

    @FindBy(css = "div.list-group.list-group-sm.list-group-pills > button:nth-child(1)")
    private WebElement creditCardOption;

    @FindBy(css = "button:nth-child(1)")
    private WebElement invoiceOption;

    @FindBy(id = "encryptedCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "encryptedExpiryDate")
    private WebElement expiryDate;

    @FindBy(id = "encryptedSecurityCode")
    private WebElement securityCode;

    @FindBy(css = "button[class='adyen-checkout__button adyen-checkout__button--pay']")
    private WebElement creditCardPayButton;

    @FindBy(css = "[class='adyen-checkout__payment-method__name']")
    private WebElement klarnaPaymentOption;

    @FindBy(css = "button[class='adyen-checkout__button adyen-checkout__button--standalone adyen-checkout__button--pay']")
    private WebElement klarnaPayButton;

    public WebElement getFinishOrderButton() { return finishOrderButton; }

    public WebElement getTcCheckbox() { return tcCheckbox; }

    public WebElement getFourteenDaysCheckbox() { return fourteenDaysCheckbox; }

    public WebElement getCreditCardOption() { return creditCardOption; }

    public WebElement getInvoiceOption() { return invoiceOption; }

    public WebElement getCreditCardNumber() { return creditCardNumber; }

    public WebElement getExpiryDate() { return expiryDate; }

    public WebElement getSecurityCode() { return securityCode; }

    public WebElement getCreditCardPayButton() { return creditCardPayButton; }

    public WebElement getKlarnaPayButton() { return klarnaPayButton; }

    public WebElement getKlarnaPaymentOption() { return klarnaPaymentOption; }
}
