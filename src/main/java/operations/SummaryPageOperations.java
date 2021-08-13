package operations;

import enums.PAYMENTMETHODS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SummaryPageObject;
import utils.DriverUtils;
import utils.WaitUtils;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class SummaryPageOperations {

    private SummaryPageObject summaryPageObject;
    private WaitUtils waitUtils;
    private DriverUtils driverUtils;
    private CompletePageOperations completePageOperations;
    private WebDriver driver;
    private static final String visaCardNumber = "4988 4388 4388 4305";
    private static final String mastercardCardNumber = "5101 1800 0000 0007";

    public SummaryPageOperations (WebDriver driver) {
        summaryPageObject = new SummaryPageObject(driver);
        waitUtils = new WaitUtils(driver);
        driverUtils = new DriverUtils(driver);
        completePageOperations = new CompletePageOperations(driver);
        this.driver = driver;
    }

    public void tickTermsAndConditionsCheckbox() {
        WebElement termsAndConditionsCheckbox = summaryPageObject.getTcCheckbox();
        WebElement navigation = driver.findElement(By.cssSelector("a[href='/elbillading']"));
        waitUtils.bringElementToViewport(navigation);
        termsAndConditionsCheckbox.click();
    }

    public void clickFinish() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContains("/complete");
    }

    public void payWithCreditCard(String cardNumber) {
        fillCreditCardNumber(cardNumber);
        fillExpiryDate("0330");
        fillSecurityCode("737");
        summaryPageObject.getCreditCardPayButton().click();
    }

    public void chooseCreditCardOption() { summaryPageObject.getCreditCardOption().click(); }

    public void chooseInvoiceOption() { summaryPageObject.getInvoiceOption().click(); }

    public void fillCreditCardNumber(String creditCardNumber) {
        WebElement inputFrameField = summaryPageObject.getCardIFrame();
        waitUtils.waitForVisiblityOf(inputFrameField);
        driver.switchTo().frame(inputFrameField);
        waitUtils.waitForVisiblityOf(summaryPageObject.getCreditCardNumber());
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
        waitUtils.waitForVisiblityOf(summaryPageObject.getKlarnaPaymentOption());
        summaryPageObject.getKlarnaPaymentOption().click();
    }

    public void payWithKlarna(){
        summaryPageObject.getKlarnaPayButton().click();
        waitUtils.waitForUrlToContains("klarna.com");
    }

    public void pay(PAYMENTMETHODS paymentMethod){
        switch (paymentMethod) {
            case INVOICE:
                chooseInvoiceOption();
                tickTermsAndConditionsCheckbox();
                clickFinish();
                completePageOperations.clickBack();
                break;
            case VISA:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(visaCardNumber);
                completePageOperations.clickBack();
                break;
            case MASTERCARD:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                payWithCreditCard(mastercardCardNumber);
                completePageOperations.clickBack();
                break;
            case KLARNA:
                chooseCreditCardOption();
                tickTermsAndConditionsCheckbox();
                chooseKlarnaOption();
                payWithKlarna();
                break;
        }
    }

}
