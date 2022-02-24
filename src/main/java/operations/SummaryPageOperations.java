package operations;

import enums.PaymentMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.SummaryPageObject;

import static org.assertj.core.api.Assertions.assertThat;

public class SummaryPageOperations extends BaseOperations {

    private SummaryPageObject summaryPageObject;
    private static final String visaCardNumber = "4988 4388 4388 4305";
    private static final String mastercardCardNumber = "5101 1800 0000 0007";
    private static final String twoFactorCardNumberType1 = "5212 3456 7890 1234";
    public static final String twoFactorCardNumberType2 = "4917 6100 0000 0000";

    public SummaryPageOperations(WebDriver driver) {
        super(driver);
        summaryPageObject = new SummaryPageObject(driver);
    }

    public void tickTermsAndConditionsCheckbox() {
        WebElement termsAndConditionsCheckbox = summaryPageObject.getTcCheckbox();
        waitUtils.waitForElement(termsAndConditionsCheckbox);
        WebElement navigation = driver.findElement(By.cssSelector("a[href='/elbillading']"));
        waitUtils.bringElementToViewport(navigation);
        termsAndConditionsCheckbox.click();
    }

    public void clickFinish() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContain("/complete");
    }

    public void payWithCreditCard(String cardNumber) {
        waitUtils.waitForElementToBeClickable(summaryPageObject.getCreditCardPaymentOption());
        summaryPageObject.getCreditCardPaymentOption().click();
        fillCreditCardNumber(cardNumber);
        fillExpiryDate("0330");
        fillSecurityCode("737");
        summaryPageObject.getCreditCardPayButton().click();
    }

    public void chooseCreditCardOption() {
        waitUtils.waitForElementToBeClickable(summaryPageObject.getCreditCardOption());
        summaryPageObject.getCreditCardOption().click();
    }

    public void chooseInvoiceOption() {
        waitUtils.waitForElementToBeClickable(summaryPageObject.getInvoiceOption());
        summaryPageObject.getInvoiceOption().click();
    }

    public void fillCreditCardNumber(String creditCardNumber) {
        WebElement inputFrameField = summaryPageObject.getCardIFrame();
        waitUtils.waitForVisibilityOf(inputFrameField);
        driver.switchTo().frame(inputFrameField);
        waitUtils.waitForVisibilityOf(summaryPageObject.getCreditCardNumber());
        summaryPageObject.getCreditCardNumber().sendKeys(creditCardNumber);
        driver.switchTo().defaultContent();
    }

    public void fillExpiryDate(String expiryDate) {
        WebElement inputFrameField = summaryPageObject.getExpiryDateIFrame();
        driver.switchTo().frame(inputFrameField);
        summaryPageObject.getExpiryDate().sendKeys(expiryDate);
        driver.switchTo().defaultContent();
    }

    public void fillSecurityCode(String securityCode) {
        WebElement inputFrameField = summaryPageObject.getSecurityCodeIFrame();
        driver.switchTo().frame(inputFrameField);
        summaryPageObject.getSecurityCode().sendKeys(securityCode);
        driver.switchTo().defaultContent();
    }

    public void chooseKlarnaOption() {
        waitUtils.waitForVisibilityOf(summaryPageObject.getKlarnaPaymentOption());
        summaryPageObject.getKlarnaPaymentOption().click();
    }

    public void payWithKlarna() {
        summaryPageObject.getKlarnaPayButton().click();
        waitUtils.waitForUrlToContain("klarna.com");
    }

    public void twoFactorAuthentication3DS1() {
        waitUtils.waitForUrlToContain("test.adyen.com");
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void twoFactorAuthentication3DS2() {
        waitUtils.waitForUrlToContain("/identifyShopper");
        driver.switchTo().frame("threeDSIframe");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.switchTo().defaultContent();
    }

    public void assertThankYouPage() {
        waitUtils.waitForElement(summaryPageObject.getCompleteOrderPageText());
        assertThat(summaryPageObject.getCompleteOrderPageText().getText()).contains("Gratulerer");
    }

    public void assertCancelledOrderPage() {
        waitUtils.waitForElement(summaryPageObject.getCancelledOrderPageText());
        assertThat(summaryPageObject.getCancelledOrderPageText().getText()).containsIgnoringCase("Orderen din er blitt avbrutt");
    }

    public void assertNextStepPage() {
        waitUtils.waitForElement(summaryPageObject.getCompleteOrderPageText());
        assertThat(summaryPageObject.getCompleteOrderPageText().getText()).contains("Nesten ferdig...");
    }

    public void pay(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case INVOICE:
                chooseInvoiceOption();
                tickTermsAndConditionsCheckbox();
                clickFinish();
                break;
            case VISA:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(visaCardNumber);
                break;
            case MASTERCARD:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(mastercardCardNumber);
                break;
            case KLARNA:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                chooseKlarnaOption();
                payWithKlarna();
                break;
            case TWOFACTORTYPE1:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(twoFactorCardNumberType1);
                twoFactorAuthentication3DS1();
                break;
            case TWOFACTORTYPE2:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(twoFactorCardNumberType2);
                twoFactorAuthentication3DS2();
        }
    }

}
