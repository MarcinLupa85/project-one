package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.SummaryPageObject;
import utils.DriverUtils;
import utils.WaitUtils;

import static org.testng.Assert.assertEquals;

public class SummaryPageOperations {

    private SummaryPageObject summaryPageObject;
    private WaitUtils waitUtils;
    private DriverUtils driverUtils;
    private WebDriver webDriver;
    private static final String VISA = "4988 4388 4388 4305";
    private static final String MASTERCARD = "5101 1800 0000 0007";

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
        return driverUtils.isElementPresent(By.xpath(".//dt[contains(text(), 'Rabatt')]"));
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
        waitUtils.waitForPresentOf(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        webDriver.switchTo().frame(inputFrameField);
        waitUtils.waitForVisiblityOf(summaryPageObject.getCreditCardNumber());
        summaryPageObject.getCreditCardNumber().sendKeys(creditCardNumber);
        webDriver.switchTo().defaultContent();
    }

    public void fillExpiryDate(String expiryDate) {
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']:nth-child(1)"));
        webDriver.switchTo().frame(inputFrameField);
        summaryPageObject.getExpiryDate().sendKeys(expiryDate);
        webDriver.switchTo().defaultContent();
    }

    public void fillSecurityCode(String securityCode) {
        WebElement inputFrameField = webDriver.findElement(By.cssSelector("div.adyen-checkout__field--securityCode iframe[title='Iframe for secured card data input field']"));
        webDriver.switchTo().frame(inputFrameField);
        summaryPageObject.getSecurityCode().sendKeys(securityCode);
        webDriver.switchTo().defaultContent();
    }

    public void chooseKlarnaOption() {
        waitUtils.waitForVisiblityOf(summaryPageObject.getKlarnaPaymentOption());
        summaryPageObject.getKlarnaPaymentOption().click();
    }

    public void payWithKlarna() { summaryPageObject.getKlarnaPayButton().click(); }

    public void assertExtraDiscount(boolean extraDiscount) {
        assertEquals(hasExtraDiscount(), extraDiscount);
    }

    public void pay(String paymentMethod, boolean fourteenDaysInstallation) {
        switch (paymentMethod) {
            case "Invoice":
                chooseInvoiceOption();
                chooseInstallation(fourteenDaysInstallation);
                clickFinish();
                break;
            case "Visa":
                chooseCreditCardOption();
                chooseInstallation(fourteenDaysInstallation);
                payWithCreditCard(VISA);
                break;
            case "Mastercard":
                chooseCreditCardOption();
                chooseInstallation(fourteenDaysInstallation);
                payWithCreditCard(MASTERCARD);
                break;
            case "Klarna":
                chooseCreditCardOption();
                chooseInstallation(fourteenDaysInstallation);
                chooseKlarnaOption();
                payWithKlarna();
                break;
        }
    }

    private void chooseInstallation(boolean fourteenDaysInstallation) {
        tickTermsAndConditionsCheckbox();
        if (fourteenDaysInstallation) {
            tick14DaysCheckbox();
        }
    }
}
