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

    public void fillInstallationAddress(String address) {
        waitUtils.waitForVisiblityOf(addressPageObject.getInstallationAddressInput());
        addressPageObject.getInstallationAddressInput().sendKeys(address);
    }

    public void fillInstallationZipCode(String zipCode) {
        waitUtils.waitForVisiblityOf(addressPageObject.getInstallationZipCodeInput());
        addressPageObject.getInstallationZipCodeInput().sendKeys(zipCode);
    }

    public void fillInstallationCity(String city) {
        waitUtils.waitForVisiblityOf(addressPageObject.getInstallationCityInput());
        addressPageObject.getInstallationCityInput().sendKeys(city);
    }

    public void fillComment(String comment) {
        waitUtils.waitForVisiblityOf(addressPageObject.getInstallationCityInput());
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