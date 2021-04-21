package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.AddressPageObject;
import pageobjects.CompletePageObject;
import utils.WaitUtils;

public class CompletePageOperations {

    private CompletePageObject completePageObject;
    private AddressPageObject addressPageObject;
    private WaitUtils waitUtils;

    public CompletePageOperations (WebDriver driver) {
        completePageObject = new CompletePageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public String getEmail(){
        WebElement email = completePageObject.getEmailText();
        waitUtils.waitForVisiblityOf(email);
        return email.getText();
    }

    public void clickBack() {
        waitUtils.waitForVisiblityOf(completePageObject.getBackButton());
        waitUtils.waitForElementToBeClickable(completePageObject.getBackButton());
        completePageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/elbillading");
    }
}
