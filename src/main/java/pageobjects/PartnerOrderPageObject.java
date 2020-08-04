package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerOrderPageObject {
    public PartnerOrderPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#id1 .product-with-installation-checkbox")
    private WebElement installationCheckbox;

    @FindBy(id = "client_first_name")
    private WebElement firstName;

    @FindBy(id = "client_last_name")
    private WebElement lastName;

    @FindBy(id = "client_email")
    private WebElement mail;

    @FindBy(id = "client_phone")
    private WebElement phone;

    @FindBy(id = "installation_address_address")
    private WebElement address;

    @FindBy(id = "installation_address_zip_code")
    private WebElement zipCode;

    @FindBy(id = "installation_address_city")
    private WebElement city;

    @FindBy(css = "[class='btn btn-primary large']")
    private WebElement submitButton;

    public WebElement getInstallationCheckbox() { return installationCheckbox; }

    public WebElement getFirstName() { return firstName; }

    public WebElement getLastName() { return lastName; }

    public WebElement getMail() { return mail; }

    public WebElement getPhone() { return phone; }

    public WebElement getAddress() { return address; }

    public WebElement getZipCode() { return zipCode; }

    public WebElement getCity() { return city; }

    public WebElement getSubmitButton() { return submitButton; }
}
