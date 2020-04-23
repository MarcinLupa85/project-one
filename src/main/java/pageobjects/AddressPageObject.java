package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPageObject {

    public AddressPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#billing_address_address")
    private WebElement billingAddressInput;

    @FindBy(css = "input#billing_address_zip_code")
    private WebElement billingZipCodeInput;

    @FindBy(css = "input#billing_address_city")
    private WebElement billingCityInput;

    @FindBy(css = "input#installation_address_address")
    private WebElement installationAddressInput;

    @FindBy(css = "input#installation_address_zip_code")
    private WebElement installationZipCodeInput;

    @FindBy(css = "input#installation_address_city")
    private WebElement installationCityInput;

    @FindBy(css = "i.radio-circle__icon")
    private WebElement installationAddressCheckbox;

    @FindBy(css = "textarea#comment")
    private WebElement commentInput;

    @FindBy(css = "a[href=\"/hjemmelading-bestill/customize-order\"]")
    private WebElement backButton;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement nextButton;

    public WebElement getBillingAddressInput() {
        return billingAddressInput;
    }

    public WebElement getBillingZipCodeInput() {
        return billingZipCodeInput;
    }

    public WebElement getBillingCityInput() {
        return billingCityInput;
    }

    public WebElement getInstallationAddressInput() {
        return installationAddressInput;
    }

    public WebElement getInstallationZipCodeInput() {
        return installationZipCodeInput;
    }

    public WebElement getInstallationCityInput() {
        return installationCityInput;
    }

    public WebElement getInstallationAddressCheckbox() {
        return installationAddressCheckbox;
    }

    public WebElement getCommentInput() {
        return commentInput;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

}
