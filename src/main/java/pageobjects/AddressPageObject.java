package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPageObject {

    public AddressPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billingAddress")
    private WebElement billingAddressInput;

    @FindBy(id = "billingZip")
    private WebElement billingZipCodeInput;

    @FindBy(id = "billingCity")
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

    @FindBy(id = "condominium_name")
    private WebElement condominiumInput;

    @FindBy(id = "parkingPlace0")
    private WebElement parkingPlaceInput;

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

    public WebElement getCondominiumInput() { return condominiumInput; }

    public WebElement getParkingPlaceInput() { return parkingPlaceInput; }

    public WebElement getNextButton() {
        return nextButton;
    }

}
