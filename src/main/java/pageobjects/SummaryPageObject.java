package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SummaryPageObject {
    public SummaryPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.custom-radio")
    private WebElement tcCheckbox;

    @FindBy(css = "iframe[title='Iframe for secured card data input field']")
    private WebElement cardIFrame;

    @FindBy(css = "iframe[title='Iframe for secured card data input field']:nth-child(1)")
    private WebElement expiryDateIFrame;

    @FindBy(css = "div.adyen-checkout__field--securityCode iframe[title='Iframe for secured card data input field']")
    private WebElement securityCodeIFrame;

    @FindBy(css = "button[type=submit]")
    private WebElement finishOrderButton;

    @FindBy(css = "div.list-group.list-group-sm.list-group-pills > button:nth-child(1)")
    private WebElement creditCardOption;

    @FindBy(xpath = "//button[contains(text(),' Betal med faktura ')]")
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

}
