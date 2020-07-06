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

    public SummaryPageOperations (WebDriver driver) {
        summaryPageObject = new SummaryPageObject(driver);
        waitUtils = new WaitUtils(driver);
        driverUtils = new DriverUtils(driver);
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

    public boolean hasExtraDiscount(){
        return driverUtils.isElementPresent(By.xpath(".//h4[contains(text(), 'EXTRA Club medlemsrabatt')]"));
    }

    public void tick14DaysCheckbox() {
        summaryPageObject.getFourteenDaysCheckbox().click();
    }

}
