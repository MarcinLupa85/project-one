package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.AddressPageObject;
import pageobjects.CompletePageObject;
import utils.WaitUtils;

public class CompletePageOperations {

    private CompletePageObject completePageObject;
    private WaitUtils waitUtils;

    public CompletePageOperations (WebDriver driver) {
        completePageObject = new CompletePageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void clickBack() {
        waitUtils.waitForVisiblityOf(completePageObject.getBackButton());
        waitUtils.waitForElementToBeClickable(completePageObject.getBackButton());
        completePageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/elbillading");
    }
}
