package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentPageObject {
    private ApartmentPageObject apartmentPageObject;

    public ApartmentPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#parkingUnits")
    private WebElement parkingUnits;

    @FindBy(css = "input#chargersNumber")
    private WebElement chargersNumber;

    @FindBy(id = "parkingType")
    private WebElement parkingType;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement costSubmitButton;

    @FindBy(css = "input#first_name")
    private WebElement firstName;

    @FindBy(css = "input#last_name")
    private WebElement lastName;

    @FindBy(css = "input#email")
    private WebElement email;

    @FindBy(css = "input#mobile")
    private WebElement mobile;

    @FindBy(css = "input#company")
    private WebElement comapany;

    @FindBy(css = "[id='00N1x000001qwx1']")
    private WebElement parkingPlaces;

    @FindBy(css = "input#zip")
    private WebElement zipCode;

    @FindBy(css = "#description")
    private WebElement description;

    @FindBy(css = "button.contact-branded-button")
    private WebElement contactSubmitButton;

    public WebElement getParkingUnits() { return parkingUnits; }

    public WebElement getChargersNumber() { return chargersNumber; }

    public WebElement getParkingType() { return  parkingType; }

    public WebElement getCostSubmitButton() { return costSubmitButton; }

    public WebElement getFirstName() { return firstName; }

    public WebElement getLastName() { return lastName; }

    public WebElement getEmail() { return email; }

    public WebElement getMobile() { return mobile; }

    public WebElement getCompanyNameInput() { return comapany; }

    public WebElement getParkingPlaces() { return parkingPlaces; }

    public WebElement getZipCode() { return zipCode; }

    public WebElement getDescription() { return description; }

    public WebElement getContactSubmitButton() { return contactSubmitButton; }
}
