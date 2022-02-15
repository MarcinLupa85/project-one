package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.CompletePageObject;

public class CompletePageOperations extends BaseOperations {

    private CompletePageObject completePageObject;

    public CompletePageOperations(WebDriver driver) {
        super(driver);
        completePageObject = new CompletePageObject(driver);
    }

    public void clickBack() {
        waitUtils.waitForVisibilityOf(completePageObject.getBackButton());
        waitUtils.waitForElementToBeClickable(completePageObject.getBackButton());
        completePageObject.getBackButton().click();
        waitUtils.waitForUrlToContain("/elbillading");
    }
}
