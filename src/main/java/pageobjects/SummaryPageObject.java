package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SummaryPageObject extends EvPage {
    public SummaryPageObject(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//button[contains(text(),'Betal med Klarna eller bankkort')]")
    private WebElement creditCardOption;

    @FindBy(xpath = "//button[contains(text(),'Betal med faktura')]")
    private WebElement invoiceOption;

    @FindBy(id = "encryptedCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "encryptedExpiryDate")
    private WebElement expiryDate;

    @FindBy(id = "encryptedSecurityCode")
    private WebElement securityCode;

    @FindBy(xpath = "//*[contains(text(),'Kredittkort')]")
    private WebElement creditCardPaymentOption;

    @FindBy(xpath = "//*[contains(text(),'Betal kr')]")
    private WebElement creditCardPayButton;

    @FindBy(xpath = "//*[contains(text(),'Del opp. Klarna.')]")
    private WebElement klarnaPaymentOption;

    @FindBy(xpath = "//*[contains(text(),'Fortsett til Del opp. Klarna.')]")
    private WebElement klarnaPayButton;

    @FindBy(css = "h3[class='heading-3 text-center']")
    private WebElement completeOrderPageText;

    @FindBy(css = "i[class='icon-cross mx-auto mb-s']")
    private WebElement cancelledOrderPageText;

}
