package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.AddressPageObject;
import utils.WaitUtils;

public class AddressPageOperations {

    private AddressPageObject addressPageObject;
    private WaitUtils waitUtils;

    public AddressPageOperations (WebDriver driver) {
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

    public void fillClientInfo(String address, String city, String zipcode, boolean fourteenDaysInstallation) {
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingAddressInput());
        addressPageObject.getBillingAddressInput().sendKeys(address);
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingCityInput());
        addressPageObject.getBillingCityInput().sendKeys(city);
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingZipCodeInput());
        addressPageObject.getBillingZipCodeInput().sendKeys(zipcode);
        addressPageObject.getCommentInput().sendKeys("Test comment");
        tick14DaysCheckbox(fourteenDaysInstallation);

    }

    public void tick14DaysCheckbox(boolean fourteenDaysInstallation) {
        if (fourteenDaysInstallation) {
            addressPageObject.getFourteenDaysCheckbox().click();
        }
        clickNext();
    }
}