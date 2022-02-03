package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.MasterCardPageObject;
import utils.WaitUtils;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.Partner.MASTERCARD_PAGE;
import static testdata.EvRoutes.Partner.MASTERCARD_CONFIRMATION;

public class MasterCardPageOperations extends BaseOperations {

    private MasterCardPageObject masterCardPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public MasterCardPageOperations(WebDriver driver) {
        super(driver);
        masterCardPageObject = new MasterCardPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void goToMastercardPage() {
        driver.navigate().to(BASE_URL + MASTERCARD_PAGE);
    }

    public void clickLoginButton() {
        masterCardPageObject.getLogInButton().click();
    }

    public void confirmMastercardBanner() {
        waitUtils.waitForUrlToContain(MASTERCARD_CONFIRMATION);
        assertThat(masterCardPageObject.getMastercardBanner().isDisplayed());
    }
}
