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

    public void fillBillingAddress(String address) {
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingAddressInput());
        addressPageObject.getBillingAddressInput().sendKeys(address);
    }

    public void fillBillingZipCode(String zipCode) {
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingZipCodeInput());
        addressPageObject.getBillingZipCodeInput().sendKeys(zipCode);
    }

    public void fillBillingCity(String city) {
        waitUtils.waitForVisiblityOf(addressPageObject.getBillingCityInput());
        addressPageObject.getBillingCityInput().sendKeys(city);
    }

    public void fillCondominiumName(String condominium) {
        waitUtils.waitForVisiblityOf(addressPageObject.getCondominiumInput());
        addressPageObject.getCondominiumInput().sendKeys(condominium);
    }

    public void fillParkingPlace(String parkingPlace) {
        waitUtils.waitForVisiblityOf(addressPageObject.getParkingPlaceInput());
        addressPageObject.getParkingPlaceInput().sendKeys(parkingPlace);
    }

    public void clickNext() {
        addressPageObject.getNextButton().click();
        waitUtils.waitForUrlToContains("/house-order/confirm-order");
    }

    public void clickNextApartmentFlow() {
        addressPageObject.getNextButton().click();
        waitUtils.waitForUrlToContains("/apartment-order/confirm-order");
    }

}