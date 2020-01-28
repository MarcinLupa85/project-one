package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.HomePageObject;
import utils.WaitUtils;

public class HomePageOperations {

    private HomePageObject homePageObject;
    private WaitUtils waitUtils;

    public HomePageOperations(WebDriver driver) {
        homePageObject = new HomePageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void openEaseePurchaseFlow() {
        homePageObject.getPurchaseFlowEaseeLink().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void openMennekesPurchaseFlow() {
        homePageObject.getPurchaseFlowMennekesLink().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

}
