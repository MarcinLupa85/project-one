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

    public void clickNext() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/complete");
    }

    public boolean hasExtraDiscount(){ ;
        return driverUtils.isElementPresent(By.cssSelector("p.extra-discount"));
    }


}
