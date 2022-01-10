package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class SalesRepPageObject {
    private WaitUtils waitUtils;

    public SalesRepPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
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

    @FindBy(xpath = "//*[contains(text(),' videre')]")
    private WebElement nextButton;

    @FindBy(id = "full-name")
    private WebElement name;

    @FindBy(id = "billing-address")
    private WebElement address;

    @FindBy(id = "billing-zip")
    private WebElement zipCode;

    @FindBy(id = "billing-city")
    private WebElement city;

    @FindBy(css = "div[class='custom-control custom-checkbox']")
    private WebElement confirmationCheckbox;

    @FindBy(xpath = "//*[contains(text(),'bestilling')]")
    private WebElement completeOrderButton;


    public WebElement getDealerName() {
        return waitUtils.waitForElementToBeClickable(dealerName);
    }

    public WebElement getEmail() {
        return waitUtils.waitForElementToBeClickable(email);
    }

    public WebElement getArrowButton() {
        return arrowButton;
    }

    public WebElement getGoToFormButton() {
        return waitUtils.waitForElementToBeClickable(goToFormButton);
    }

    public WebElement getDropdownFirstOption() {
        return waitUtils.waitForElementToBeClickable(dropdownFirstOption);
    }

    public WebElement getAddEaseeCharger() {
        return addEaseeCharger;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getName() {
        return waitUtils.waitForElementToBeClickable(name);
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getConfirmationCheckbox() {
        return confirmationCheckbox;
    }

    public WebElement getCompleteOrderButton() {
        return waitUtils.waitForElementToBeClickable(completeOrderButton);
    }
}
