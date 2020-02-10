package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.SummaryPageObject;
import utils.WaitUtils;

public class SummaryPageOperations {

    private SummaryPageObject summaryPageObject;
    private WaitUtils waitUtils;

    public SummaryPageOperations (WebDriver driver) {
        summaryPageObject = new SummaryPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void tickTcCheckbox() {
        summaryPageObject.getTcCheckbox().click();
    }

    public void clickNext() {
        summaryPageObject.getFinishOrderButton().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/complete");
    }

}
