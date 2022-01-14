package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.AddressPageObject;
import testdata.ClientInfo;
import utils.WaitUtils;

public class AddressPageOperations {

    private AddressPageObject addressPageObject;
    private WaitUtils waitUtils;

    public AddressPageOperations(WebDriver driver) {
        addressPageObject = new AddressPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void fillParkingPlace(String parkingPlace) {
        waitUtils.waitForVisiblityOf(addressPageObject.getParkingPlaceInput());
        addressPageObject.getParkingPlaceInput().sendKeys(parkingPlace);
    }

    public void clickNext() {
        addressPageObject.getNextButton().click();
        waitUtils.waitForUrlToContain("/confirm-order");
    }

    public void fillClientInfo(ClientInfo clientInfo) {
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingAddressInput());
        addressPageObject.getBillingAddressInput().sendKeys(clientInfo.getAddress());
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingCityInput());
        addressPageObject.getBillingCityInput().sendKeys(clientInfo.getCity());
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingZipCodeInput());
        addressPageObject.getBillingZipCodeInput().sendKeys(clientInfo.getZipcode());
        addressPageObject.getCommentInput().sendKeys(clientInfo.getComment());
        tick14DaysCheckbox(clientInfo.isFourteenDaysInstallation());
    }

    public void tick14DaysCheckbox(boolean fourteenDaysInstallation) {
        if (fourteenDaysInstallation) {
            addressPageObject.getFourteenDaysCheckbox().click();
        }
        clickNext();
    }
}
