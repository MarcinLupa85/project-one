package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SalesRepPageObject extends EvPage {

    public SalesRepPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dealerName")
    private WebElement dealerName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(css = "button[class='circle-arrow']")
    private WebElement arrowButton;

    @FindBy(xpath = "//*[contains(text(),' Fortsett til bestillingsskjema ')]")
    private WebElement goToFormButton;

    @FindBy(id = "ngb-typeahead-0-0")
    private WebElement dropdownFirstOption;

    @FindBy(css = "[class='btn btn-sm btn-secondary']")
    private WebElement addEaseeCharger;

    @FindBy(css = "label[for='withInstallation']")
    private WebElement installationCheckbox;

    @FindBy(xpath = "//*[contains(text(),' videre')]")
    private WebElement nextButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "billing-address")
    private WebElement address;

    @FindBy(id = "billing-zip")
    private WebElement zipCode;

    @FindBy(id = "billing-city")
    private WebElement city;

    @FindBy(css = "#payment-method > div > div[class='custom-control custom-checkbox']")
    private WebElement confirmationCheckbox;

    @FindBy(css = "button[type='submit']")
    private WebElement completeOrderButton;

}
