package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.SummaryPageObject;
import utils.DriverUtils;
import utils.WaitUtils;

public class SummaryPageOperations {

    private SummaryPageObject summaryPageObject;
    private WaitUtils waitUtils;
    private DriverUtils driverUtils;
    private WebDriver webDriver;

    public SummaryPageOperations (WebDriver driver) {
        summaryPageObject = new SummaryPageObject(driver);
        waitUtils = new WaitUtils(driver);
        driverUtils = new DriverUtils(driver);
        webDriver = driver;
    }

    public void tickTermsAndConditionsCheckbox() {
        WebElement termsAndConditionsCheckbox = summaryPageObject.getTcCheckbox();
        waitUtils.bringElementToViewport(termsAndConditionsCheckbox);
        termsAndConditionsCheckbox.click();
    }

    public void clickFinish() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContains("/house-order/complete");
    }

    public void clickFinishApartmentFlow() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContains("/apartment-order/complete");
    }

    public boolean hasExtraDiscount() {
        return driverUtils.isElementPresent(By.xpath(".//dt[contains(text(), 'Rabat')]"));
    }

    public void payWithCreditCard(String cardNumber) {
        fillCreditCardNumber(cardNumber);
        fillExpiryDate("0330");
        fillSecurityCode("737");
        summaryPageObject.getCreditCardPayButton().click();
    }

    public void tick14DaysCheckbox() {
        summaryPageObject.getFourteenDaysCheckbox().click();
    }

    public void chooseCreditCardOption() { summaryPageObject.getCreditCardOption().click(); }

    public void chooseInvoiceOption() { summaryPageObject.getInvoiceOption().click(); }

    public void fillCreditCardNumber(String creditCardNumber) {
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        webDriver.switchTo().frame(inputFrameField);
        summaryPageObject.getCreditCardNumber().sendKeys(creditCardNumber);
    }

    public void fillExpiryDate(String expiryDate) {
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']:nth-child(1)"));
        webDriver.switchTo().frame(inputFrameField);
        summaryPageObject.getExpiryDate().sendKeys(expiryDate);
    }

    public void fillSecurityCode(String securityCode) {
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']:nth-child(2)"));
        webDriver.switchTo().frame(inputFrameField);
        summaryPageObject.getSecurityCode().sendKeys(securityCode);
    }

    public void chooseKlarnaOption() { summaryPageObject.getKlarnaPaymentOption().click(); }

    public void payWithKlarna() { summaryPageObject.getKlarnaPayButton().click(); }

}
