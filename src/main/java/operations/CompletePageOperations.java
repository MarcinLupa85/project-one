package operations;

import org.openqa.selenium.WebDriver;
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

    public boolean verifyEmail(){

        if ( addressPageObject.)
    }

    public void clickBack() {
        completePageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/home");
    }
}
