package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        addressPageObject.getBillingAddressInput().sendKeys(address);
    }

    public void fillBillingZipCode(String zipCode) {
        addressPageObject.getBillingZipCodeInput().sendKeys(zipCode);
    }

    public void fillBillingCity(String city) {
        addressPageObject.getBillingCityInput().sendKeys(city);
    }

    public void fillInstallationAddress(String address) {
        addressPageObject.getInstallationAddressInput().sendKeys(address);
    }

    public void fillInstallationZipCode(String zipCode) {
        addressPageObject.getInstallationZipCodeInput().sendKeys(zipCode);
    }

    public void fillInstallationCity(String city) {
        addressPageObject.getInstallationCityInput().sendKeys(city);
    }

    public void fillComment(String comment) {
        addressPageObject.getInstallationCityInput().sendKeys(comment);
    }

    public void tickInstallationAddressCheckbox() {
        addressPageObject.getInstallationAddressCheckbox().click();
    }

    public void clickNext() {
        addressPageObject.getNextButton().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/confirm-order");
    }

    public void clickBack() {
        addressPageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

}
