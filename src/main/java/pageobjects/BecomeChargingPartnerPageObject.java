package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BecomeChargingPartnerPageObject {
    public BecomeChargingPartnerPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[data-action='KONTAKT MEG']")
    private WebElement contactUsButton;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "membershipOrganization")
    private WebElement membershipOrganization;

    @FindBy(id = "parkingUnits")
    private WebElement parkingUnits;

    @FindBy(css = "button[data-action='Send']")
    private WebElement sendButton;

    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getMembershipOrganization() {
        return membershipOrganization;
    }

    public WebElement getParkingUnits() {
        return parkingUnits;
    }

    public WebElement getSendButton() {
        return sendButton;
    }
}
