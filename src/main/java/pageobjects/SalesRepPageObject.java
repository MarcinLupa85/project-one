package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SalesRepPageObject {

    public SalesRepPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

}
